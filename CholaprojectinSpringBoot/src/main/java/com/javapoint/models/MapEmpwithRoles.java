package com.javapoint.models;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MapEmpwithRoles {
	
	private Long emp_id;
	private List<Long> role_ids;
	
	
	public MapEmpwithRoles() {
		super();
	}

	public MapEmpwithRoles(Long emp_id, List<Long> role_ids) {
		super();
		this.emp_id = emp_id;
		this.role_ids = role_ids;
	}
	
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	public List<Long> getRole_ids() {
		return role_ids;
	}
	public void setRole_ids(List<Long> role_ids) {
		this.role_ids = role_ids;
	}
	
	

}
