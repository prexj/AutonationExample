package com.example.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;



@Transactional
public interface SimpleCrudeRepository extends JpaRepository<User, Integer>{

	@Query("select em from User em where em.dflag =1")
	public List<User> findAllData();
	//public employee save(employee emp);

	@Query("select em from User em where em.id=:id")
	public User findUserById(@Param("id")int id);
	
	@Query("select em from User em where em.userName=:userName")
	public User findUserByUname(@Param("userName")String userName);

	//public employee findById(int id);

}
