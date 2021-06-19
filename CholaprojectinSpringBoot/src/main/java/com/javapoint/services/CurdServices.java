package com.javapoint.services;

import java.util.Set;

import com.javapoint.models.Employee_details;
import com.javapoint.models.MapEmpwithRoleandProject;

public interface CurdServices<T,ID>{
	
	T findbyID(Long id);
	
	Set<T> findAll();
	
	T Save(T obj);
	
	void deleteById(ID id);
	
	void delete(T obj);


}
