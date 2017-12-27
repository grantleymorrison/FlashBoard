package io.flashboard.service;

import io.flashboard.dao.UserDaoImpl;
import io.flashboard.jsonbeans.RegistrationData;

public class RegistrationService {

	/**
	 * Validates the registration data
	 * 
	 * 
	 * @param rd Object that holds the registration data
	 * @return false if conditions are not met; true if conditions are met
	 */
	public static boolean validate(RegistrationData rd) {
		UserDaoImpl ud = new UserDaoImpl();
		
		String fname = rd.getFname();
		String lname = rd.getLname();
		String email = rd.getEmail();
		String username = rd.getUsername();
		String password = rd.getPassword();
		String rePassword = rd.getRePassword();
		
		//If password is an empty string, less then 8, or not equal to the re-typed password, false is returned.
		if(password.trim().isEmpty() || password.length() < 8 || !password.equals(rePassword)) {
			return false;
		}
		
		//If username is empty string or exists in database, return false
		if(username.trim().isEmpty() || ud.getUserByUsername(username) != null) {
			return false;
		}
		
		//user is created; contains a final check for unique usernames
		return ud.createNewUser(fname, lname, username, email, password);
	}
}
