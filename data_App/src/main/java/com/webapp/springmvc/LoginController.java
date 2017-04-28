package com.webapp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	//map to /login
	@RequestMapping(value = "/login")
	@ResponseBody
	public String sayHi() {
		return "Spring mvc Success!";
	}
}
