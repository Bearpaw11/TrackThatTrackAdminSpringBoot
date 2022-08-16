package com.TrackThatTrackAdmin.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.TrackThatTrackAdmin.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
	// Method to find all Users
    
	public List<User> findAll();
	
	//all other methods come from CrudRepository
}
