package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String mainForward() {
		return "index";
	}
	
	@PostMapping("/select")
	public String selectUserId(String userId, Model model) {
		
		User user = service.selectUserId(userId); 
		
		model.addAttribute("user", user);
		
		String path = null;
		if(user != null) {
			path = "searchSuccess";
		} else {
			path = "searchFail";
		}
		
		return path;
	}
	
}