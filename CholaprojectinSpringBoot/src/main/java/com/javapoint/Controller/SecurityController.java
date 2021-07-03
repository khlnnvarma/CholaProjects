package com.javapoint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.Exceptions.UserorPasswordmismatch;
import com.javapoint.models.AuthenticateRequest;
import com.javapoint.models.AuthenticateResponse;
import com.javapoint.models.UserDetailsImp;
import com.javapoint.servicesImp.UserDetailsServiceImp;
import com.javapoint.util.jwtutil;

@RestController
public class SecurityController {
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private UserDetailsService uds;
	
	@Autowired
	private jwtutil jutil;
	
	@PostMapping("/security/jwt")
	public ResponseEntity<?> getJwt(@RequestBody AuthenticateRequest authenticationrequest)throws Exception
	{
		try {
		authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername(), authenticationrequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new UserorPasswordmismatch();
		}
		
		final UserDetails ud=uds.loadUserByUsername(authenticationrequest.getUsername());
		
		final String jwt = jutil.generateJwttoken(ud);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));
		
	}

}
