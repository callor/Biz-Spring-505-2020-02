package com.biz.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.sec.domain.UserDetailsVO;
import com.biz.sec.service.UserService;
import com.biz.sec.utils.PbeEncryptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes("userVO")
@Controller
@RequestMapping(value="/join")
@RequiredArgsConstructor
public class JoinController {

	private final UserService userService;
		
	
	@ModelAttribute("userVO")
	public UserDetailsVO newUser() {
		return new UserDetailsVO();
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {		
		return "join/join";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String user(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {		
		return "join/join_email";
	}

	@ResponseBody
	@RequestMapping(value="/joinok",method=RequestMethod.POST)
	public String joinok(
			@ModelAttribute("userVO") UserDetailsVO userVO, 
			SessionStatus session,
			Model model) {		
				
		log.debug("USERVO :" + userVO.toString());
		int ret = userService.insert(userVO);
		model.addAttribute("JOIN","EMAIL_OK");

		// sesstionAttribute에 저장된 session값을 clear시키기
		// session.setComplete();
		log.debug("USERVO :" + userVO.toString());
		return "join/join_email";
		
	}
	
	
	@RequestMapping(value="/emailok",method=RequestMethod.GET)
	public String emailOk(
			@ModelAttribute("userVO") UserDetailsVO userVO,
			SessionStatus session,
			Model model) {
		
		boolean ret = userService.emailok(
					userVO.getUsername(),
					userVO.getEmail());
		
		session.setComplete();
		if(ret) {
			return "redirect:/user/login";
		}else {
			// 2020-04-21 추가
			return "join/join_email_fail";
		}
	}
}







