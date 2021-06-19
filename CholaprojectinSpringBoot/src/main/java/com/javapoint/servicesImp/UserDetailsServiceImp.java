package com.javapoint.servicesImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.EmployeeDetailsRep;
import com.javapoint.models.Employee_details;
import com.javapoint.models.UserDetailsImp;
import com.javapoint.services.EmployeeServices;

@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private EmployeeServices Es;
	
	public UserDetailsServiceImp() {
		super();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Employee_details> ed= Es.findbyuserid(username);
		
		UserDetails ud=ed.map(UserDetailsImp::new).get();
		
		return ud;
		
	}

}
