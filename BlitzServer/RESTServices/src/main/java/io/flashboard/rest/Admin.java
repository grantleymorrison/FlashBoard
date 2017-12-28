package io.flashboard.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.flashboard.beans.users.User;
import io.flashboard.dao.UserDaoImpl;

@Path("/admin")
public class Admin {

	@GET
	@Path("/newusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getNewUsers(){
		UserDaoImpl ud = new UserDaoImpl();
		List<User> newUsers = ud.getAllUsers();
		
		return newUsers;
	}
}
