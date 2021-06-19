package com.javapoint.servicesImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.EmployeeDetailsRep;
import com.javapoint.models.Employee_details;
import com.javapoint.models.MapEmpwithRoleandProject;
import com.javapoint.models.Projectmstr;
import com.javapoint.models.Rolemstr;
import com.javapoint.services.EmployeeServices;
import com.javapoint.services.ProjectmstrService;
import com.javapoint.services.RolemstrService;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeServices {

	@Autowired
	private EmployeeDetailsRep employeeDetailsRep;
	
	@Autowired
	private RolemstrService roleMstrService;
	
	@Autowired
	private ProjectmstrService projectMstrService;
	
	public EmployeeServiceImp() {
		super();
	}

	@Override
	public Employee_details findbyID(Long id) {
		
		Optional<Employee_details> employee_Details = employeeDetailsRep.findById(id);
		return employee_Details.orElse(null);
	}

	@Override
	public Set<Employee_details> findAll() {
		
		return (Set<Employee_details>) employeeDetailsRep.findAll();
	}

	@Override
	public Employee_details Save(Employee_details obj) {
		
		obj.setPassword(new BCryptPasswordEncoder().encode(obj.getPassword()));
		
		obj.setStatus("Active");
		
		return employeeDetailsRep.save(obj);
	}
	
	@Override
	public Employee_details MapEmployeeWithRoles(MapEmpwithRoleandProject mapEmpWithRoles) {
		
		
Employee_details employee_Details = findbyID(mapEmpWithRoles.getEmp_id());
		
		List<Long> roleIds=mapEmpWithRoles.getRole_ids();
		Iterator i=roleIds.iterator();
		
		List<Rolemstr> LRoleMstr=new ArrayList<Rolemstr>();
		
		if(i != null)
		{
		while(i.hasNext())
		{
		  Long id=(Long)i.next();
		  if(id > 0)
		  {
			 Rolemstr roleMstr= roleMstrService.findbyID(id);
			if(roleMstr != null)
			{
				LRoleMstr.add(roleMstr);
			}
		  }
		}
		}
		if(i != null)
		employee_Details.setRolemstr(LRoleMstr);
		
		return employeeDetailsRep.save(employee_Details);
	}
	
	@Override
	public Employee_details MapEmployeeWithProjects(MapEmpwithRoleandProject mapEmpwithProjects) 
	{
		
		Employee_details employee_Details = findbyID(mapEmpwithProjects.getEmp_id());
		
		List<Long> newProjectIds=mapEmpwithProjects.getProjetids();
		Iterator i=null;
		if(newProjectIds != null)
		 i=newProjectIds.iterator();
		
		Iterator i1 = null;
		List<Projectmstr> currentProjects=employee_Details.getProjectMstr();
		if(currentProjects != null)
		i1=currentProjects.iterator();
		
		List<Long> projectIdList=new ArrayList<>();
		
		if(i1 != null)
		{
			while(i1.hasNext())
			{
				Projectmstr projectId=(Projectmstr) i1.next();
				projectIdList.add(projectId.getProject_ID());
			}
		}
		
		List<Projectmstr> addProjectMstr=new ArrayList<Projectmstr>();
		addProjectMstr.addAll(currentProjects);
		
		if(i != null)
		{
			while(i.hasNext())
			{
			  Long id=(Long)i.next();
				  if(!projectIdList.contains(id))
				  {
					  Projectmstr projectMstr= projectMstrService.findbyID(id);
					if(projectMstr != null)
					{
						addProjectMstr.add(projectMstr);
					}
				  }
			}
		}
		if(i != null)
		employee_Details.setProjectMstr(addProjectMstr);

		return employeeDetailsRep.save(employee_Details);
	}

	@Override
	public void deleteById(Long id) {
		
		employeeDetailsRep.deleteById(id);
	}

	@Override
	public void delete(Employee_details obj) {
		
		employeeDetailsRep.delete(obj);
	}
	
	@Override
	public Optional<Employee_details> findbyuserid(String Username) {
		
		Optional<Employee_details> ed = employeeDetailsRep.findByUserid(Username);
		
		ed.orElseThrow(() -> new UsernameNotFoundException("User name not found."+Username));
		
		return ed;
	}

	

}
