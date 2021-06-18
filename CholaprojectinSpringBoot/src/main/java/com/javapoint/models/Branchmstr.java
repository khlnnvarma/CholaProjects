package com.javapoint.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "BRANCH_MSTR")
@JsonIgnoreProperties({"employeeDetails"})
public class Branchmstr{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BranchSeq")
	@SequenceGenerator(name = "BranchSeq",sequenceName = "BRANCH_SEQ",allocationSize = 1)
	private Long branch_id;
	private String branch_Name;
	private String created_By;
	private String status;
	private String created_on;
	@OneToMany(orphanRemoval = true,mappedBy = "emp_id")
	private List<Employee_details> employeeDetails;
	
	public Branchmstr() {
		super();
	}

	public Branchmstr(Long branch_id, String branch_Name, String created_By, String status, String created_on,
			List<Employee_details> employeeDetails) {
		super();
		this.branch_id = branch_id;
		this.branch_Name = branch_Name;
		this.created_By = created_By;
		this.status = status;
		this.created_on = created_on;
		this.employeeDetails = employeeDetails;
	}

	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_Name() {
		return branch_Name;
	}

	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}

	public String getCreated_By() {
		return created_By;
	}

	public void setCreated_By(String created_By) {
		this.created_By = created_By;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public List<Employee_details> getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(List<Employee_details> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
}