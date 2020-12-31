package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Crude;
import com.example.entity.employee;

@Transactional
public interface CrudeRepository extends CrudRepository<employee, Integer>{//extends JpaRepository<employee, Integer>
	
	@Query("select em from employee em where em.dflag =1")
	public List<employee> findAllData();
	
	@Query("select em from employee em where em.id =:id")
	public employee findOne(@Param("id")int id);

	//public employee save(employee emp);

	//public employee findById(int id);

}
