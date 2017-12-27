package io.flashboard.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.jsonbeans.AuthData;
import io.flashboard.jsonbeans.LoginData;
import io.flashboard.service.LoginService;

@Path("/login")
public class Login {
	
	/**
	 * REST service for checking user credentials.
	 * Takes in a JSON object and converts it to LoginData object
	 * 
	 * @param ld login data inputed by user
	 * @return 400 for incorrect credentials; 200 and AuthData for success
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginData ld) {
		String username = ld.getUsername();
		String password = ld.getPassword();
		
		AuthData ad = LoginService.authentication(username, password);
		
		if(ad != null) {
			return Response.status(200).entity(ad).build();
		}
		
		return Response.status(400).build();
	}
}
