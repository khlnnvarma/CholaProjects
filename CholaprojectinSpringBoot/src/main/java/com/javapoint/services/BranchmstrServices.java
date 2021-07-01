package com.javapoint.services;

import java.util.List;

import com.javapoint.models.Branchmstr;

public interface BranchmstrServices extends CurdServices<Branchmstr, Long>{
	
	public List<Branchmstr> getActivebranches();

}
