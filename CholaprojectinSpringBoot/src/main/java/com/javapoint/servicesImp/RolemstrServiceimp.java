package com.javapoint.servicesImp;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.RolemstrRepository;
import com.javapoint.models.Rolemstr;
import com.javapoint.services.RolemstrService;
@Service
public class RolemstrServiceimp implements RolemstrService {
	
	@Autowired
	private RolemstrRepository roleMstrRepository;

	@Override
	public Rolemstr findbyID(Long id) {
		
		return roleMstrRepository.findById(id).get();
	}

	@Override
	public Set<Rolemstr> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rolemstr Save(Rolemstr obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Rolemstr obj) {
		// TODO Auto-generated method stub
		
	}

}