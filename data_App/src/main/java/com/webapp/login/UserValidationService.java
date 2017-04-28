package com.webapp.login;

public class UserValidationService {
	public boolean isUserValid(String user, String pwd) {
		if(user.equals("cathy") && pwd.equals("cathy")) {
			return true;
		}
		return false;
	}
}
