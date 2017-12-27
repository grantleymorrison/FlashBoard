package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.jsonbeans.RegistrationData;
import io.flashboard.service.RegistrationService;

@Path("/registration")
public class UserRegistration {
	
	/**
	 * Handles post requests for registration
	 * Consumes a JSON object and converts to RegistrationData
	 * 
	 * @param rd Object that holds the registration data 
	 * @return Response with error status; 200 for success; 400 for username already in use
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registration(RegistrationData rd) {
		
		if(RegistrationService.validate(rd)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
}
