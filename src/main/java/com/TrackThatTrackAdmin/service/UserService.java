package com.TrackThatTrackAdmin.service;

import java.util.List;

import com.TrackThatTrackAdmin.entity.User;

public interface UserService {

	//Crud Methods used by UserServiceImpl
	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);


	
}
