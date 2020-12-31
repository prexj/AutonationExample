package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public interface RestCrudeService {

	public List<User> findAll();

	public User save(User emp);

	public User findById(int id);

}
