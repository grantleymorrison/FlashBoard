package io.flashboard.service;

import io.flashboard.beans.User;
import io.flashboard.dao.UserDaoImpl;

public class LoginService {

	public static boolean validate(String username, String password) {
		UserDaoImpl ud = new UserDaoImpl();
		User user = ud.selectUserByUsername(username);
		
		if(user == null) {
			return false;
		}
		
		if(!user.getPassword().equals(password)) {
			return false;
		}
		
		return true;
	}
}
