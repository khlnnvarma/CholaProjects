package com.javapoint.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private String user_id;
	private String password;
	private String status;
	
	public Employee_details() {
		super();
	}

	public Employee_details(Long emp_id, String first_name, String last_name, String email_id, Long phone_no,
			String user_id, String password, String status) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone_no = phone_no;
		this.user_id = user_id;
		this.password = password;
		this.status = status;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	

}
