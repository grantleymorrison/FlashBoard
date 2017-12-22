package io.flashboard.service;

import io.flashboard.beans.RegistrationData;
import io.flashboard.dao.UserDaoImpl;

public class RegistrationService {

	public static boolean validate(RegistrationData rd) {
		UserDaoImpl ud = new UserDaoImpl();
		
		String fname = rd.getFname();
		String lname = rd.getLname();
		String email = rd.getEmail();
		String username = rd.getUsername();
		String password = rd.getPassword();
		String rePassword = rd.getRePassword();
		
		if(password.equals("") || password.length() < 8 || !password.equals(rePassword)) {
			return false;
		}
		
		if(username.equals("")) {
			return false;
		}
		
		ud.createNewUser(fname, lname, username, email, password);
		return true;
	}
}
