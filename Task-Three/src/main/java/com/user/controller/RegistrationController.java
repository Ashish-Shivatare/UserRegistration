package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.user.model.User;
import com.user.service.UserService;
import com.user.validator.UserValidator;

@Controller
public class RegistrationController {


	@Autowired
	private UserValidator userValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value="/login")
	public String home() {
		return "login";
	}

	@RequestMapping(value="/registration")
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(path="/registrationForm", method = RequestMethod.POST)
	public String registerForm(@ModelAttribute("user") @Validated User user, BindingResult result,
			Model model) {

		if(result.hasErrors())
		{
			return "registration";
		}

		this.userService.createUser(user);
		return "login";
	}
}
