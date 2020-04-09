package com.biz.sec.persistance;

import java.util.List;

import com.biz.sec.domain.UserVO;

public interface UserDao {

	public List<UserVO> selectAll();
	public UserVO findByUserName(String username);
	public int insert(UserVO userVO);
	
}
