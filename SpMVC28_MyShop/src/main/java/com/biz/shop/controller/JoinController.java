package com.biz.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.service.UserService;
import com.biz.shop.utils.PbeEncryptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/join")
@RequiredArgsConstructor
public class JoinController {

	private final UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {
		return "join/join";
	}

	@RequestMapping(value = "/join_ok", method = RequestMethod.POST)
	public String joinok(@ModelAttribute("userVO") UserDetailsVO userVO, Model model) {

		log.debug("USERVO :" + userVO.toString());
		int ret = userService.insert(userVO);
		return "redirect:/user/login";

	}

}
