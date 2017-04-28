package com.webapp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.jee.LoginService;

@Controller
public class LoginController {
	
	LoginService service = new LoginService();
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
