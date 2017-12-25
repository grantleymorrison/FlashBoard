package io.flashboard.service;

import io.flashboard.beans.User;
import io.flashboard.dao.UserDaoImpl;

public class LoginService {

	/**
	 * Takes a username and password to check against a database entry.
	 * Validates a user when logging in
	 * 
	 * @param username
	 * @param password
	 * @return true for correct credentials, false for incorrect credentials
	 */
	public static boolean validate(String username, String password) {
		UserDaoImpl ud = new UserDaoImpl();
		User user = ud.getUserByUsername(username);
		
		//user not found
		if(user == null) {
			return false;
		}
		
		//incorrect password
		if(!user.getPassword().equals(password)) {
			return false;
		}
		
		return true;
	}
}
