package com.biz.shop.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.shop.domain.ProductVO;
import com.biz.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/admin/product")
@Controller
public class ProductController {
	
	private final ProductService proService;
	
	@RequestMapping(value= {"","/"},method=RequestMethod.GET)
	public String product(
			@RequestParam(value="search",
					required = false, defaultValue = "0") String search,
			@RequestParam(value="text",
					required = false, defaultValue = "") String text,
			Model model) {
		
		if(search.equals("0")) {
			List<ProductVO> proList = proService.selectAll();
		} else {
			// 검색 list
		}
		
		ProductVO productVO = new ProductVO();

		List<ProductVO> proList = proService.selectAll();
		model.addAttribute("PRO_LIST",proList);

		model.addAttribute("search",search);
		model.addAttribute("text",text);
		
		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","PRODUCT");
		return "admin/main";

	}

	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String product(
			@Valid @ModelAttribute ProductVO productVO,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("BODY","PRODUCT");
			return "admin/main";
		}
		
		proService.save(productVO);
		return "redirect:/admin/product";
		

	}
	
}


