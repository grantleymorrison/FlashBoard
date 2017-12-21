package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	public Response registrationData(RegistrationData rd) {
		UserDaoImpl udao = new UserDaoImpl();
		//udao.createNewUser(rd.getUsername(), rd.getPassword());
		System.out.println(rd);
		return Response.status(200).build();
	}
}
