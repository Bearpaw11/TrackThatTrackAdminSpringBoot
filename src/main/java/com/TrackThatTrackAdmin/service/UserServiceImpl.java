package com.TrackThatTrackAdmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrackThatTrackAdmin.dao.UserRepository;
import com.TrackThatTrackAdmin.entity.User;

@Service
public class UserServiceImpl implements UserService {
    // Creating User Repository Instance
	private UserRepository userRepository;
	
	//Autowired is allowing spring to place a bean of UserRepository into UserServiceImpt to use in Override methods
	@Autowired
	public UserServiceImpl(UserRepository theEmployeeRepository) {
		userRepository = theEmployeeRepository;
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	//Find all users method
	@Override
	public User findById(int theId) {
		Optional<User> result = userRepository.findById(theId);
		
		//setting theUser to null
		User theUser = null;
		
		//if result has user, use .get() to set theUser to 
		if (result.isPresent()) {
			theUser = result.get();
		}
		else {
			// we didn't find the employee. Throw following runtime exception
			throw new RuntimeException("Did not find user id - " + theId);
		}
		
		return theUser;
	}
	
	//method to Save and update
	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	//delete method
	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}

}








