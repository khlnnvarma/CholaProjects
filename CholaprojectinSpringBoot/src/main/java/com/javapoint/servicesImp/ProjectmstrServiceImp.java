package com.javapoint.servicesImp;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapoint.jpaRepository.ProjectmstrRepository;
import com.javapoint.models.Projectmstr;
import com.javapoint.services.ProjectmstrService;

@Service
public class ProjectmstrServiceImp implements ProjectmstrService{
	
	@Autowired
	private ProjectmstrRepository projectMstrRepository;

	@Override
	public Projectmstr findbyID(Long id) {
		
		Optional<Projectmstr> projectMstr=projectMstrRepository.findById(id);
		
		return projectMstr.orElse(null);
	
	}

	@Override
	public Set<Projectmstr> findAll() {
		
		return (Set<Projectmstr>) projectMstrRepository.findAll();
	}

	@Override
	public Projectmstr Save(Projectmstr obj) {
		return projectMstrRepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		
		projectMstrRepository.deleteById(id);
		
	}

	@Override
	public void delete(Projectmstr obj) {
		projectMstrRepository.deleteAll();
	}

}
