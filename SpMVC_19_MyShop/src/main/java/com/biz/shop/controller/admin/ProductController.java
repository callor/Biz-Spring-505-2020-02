package com.biz.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.domain.ProductVO;

@RequestMapping(value="/admin/product")
@Controller
public class ProductController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String product(Model model) {
		
		ProductVO productVO = new ProductVO();
		
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

		model.addAttribute("productVO",productVO);
		model.addAttribute("BODY","PRODUCT");
		return "admin/main";

	}

	
	
}
