package io.flashboard.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.flashboard.dao.AdminDaoImpl;
import io.flashboard.dao.UserDaoImpl;

@Path("/admin")
public class Admin {

	@GET
	@Path("/newusers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getNewUsers(){
		UserDaoImpl ud = new UserDaoImpl();
		List<String> newUsers = ud.getAllUsers();
		
		return newUsers;
	}
	
	@DELETE
	@Path("/newusers/deny/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response denyNewUser(@PathParam("username") String username) {
		AdminDaoImpl ad = new AdminDaoImpl();
		
		if(ad.denyUserAccount(username)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
	
	@DELETE
	@Path("/user/delete/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("username") String username) {
		AdminDaoImpl ad = new AdminDaoImpl();
		
		if(ad.deleteUserAccount(username)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
	
	@PUT
	@Path("/newusers/approve")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response approveNewUser(String username) {
		AdminDaoImpl ad = new AdminDaoImpl();
		
		if(ad.approveUser(username)) {
			return Response.status(200).build();
		}
		
		return Response.status(400).build();
	}
	
	@PUT
	@Path("/user/blacklist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public Response blacklistUser(String username) {
		AdminDaoImpl ad = new AdminDaoImpl();
		
		if(ad.blacklistUserAccount(username)) {
			return Response.status(200).build();
		} 
		return Response.status(200).build();
	}
}
