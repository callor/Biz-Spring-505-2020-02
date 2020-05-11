package com.biz.shop.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biz.shop.domain.AuthorityVO;
import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.persistance.AuthoritiesDao;
import com.biz.shop.persistance.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AuthoritiesDao authDao;
	private final UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// spring security가 사용할 DetailVO 선언
		UserDetailsVO userVO = userDao.findByUserName(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("User Name이 없습니다");
		}

		// 사용자 정보를 사용할수 있는가 아닌가를 세밀하게
		// 제어하기 위한 칼럼
		userVO.setAccountNonExpired(true);
		userVO.setAccountNonLocked(true);
		userVO.setCredentialsNonExpired(true);
		
		userVO.setAuthorities(this.getAuthorities(username));
		return userVO;
	
	}
	
	/**
	 * authorities 테이블에서 권한 리스트를 가져오기 
	 */
	private Collection<GrantedAuthority> getAuthorities(String username) {
		
		List<AuthorityVO> authList = authDao.findByUserName(username);
		List<GrantedAuthority> authorities 
				= new ArrayList<GrantedAuthority>();
		
		for(AuthorityVO vo : authList) {
			SimpleGrantedAuthority sAuth 
				= new SimpleGrantedAuthority(vo.getAuthority());
			authorities.add(sAuth);
		}
		return authorities;
	
	}
	
}









