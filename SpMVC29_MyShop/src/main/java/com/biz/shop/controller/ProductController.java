package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.domain.ProductOptionsVO;
import com.biz.shop.domain.ProductVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@ModelAttribute("productVO")
	public ProductVO newProductVO() {
		return new ProductVO();
	}
	
	public String list() {
		return "product/list";
	}

	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(ProductVO productVO, Model model) {
		
		ProductOptionsVO proOPT = new ProductOptionsVO();
		
		model.addAttribute("COLOR_LIST",proOPT.getColorList());
		model.addAttribute("SIZE_LIST",proOPT.getSizeList());
		
		return "product/pro_write";
	}

	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(ProductVO productVO) {
		
		log.debug("COLOR : {}",productVO.getP_color_list().toString());
		log.debug("SIZE : {}",productVO.getP_color_list().toString());
		
		return "redirect:/product/list";
	}

	public String deteilView(long id) {
		return "product/deteil";
	}

	public String update(long id) {
		return "product/write";
	}

	public String update(ProductVO productVO) {
		return "redirect:/product/list";
	}

	public String delete(long id) {
		return "redirect:/product/list";
	}

}
