package com.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/")
	public String home() {
		return "login";
	}
	
	@RequestMapping(path="/loginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {

		boolean isValidUser = this.userService.findUser(name, password);

		if(!isValidUser) {
			model.addAttribute("invalid", "Invalid username or password");
			return "login";  
		} 
		return "success";
	}
}
