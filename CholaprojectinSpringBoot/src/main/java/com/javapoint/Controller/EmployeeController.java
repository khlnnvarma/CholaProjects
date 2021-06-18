package com.javapoint.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javapoint.models.Employee_details;
import com.javapoint.models.MapEmpwithRoles;
import com.javapoint.services.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServices Es;

	public EmployeeController() {
		super();
	}
	
	@PostMapping("/employee/details/save")
	public Employee_details SaveEmpDetails(@RequestBody Employee_details empdet)
	{
		return Es.Save(empdet);
	}
	
	@GetMapping("/employee/details/by/{id}")
	public Employee_details SaveEmpDetails(@PathVariable Long id)
	{
		return Es.findbyID(id);
	}
	
	@PutMapping("/map/employee/roles")
	public Employee_details MapEmployeeWithRoles(@RequestBody MapEmpwithRoles mapEmpWithRoles)
	{
		return Es.MapEmployeeWithRoles(mapEmpWithRoles);
	}

}
