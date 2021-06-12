package com.javapoint.servicesImp;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.EmployeeDetailsRep;
import com.javapoint.models.Employee_details;
import com.javapoint.services.EmployeeServices;

@Service
public class EmployeeServiceImp implements EmployeeServices {

	@Autowired
	private EmployeeDetailsRep edp;
	
	public EmployeeServiceImp() {
		super();
	}

	@Override
	public Employee_details findbyID(Long id) {
		
		Optional<Employee_details> opt = edp.findById(id);
		
		return opt.orElse(null);
	}

	@Override
	public Set<Employee_details> findAll() {
		
		return (Set<Employee_details>) edp.findAll();
	}

	@Override
	public Employee_details Save(Employee_details obj) {
		
		obj.setPassword(new BCryptPasswordEncoder().encode(obj.getPassword()));
		
		obj.setStatus("Active");
		
		return edp.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		
		edp.deleteById(id);
	}

	@Override
	public void delete(Employee_details obj) {
		
		edp.delete(obj);
	}
	
	@Override
	public Optional<Employee_details> findbyuserid(String Username) {
		
		Optional<Employee_details> ed = edp.findByUserid(Username);
		
		ed.orElseThrow(() -> new UsernameNotFoundException("User name not found."+Username));
		
		return ed;
	}

}
