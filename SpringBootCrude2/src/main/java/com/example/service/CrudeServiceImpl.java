package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.SimpleCrudeRepository;

@Service
public class CrudeServiceImpl implements RestCrudeService{
	
	@Autowired
	public SimpleCrudeRepository crudeRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return crudeRepository.findAllData();
	}

	@Override
	public User save(User emp) {
		// TODO Auto-generated method stub
		return crudeRepository.save(emp);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return crudeRepository.findUserById(id);
	}

	public User findUserByUname(String userName) {
		return crudeRepository.findUserByUname(userName);
	}

}
