package com.webapp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	//map to /login
	@RequestMapping(value = "/login")
	
	public String sayHi() {
		//todo-servlet.xml or spring-servlet.xml control to return login.jsp
		return "login" ;
	}
}
