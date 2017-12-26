package io.flashboard.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.flashboard.jsonbeans.ProfileData;
import io.flashboard.service.ProfileService;

@Path("/profile")
public class Profile {

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProfileData profile(@PathParam("username") String username) {
		ProfileData pd = ProfileService.getProfile(username);
		
		return pd;
	}
}
