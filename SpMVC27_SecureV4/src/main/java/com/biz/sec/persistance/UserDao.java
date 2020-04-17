package com.biz.sec.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.sec.domain.UserDetailsVO;

public interface UserDao {

	public List<UserDetailsVO> selectAll();
		
	public void create_table(String create_table);
	
	@Select(" SELECT id, "
			+ " user_name AS username, "
			+ " user_pass AS password, "
			+ " enabled, "
			+ " email,phone,address "
			+ " FROM tbl_users WHERE user_name = #{username} ")
	public UserDetailsVO findByUserName(String username);
	
	public int insert(UserDetailsVO userVO);

	
	public UserDetailsVO findById(long id);

	public int update(UserDetailsVO userVO);
	
}












