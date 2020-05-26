package com.biz.shop.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.shop.domain.ProOptionsVO;

public interface ProOptionsDao {
	
	@Select("SELECT * FROM tbl_options WHERE o_division = 'COLOR' ")
	public List<ProOptionsVO> getColorList();
	
	@Select("SELECT * FROM tbl_options WHERE o_division = 'SIZE' ")
	public List<ProOptionsVO> getSizeList();
	
}
