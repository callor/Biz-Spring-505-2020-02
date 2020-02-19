package com.biz.shop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/user/product")
@Controller
public class B2C_Controller {
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list() {
		return null;
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail() {
		return null;
	}
	
	
	
	
	
	

}
