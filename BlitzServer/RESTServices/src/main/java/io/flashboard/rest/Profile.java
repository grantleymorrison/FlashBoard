package io.flashboard.rest;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import io.flashboard.jsonbeans.ProfileData;
import io.flashboard.service.ProfileService;
import io.flashboard.service.TokenService;

@Path("/profile")
public class Profile {

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileData profile(@PathParam("username") String username, @Context HttpServletRequest request) {
		
		ProfileData pd = ProfileService.getProfile(username);
		
		return pd;
	}
	
	@POST
	@Path("/update/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ProfileData updateProfile(@PathParam("username") String username, @Context HttpServletRequest request) {
		String token = request.getHeader("authorization");

		if(!TokenService.verify(token, username)) {
			return new ProfileData("Unauthorized");
		}
	
		ProfileData pd = ProfileService.getProfile(username);
		
		return pd;
	}
}
