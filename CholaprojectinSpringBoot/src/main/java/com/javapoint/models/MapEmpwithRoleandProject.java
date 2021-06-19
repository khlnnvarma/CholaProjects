package com.javapoint.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MapEmpwithRoleandProject {
	
	private Long emp_id;
	private List<Long> role_ids;
	private List<Long> projetids;
	
	
	public MapEmpwithRoleandProject() {
		super();
	}

	
	
	public MapEmpwithRoleandProject(Long emp_id, List<Long> role_ids, List<Long> projetids) {
		super();
		this.emp_id = emp_id;
		this.role_ids = role_ids;
		this.projetids = projetids;
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

	public List<Long> getProjetids() {
		return projetids;
	}

	public void setProjetids(List<Long> projetids) {
		this.projetids = projetids;
	}
	

}
