package com.javapoint.jpaRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javapoint.models.Branchmstr;

public interface BranchmstrRepository extends JpaRepository<Branchmstr, Long>{
	
	@Query(value="select * from BRANCH_MSTR where status= 'Active' ",nativeQuery = true)
	List<Branchmstr> findActiveBranches();

}
