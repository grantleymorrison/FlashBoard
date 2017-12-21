package io.flashboard.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import io.flashboard.beans.RegistrationData;
import io.flashboard.dao.UserDaoImpl;

@Path("/registration")
public class UserRegistration {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrationData(String JSON) {
		UserDaoImpl udao = new UserDaoImpl();
		Gson gson = new Gson();
		RegistrationData rd = gson.fromJson(JSON, RegistrationData.class);
		udao.createNewUser(rd.getUsername(), rd.getPassword());
	}
}
