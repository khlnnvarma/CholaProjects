package com.javapoint.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ADDRESS_DETAILS")
public class Addressdetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Addressseq")
	@SequenceGenerator(name = "Addressseq",sequenceName = "Address_Seq",allocationSize = 1)
	private Long address_id;
	private Long pincode;
	private String state;
	private String district;
	private String village;
	private String House_no;
	@OneToOne(mappedBy = "addressDetails")
	@JsonBackReference
	private Employee_details employee_Details;
	
	public Addressdetails() {
		super();
	}

	public Addressdetails(Long address_id, Long pincode, String state, String district, String village, String house_no,
			Employee_details employee_Details) {
		super();
		this.address_id = address_id;
		this.pincode = pincode;
		this.state = state;
		this.district = district;
		this.village = village;
		House_no = house_no;
		this.employee_Details = employee_Details;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getHouse_no() {
		return House_no;
	}

	public void setHouse_no(String house_no) {
		House_no = house_no;
	}

	public Employee_details getEmployee_Details() {
		return employee_Details;
	}

	public void setEmployee_Details(Employee_details employee_Details) {
		this.employee_Details = employee_Details;
	}
	


	
}
