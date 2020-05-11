package com.biz.shop.service;

import java.util.List;

import com.biz.shop.domain.UserDetailsVO;

public interface UserService {

	/**
	 * username과 password만 받아서 회원가입
	 * @param username
	 * @param password
	 * @return
	 */
	public int insert(String username, String password) ;
	
	/**
	 * UserDetailsVO를 받아서 회원가입
	 * @param userVO
	 * @return
	 */
	public int insert(UserDetailsVO userVO) ;
	
	/**
	 * 회원 전체 리스트
	 * @return
	 */
	public List<UserDetailsVO> selectAll() ;

	/**
	 * UserDetailesVO만 받아서 업데이트
	 * @param userVO
	 * @return
	 */
	public int update(UserDetailsVO userVO) ;
	
	/**
	 * UserDetailsVO와 authList(권한 리스트)를 받아서 업데이트
	 * @param userVO
	 * @param authList
	 * @return
	 */
	public int update(UserDetailsVO userVO,String[] authList) ;
	
	/**
	 * username 중복체크
	 * @param username
	 * @return
	 */
	public boolean isExistsUserName(String username) ;
	
	
	/**
	 * 비밀번호 일치하는지 체크 
	 * @param password
	 * @return
	 */
	public boolean check_password(String password) ;
	
	/**
	 * update를 위한 User정보 조회
	 * id : PK
	 * @param id
	 * @return
	 */
	public UserDetailsVO findById(long id) ;
	
	/**
	 * 회원이름으로 조회
	 * @param username
	 * @return
	 */
	public UserDetailsVO findByUserName(String username) ;
	
}



