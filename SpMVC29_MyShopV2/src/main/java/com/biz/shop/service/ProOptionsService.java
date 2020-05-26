package com.biz.shop.service;

import java.util.List;

import com.biz.shop.domain.ProOptionsVO;

public interface ProOptionsService {
	
	public List<ProOptionsVO> getColorList();
	public List<ProOptionsVO> getSizeList();
	
	
}
