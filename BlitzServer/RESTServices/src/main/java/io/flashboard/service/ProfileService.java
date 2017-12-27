package io.flashboard.service;

import io.flashboard.beans.users.User;
import io.flashboard.dao.UserDaoImpl;
import io.flashboard.jsonbeans.ProfileData;

public class ProfileService {

	public static ProfileData getProfile(String username) {
		UserDaoImpl ud = new UserDaoImpl();
		User user = ud.getUserByUsername(username);
		ProfileData pd = null;
		
		if(user != null) {
			pd = new ProfileData(user.getUsername(), user.getFirstName(), user.getLastName(),
					user.getEmail(), user.getFavColor(), user.getAvgScore());
		}
		
		return pd;
	}
}
