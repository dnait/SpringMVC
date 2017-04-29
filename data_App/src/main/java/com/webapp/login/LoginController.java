package com.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.login.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	//Set the login service from the framework with dependency injection
	//Set the login service -Auto Wiring
	//LoginService service = new LoginService();
	@Autowired
	LoginService service;
	//map to /login
	@RequestMapping(value = "/login", method=RequestMethod.GET)	
	public String showLoginPage() {
		//todo-servlet.xml or spring-servlet.xml control to return login.jsp
		return "login" ;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)	
	public String handleUserLogin(ModelMap model, @RequestParam String name, @RequestParam String password) {
		//todo-servlet.xml or spring-servlet.xml control to return login.jsp
		//System.out.println(name);
		
		if (!service.validateUser(name, password)) {		
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome" ;
	}
}
