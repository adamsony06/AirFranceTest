package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.application.AirFranceTestApplication;
import com.example.controllerRest.ControllerUser;
import com.example.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AirFranceTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AirFranceTestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	ControllerUser controllerUser;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {

	}

	/**
	 * testGetUserById, to test the method getUsersById in ControllerUser
	 */
	@Test
	public void testGetUserById() {
		User user = new User();
		user.setName("VLADO");
		user.setPlaceOfResedence("France");
		user.setPlaceOfBirth("JAPON");
		user.setFirstName("jojobernard");
		user.setAge(53);
		controllerUser.registerUser(user);
		User userIdentified = restTemplate.getForObject(getRootUrl() + "/api/v1/users/1", User.class);
		System.out.println(userIdentified.getFirstName());
		Assert.assertNotNull(userIdentified);
	}

	/**
	 * testCreateUser, to test the method registerUser in ControllerUser
	 */
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("VLADO");
		user.setPlaceOfResedence("France");
		user.setPlaceOfBirth("JAPON");
		user.setFirstName("jojobernard");
		user.setAge(53);
		HttpEntity<User> request = new HttpEntity<>(user);

		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/users/", request,
				User.class);

		Assert.assertNotNull(postResponse.getBody());
	}
}
