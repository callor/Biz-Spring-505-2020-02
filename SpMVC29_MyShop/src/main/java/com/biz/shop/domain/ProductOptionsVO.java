package com.biz.shop.domain;

import java.util.HashMap;
import java.util.Map;

public class ProductOptionsVO {

	private Map<String,String> colorList = new HashMap<String,String>();
	private Map<String,String> sizeList = new HashMap<String,String>();
	
	public Map<String,String> getColorList() {
		
		this.colorList.put("RED", "빨강");
		this.colorList.put("BLUE", "블루");
		this.colorList.put("NAVY", "네이비");
		this.colorList.put("WHITE", "화이트");
		return colorList;
	}
	
	public Map<String,String> getSizeList() {
		
		this.sizeList.put("S", "SMAL");
		this.sizeList.put("M", "MIDDLE");
		this.sizeList.put("L", "LARGE");
		this.sizeList.put("XL", "Extra Large");
		this.sizeList.put("XXL", "2 Extra Large");
		
		return sizeList;
	}

	
	
}
