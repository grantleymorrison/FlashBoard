package io.flashboard.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import io.flashboard.beans.RegistrationData;
import io.flashboard.dao.UserDaoImpl;
import io.flashboard.service.RegistrationService;

@Path("/registration")
public class UserRegistration {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrationData(RegistrationData rd) {
		
		if(RegistrationService.validate(rd)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
}
