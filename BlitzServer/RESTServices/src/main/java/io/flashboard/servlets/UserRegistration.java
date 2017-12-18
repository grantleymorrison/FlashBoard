package io.flashboard.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/registration")
public class UserRegistration {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registrationData(String JSON) {
		System.out.println(JSON);
	}
}
