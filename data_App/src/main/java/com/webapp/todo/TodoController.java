package com.webapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.login.LoginService;

@Controller
public class TodoController {
	
	//Set the login service from the framework with dependency injection
	//Set the login service -Auto Wiring
	//LoginService service = new LoginService();
	@Autowired
	TodoService service;
	//map to /login
	@RequestMapping(value = "/list-todos", method=RequestMethod.GET)	
	public String showLoginPage(ModelMap model) {
		model.addAttribute("todos", service.retrieveTodos("cathy"));
		return "list-todos" ;
	}
	
	
}
