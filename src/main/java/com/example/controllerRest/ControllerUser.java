package com.example.controllerRest;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.User;
import com.example.service.UserService;

/**
 * 
 * @author harmand Class ControllerUser, the res controller
 */
@RestController
@RequestMapping("/api/v1")
public class ControllerUser {

	@Autowired
	/**
	 * userService
	 */
	private UserService userService;

	/**
	 * 'FRANCE' a String
	 */
	private final static String FRANCE = "france";

	/**
	 * to log the input and the output of each call
	 */
	private static final Logger logger = LoggerFactory.getLogger(ControllerUser.class);

	/**
	 * User registration service.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PostMapping(path = "/users", consumes = "application/json")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

		logger.info("User registration service");

		try {
			if (user.getAge() > 18 && FRANCE.equalsIgnoreCase(user.getPlaceOfResedence())) {

				if (user.getPlaceOfBirth() == null || user.getPlaceOfBirth().isEmpty()) {
					user.setPlaceOfBirth("Sans lieu de naissance");
				}

				User userCreated = userService.registerUser(user);
				logger.info("Registration successful for the user " + userCreated.getName() + " "
						+ userCreated.getFirstName());

				return new ResponseEntity<>(
						"the user " + userCreated.getName() + " " + userCreated.getFirstName() + " is registered",
						HttpStatus.CREATED);
			}

			else {
				logger.info("Registration failed");
				return new ResponseEntity<>("the user isn't 18 years old or his place of residence" + " is not France",
						HttpStatus.BAD_REQUEST);

			}
		} catch (DataIntegrityViolationException exc) {
			logger.info("Registration failed");
			return new ResponseEntity<>("one mandatory field is missing in the request", HttpStatus.BAD_REQUEST);
		} catch (NullPointerException exc) {
			logger.info("Registration failed");
			return new ResponseEntity<>("Age  or place of resedence field is missing in the request",
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Display user details service
	 * 
	 * @param userId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable("id") Long userId) throws ResourceNotFoundException {

		logger.info("Display user details service : user id is " + userId);

		Optional<User> userOptional = userService.findById(userId);

		if (userOptional != null && !userOptional.isEmpty()) {
			User user = userOptional.get();
			logger.info("User found");
			return ResponseEntity.ok().body(user);
		} else {
			logger.info("User not found");
			throw new ResourceNotFoundException("User not found on. Bad user id : " + userId);
		}

	}

}
