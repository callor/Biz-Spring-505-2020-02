package com.biz.sec.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.sec.domain.UserVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	// @Autowirted
	private final PasswordEncoder passworEncoder;
	
	/*
	 * 회원가입을 신청하면 비밀번호는 암호화하고
	 * 아이디와 비번을 DB insert 수행
	 */
	public int insert(String username, String password) {
		
		UserVO usreVO = new UserVO();
			
		
		
		return 0;
	}
	
	
}
