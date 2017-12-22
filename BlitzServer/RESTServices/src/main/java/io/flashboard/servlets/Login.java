package io.flashboard.servlets;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.jsonbeans.LoginData;
import io.flashboard.service.LoginService;

@Path("/login")
public class Login {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response loginData(LoginData ld) {
		
		if(LoginService.validate(ld.getUsername(), ld.getPassword)) {
			
		}
		
		return null;
	}
}
