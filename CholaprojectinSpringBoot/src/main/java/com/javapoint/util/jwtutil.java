package com.javapoint.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class jwtutil {
	
	String SECRET_KEY="secret";
	
	public String generateJwttoken(UserDetails userdetails)
	{
		Map<String,Object> claims=new HashMap<>();
		return Createtoken(claims,userdetails.getUsername());
	}
	
	public String Createtoken(Map<String,Object> claims,String name) {
		
		return Jwts.builder().setClaims(claims).setSubject(name).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*10*2))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public <T> T extractClaim(String token,Function<Claims, T> claimResolver)
	{
		final Claims claims=extractAlltokens(token);
		return claimResolver.apply(claims);
	}
	
	public Claims extractAlltokens(String token)
	{
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	
	public Date extractExpiration(String token)
	{
		return extractClaim(token,Claims::getExpiration);
	}
	
	public Boolean isTokenExpired(String token)
	{
		return extractExpiration(token).before(new Date());
	}
	
	public boolean validatetoken(String token,UserDetails userdetails)
	{
		final String usename = extractUsername(token);
		return (usename.equals(userdetails.getUsername()) && !isTokenExpired(token));
	}

}
