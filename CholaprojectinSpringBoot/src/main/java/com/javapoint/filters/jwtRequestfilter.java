package com.javapoint.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.javapoint.servicesImp.UserDetailsServiceImp;
import com.javapoint.util.jwtutil;

@Component
public class jwtRequestfilter extends OncePerRequestFilter {
	
	@Autowired
	private UserDetailsServiceImp udsi;
	
	@Autowired
	private jwtutil jutil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String autherisationheader = request.getHeader("Authorization");
		String Username = null;
		String jwt = null;
		
		if(autherisationheader != null && autherisationheader.startsWith("Bearer"))
		{
			jwt = autherisationheader.substring(7);
			Username = jutil.extractUsername(jwt);
		}
		if(Username != null && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			UserDetails ud= udsi.loadUserByUsername(Username);
			
			if(jutil.validatetoken(jwt, ud))
			{
				UsernamePasswordAuthenticationToken upat= new UsernamePasswordAuthenticationToken(ud,null,ud.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
			
		}
		filterChain.doFilter(request, response);
	}
	
	

}
