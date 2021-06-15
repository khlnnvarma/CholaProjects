package com.javapoint.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Role_mstr")
@JsonIgnoreProperties({"employee_details"})
public class Rolemstr{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Role_seq")
	@SequenceGenerator(name = "Role_seq", sequenceName = "ROLE_SEQ" , allocationSize = 1)
	private Long role_id;	
	private String role_name;
	private String status;
	private String created_by;
	private String created_on;
	@ManyToMany(mappedBy = "rolemstr")
	private List<Employee_details> employee_details;
	
	
	public Rolemstr() {
		super();
	}


	public Rolemstr(Long role_id, String role_name, String status, String created_by, String created_on,
			List<Employee_details> employee_details) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.status = status;
		this.created_by = created_by;
		this.created_on = created_on;
		this.employee_details = employee_details;
	}


	public Long getRole_id() {
		return role_id;
	}


	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCreated_by() {
		return created_by;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public String getCreated_on() {
		return created_on;
	}


	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}


	public List<Employee_details> getEmployee_details() {
		return employee_details;
	}


	public void setEmployee_details(List<Employee_details> employee_details) {
		this.employee_details = employee_details;
	}
	

}
