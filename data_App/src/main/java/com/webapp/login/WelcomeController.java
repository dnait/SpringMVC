package com.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class WelcomeController {
	
	//map to /login
	@RequestMapping(value = "/", method=RequestMethod.GET)	
	public String showLoginPage(ModelMap model) {
		//todo-servlet.xml or spring-servlet.xml control to return login.jsp
		model.put("name", "cathy");
		return "welcome";
	}
	
}
