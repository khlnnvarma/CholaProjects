package com.javapoint.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImp implements UserDetails{
	
	private String username;
	private String password;
	private String firstname;
	private String status;
	private List<GrantedAuthority> roles;

	public UserDetailsImp() {
		super();
	}

	public UserDetailsImp(Employee_details emp) {
		super();
		this.username = emp.getUserid();
		this.password = emp.getPassword();
		this.firstname = emp.getFirst_name();
		this.status =emp.getStatus();
		List<GrantedAuthority> roles=new ArrayList<>();
		for(Rolemstr role : emp.getRolemstr())
		{
			roles.add(new SimpleGrantedAuthority(role.getRole_name()));
		}
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		if(this.status.equals("Active"))
			return true;
		else
			return false;
	}

}
