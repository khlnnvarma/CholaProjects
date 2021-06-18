package com.javapoint.services;

import java.util.Optional;

import com.javapoint.models.Employee_details;
import com.javapoint.models.MapEmpwithRoles;

public interface EmployeeServices extends CurdServices<Employee_details, Long> {
	
	public Optional<Employee_details> findbyuserid(String id);
	
	public Employee_details MapEmployeeWithRoles(MapEmpwithRoles employeeDetails);
}
