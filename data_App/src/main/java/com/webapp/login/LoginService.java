package com.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("cathy") 
				&& password.equals("cathy");
	}
}
