package io.flashboard.service;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.flashboard.beans.users.User;
import io.flashboard.dao.UserDaoImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class TokenService {
	private static String secretKey = "HanisCool";
	
	/**
	 * Method creates the JWT to be sent to the client
	 * Sends the username and userId
	 * 
	 * @param user object holding user information
	 * @return JavaScript Web Token
	 */
	public static String create(User user) {
		
		if(user == null) {
			return null;
		}
		
		SignatureAlgorithm signAlgor = SignatureAlgorithm.HS256;
		
		Key key = new SecretKeySpec(getSecret(), signAlgor.getJcaName());
		
		String id = Integer.toString(user.getUserId());
		
		JwtBuilder token = Jwts.builder().setId(id).setSubject(user.getUsername()).signWith(signAlgor, key);
		
		return token.compact();
		
	}
	
	/**
	 * Verifies a web token given a username and token
	 * Checks the given username with the token username to verify usage
	 * 
	 * @param token JavaScript Web Token
	 * @param username the given username
	 * @return true if token is fine, otherwise false
	 */
	public static boolean verify(String token, String username) {
		Claims claims = null;
		UserDaoImpl ud = new UserDaoImpl();
		User user = null;
		String cUsername = null;
		boolean verified = false;
		
		if(token == null) {
			return false;
		}
		
		try {
			claims = Jwts.parser()
					.setSigningKey(getSecret())
					.parseClaimsJws(token).getBody();
			
			cUsername = claims.getSubject();
			user = ud.getUserByUsername(cUsername);
			
			if(cUsername == null || user == null || !cUsername.equals(username)) {
				return false;
			}
			
			verified = true;
			
		}catch(SignatureException se) {
			
		}
		
		return verified;
	}
	
	/**
	 * Creates the secret key from a static string
	 * 
	 * @return byte[] conversion of secretKey
	 */
	private static byte[] getSecret() {
		String base64Key = DatatypeConverter.printBase64Binary(secretKey.getBytes());
		
		return DatatypeConverter.parseBase64Binary(base64Key);
	}
	
}
