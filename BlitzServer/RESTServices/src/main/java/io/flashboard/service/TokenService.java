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
	
	public static boolean verify(String token) {
		Claims claims = null;
		UserDaoImpl ud = new UserDaoImpl();
		User user = null;
		String id = null;
		String claimsId = null;
		boolean verified = false;
		
		try {
			claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
					.parseClaimsJws(token).getBody();
			
			user = ud.getUserByUsername(claims.getSubject());
			id = Integer.toString(user.getUserId());
			claimsId = claims.getId();
			
			if(user == null || claimsId == null || !claims.equals(id)) {
				return false;
			}
			
			verified = true;
			
		}catch(SignatureException se) {
			
		}
		
		return verified;
	}
	
	private static byte[] getSecret() {
		String base64Key = DatatypeConverter.printBase64Binary(secretKey.getBytes());
		
		return DatatypeConverter.parseBase64Binary(base64Key);
	}
	
}
