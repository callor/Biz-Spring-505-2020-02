package com.biz.models.service;

import org.springframework.stereotype.Service;

import com.biz.models.domain.UsersVO;

@Service
public class UserService {
	
	public UsersVO getUser(String userId) {
		UsersVO userVO = UsersVO.builder()
				.userId("admin")
				.password("12345")
				.userName("홍길동")
				.userRolle("admin")
				.build();
		
		if(userId.equals("admin")) {
			return userVO;
		} else if(userId.equals("guest")) {
			userVO.setUserId("guest");
			userVO.setUserName("성춘향");
		} else if(userId.equals("dba")) {
			userVO.setUserId("dba");
			userVO.setUserName("이몽룡");
		} else {
			userVO = null;
		}
		return userVO;
	}

}
