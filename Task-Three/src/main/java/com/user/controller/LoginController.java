package com.user.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.user.model.Login;
import com.user.service.UserService;


@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/")
	public String home() {
		return "login";
	}

	@RequestMapping(path = "/loginForm", method = RequestMethod.GET)
	public String loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {

		Login log = checkCookie(request);
		if (log == null) {
			modelMap.put("loginForm", new Login());
			return "success";
		}   
		else {        			
			if(this.userService.login(log.getName(),log.getPassword())){
				session.setAttribute("name", log.getName());
				return "success";
			} else {
				modelMap.put("error", "invalid login from cookie");
				return "login";
			}
		}       
	}


	@RequestMapping(path = "/loginForm", method = RequestMethod.POST)
	public String loginRequestHandler(@ModelAttribute("loginForm") Login login,ModelMap modelMap,HttpSession session,HttpServletRequest request,HttpServletResponse response) {

		if(this.userService.login(login.getName(), login.getPassword()))
		{
			session.setAttribute("name", login.getName());
			if(request.getParameter("remember")!=null)
			{
				Cookie ckUsername=new Cookie("name",login.getName());
				ckUsername.setMaxAge(30);
				response.addCookie(ckUsername);
				Cookie ckPassword=new Cookie("password",login.getPassword());
				ckUsername.setMaxAge(30);
				response.addCookie(ckPassword);
			}
			return "success";
		}
		else
		{
			modelMap.put("error", "invalid login not from cookie");
			return "login";
		}
	}

	public Login checkCookie(HttpServletRequest request) {
		Cookie []cookies =request.getCookies();
		Login login = null;
		String name = "";
		String password = "";

		for(Cookie ck : cookies) {
			if(ck.getName().equalsIgnoreCase("name"))
				name = ck.getValue();
			if(ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
		}

		if(!name.isEmpty() && !password.isEmpty())
			login = new Login(name, password);
		return login;
	}
}
