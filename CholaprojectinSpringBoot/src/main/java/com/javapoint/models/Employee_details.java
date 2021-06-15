package com.javapoint.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Employee_details")
public class Employee_details {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "Employee_id")
	@SequenceGenerator(name ="Employee_id" ,sequenceName = "EMP_SEQ",allocationSize = 1 )
	private Long emp_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private Long phone_no;
	@Column(name="User_id")
	private String userid;
	private String password;
	private String status;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "employee_role",
		joinColumns = { @JoinColumn(name = "fk_role")},
			inverseJoinColumns = { @JoinColumn(name = "fk_employee")})
	private List<Rolemstr> rolemstr;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private Branchmstr branch;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project",
	joinColumns = {@JoinColumn(name="fk_project")},
	inverseJoinColumns = {@JoinColumn(name = "fk_employee")})
	private List<Projectmstr> projectMstr;
	
	@OneToOne(targetEntity = Addressdetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	@JsonManagedReference
	private Addressdetails addressDetails;
	
	public Employee_details() {
		super();
	}

	public Employee_details(Long emp_id, String first_name, String last_name, String email_id, Long phone_no,
			String userid, String password, String status, List<Rolemstr> rolemstr, Branchmstr branch,
			List<Projectmstr> projectMstr, Addressdetails addressDetails) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone_no = phone_no;
		this.userid = userid;
		this.password = password;
		this.status = status;
		this.rolemstr = rolemstr;
		this.branch = branch;
		this.projectMstr = projectMstr;
		this.addressDetails = addressDetails;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Rolemstr> getRolemstr() {
		return rolemstr;
	}

	public void setRolemstr(List<Rolemstr> rolemstr) {
		this.rolemstr = rolemstr;
	}

	public Branchmstr getBranch() {
		return branch;
	}

	public void setBranch(Branchmstr branch) {
		this.branch = branch;
	}

	public List<Projectmstr> getProjectMstr() {
		return projectMstr;
	}

	public void setProjectMstr(List<Projectmstr> projectMstr) {
		this.projectMstr = projectMstr;
	}

	public Addressdetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(Addressdetails addressDetails) {
		this.addressDetails = addressDetails;
	}



	
}
