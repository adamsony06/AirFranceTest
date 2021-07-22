package com.example.service;

import java.util.Optional;

import com.example.model.User;

/**
 * 
 * @author harmand
 * 'UserService', Service layer
 */

public interface UserService {
	
	/**
	 * 
	 * @param user
	 * @return user
	 * method to register a user 
	 */
	public User registerUser(User user);
	
	/**
	 * 
	 * @param userID
	 * @return Optional<User>
	 * method to find a user in the database with his id
	 */
	public Optional<User> findById(Long userID);
	
	

}
