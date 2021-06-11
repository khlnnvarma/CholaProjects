package com.javapoint.services;

import java.util.Set;

public interface CurdServices<T,ID>{
	
	T findbyID(Long id);
	
	Set<T> findAll();
	
	T Save(T obj);
	
	void deleteById(ID id);
	
	void delete(T obj);

}
