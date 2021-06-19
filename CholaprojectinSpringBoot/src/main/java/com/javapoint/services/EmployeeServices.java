package com.javapoint.services;

import java.util.Optional;

import com.javapoint.models.Employee_details;
import com.javapoint.models.MapEmpwithRoleandProject;

public interface EmployeeServices extends CurdServices<Employee_details, Long> {
	
	public Optional<Employee_details> findbyuserid(String id);
	
	public Employee_details MapEmployeeWithRoles(MapEmpwithRoleandProject employeeDetails);

	public Employee_details MapEmployeeWithProjects(MapEmpwithRoleandProject employeeDetails);
}
