package com.biz.shop.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.domain.DeptVO;
import com.biz.shop.service.DeptService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value="/admin/dept")
@Controller
public class DeptController {
	
	private final DeptService dService;
		
	// */admin/dept 로 매핑
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public String input(Model model) {

		this.modelMapping(model);
		
		DeptVO deptVO = new DeptVO();
		model.addAttribute("deptVO",deptVO);
		return "admin/main";
	
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String input(
			@Valid @ModelAttribute DeptVO deptVO,
			BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			this.modelMapping(model);
			model.addAttribute("deptVO",deptVO);
			return "admin/main";
		}
		
		DeptVO ret = dService.save(deptVO);
		return "redirect:/admin/dept";
	
	}
	
	private void modelMapping(Model model) {

		List<DeptVO> deptList = dService.selectAll();
		model.addAttribute("DEPT_LIST",deptList);
		model.addAttribute("BODY","DEPT");
		
	}

}
