package com.TrackThatTrackAdmin.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.TrackThatTrackAdmin.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// that's it ... no need to write any code LOL!
	
	// add a method to sort by last name
	public List<User> findAll();
	
}
