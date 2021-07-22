package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.UserRepository;

/**
 * 
 * @author harmand
 * 'UserServiceImpl', Service layer implemented
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	/**
	 * userRepository
	 */
	UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long userID) {
		return userRepository.findById(userID);
	}

}
