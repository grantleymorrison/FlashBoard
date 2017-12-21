package io.flashboard.service;

import io.flashboard.dao.UserDaoImpl;
import io.flashboard.jsonbeans.RegistrationData;

public class validateRegistration {
	
	public static boolean validateRegistation(RegistrationData rd) {
		UserDaoImpl udao = new UserDaoImpl();
		
		/*if(rd.getUsername().equals("") || udao.getUserByUsername(rd.getUsername()){
			return false;
		}
		*/
		if(rd.getPassword().equals("") || rd.getPassword() != rd.getRePassword()) {
			return false;
		}
		return true;
	}
}
