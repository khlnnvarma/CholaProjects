package com.javapoint.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javapoint.models.Employee_details;

@Repository
public interface EmployeeDetailsRep extends JpaRepository<Employee_details, Long> {

}
