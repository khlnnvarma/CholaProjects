package com.javapoint.servicesImp;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.BranchmstrRepository;
import com.javapoint.models.Branchmstr;
import com.javapoint.models.Projectmstr;
import com.javapoint.services.BranchmstrServices;

@Service
public class BranchmstrServiceImp implements BranchmstrServices{
	
	@Autowired
	private BranchmstrRepository branchMstrRepository;

	@Override
	public Branchmstr findbyID(Long id) {
		
		Optional<Branchmstr> branchMstr=branchMstrRepository.findById(id);
		
		return branchMstr.orElse(null);
	
	}

	@Override
	public Set<Branchmstr> findAll() {
		
		return (Set<Branchmstr>) branchMstrRepository.findAll();
	}

	@Override
	public Branchmstr Save(Branchmstr obj) {
		return branchMstrRepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		
		branchMstrRepository.deleteById(id);
		
	}

	@Override
	public void delete(Branchmstr obj) {
		branchMstrRepository.deleteAll();
	}

	@Override
	public List<Branchmstr> getActivebranches() {
		
		return branchMstrRepository.findActiveBranches();
	}


}
