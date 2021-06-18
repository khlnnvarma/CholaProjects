package com.javapoint.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PROJECT_MSTR")
@JsonIgnoreProperties({"employeeDetails"})
public class Projectmstr {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ProjectSeq")
	@SequenceGenerator(name = "ProjectSeq",sequenceName = "Project_seq",allocationSize = 1)
	private Long project_ID;
	private String projectName;
	private String createdBy;
	private Date createdOn;
	
	@ManyToMany(mappedBy = "projectMstr")
	private List<Employee_details> employeeDetails;
	
	public Projectmstr() {
		super();
	}
	public Projectmstr(Long project_ID, String projectName, String createdBy, Date createdOn,
			List<Employee_details> employeeDetails) {
		super();
		this.project_ID = project_ID;
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.employeeDetails = employeeDetails;
	}
	public Long getProject_ID() {
		return project_ID;
	}
	public void setProject_ID(Long project_ID) {
		this.project_ID = project_ID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public List<Employee_details> getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(List<Employee_details> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	
}