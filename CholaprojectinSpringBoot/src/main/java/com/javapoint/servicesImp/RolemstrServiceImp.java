package com.javapoint.servicesImp;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.RolemstrRepository;
import com.javapoint.models.Rolemstr;
import com.javapoint.services.RolemstrService;
@Service
public class RolemstrServiceImp implements RolemstrService {
	
	@Autowired
	private RolemstrRepository roleMstrRepository;

	@Override
	public Rolemstr findbyID(Long id) {
		
		Optional<Rolemstr> roleMstr= roleMstrRepository.findById(id);
		return roleMstr.orElse(null);
	}

	@Override
	public Set<Rolemstr> findAll() {
		return (Set<Rolemstr>) roleMstrRepository.findAll();
	}

	@Override
	public Rolemstr Save(Rolemstr obj) {
		
		return roleMstrRepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		
		roleMstrRepository.deleteById(id);
	}

	@Override
	public void delete(Rolemstr obj) {
		roleMstrRepository.deleteAll();
		
	}

}