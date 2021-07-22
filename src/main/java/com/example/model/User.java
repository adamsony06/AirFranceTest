package com.example.model;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author harmand 'User'
 */
@Entity(name = "User")
@Table(name = "users")
public class User{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/** user id */
	private Long id;

	@Column(name = "name", nullable = false)
	/** name of the user */
	private String name;

	@Column(name = "first_name", nullable = false)
	/** first name of the user */
	private String firstName;

	@Column(name = "age", nullable = false)
	/** age of the user */
	private Integer age;

	@Column(name = "place_of_birth", nullable = true)
	/** lieu de naissance of the user */
	private String placeOfBirth;

	@Column(name = "place_of_residence", nullable = false)
	/** place of residence of the user */
	private String placeOfResedence;

	/**
	 * Constructor of user class with all parameters
	 * 
	 * @param id
	 * @param name
	 * @param firstName
	 * @param age
	 * @param placeOfBirth
	 * @param placeOfResedence
	 */
	public User(Long id, String name, String firstName, Integer age, String placeOfBirth, String placeOfResedence) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
		this.placeOfBirth = placeOfBirth;
		this.placeOfResedence = placeOfResedence;
	}

	public User(Long id, String name, String firstName, Integer age, String placeOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
		this.placeOfBirth = placeOfBirth;
	}

	public User(Long id, String name, String firstName, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.age = age;
	}

	public User(Long id, String name, String firstName) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
	}

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User(Long id) {
		super();
		this.id = id;
	}

	public User() {

	}

	/**
	 * Getter 'id'
	 *
	 * @return 'id'
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter 'id'
	 *
	 * @param id 'id'
	 *
	 *           required parameter : 'id'
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter 'name'
	 *
	 * @return 'name'
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter 'name'
	 *
	 * @param name 'name'
	 *
	 *             required parameter : 'name'
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter 'firstName'
	 *
	 * @return 'firstName'
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter'firstName'
	 *
	 * @param firstName 'firstName'
	 *
	 *                  required parameter : 'firstName'
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter 'age'
	 *
	 * @return 'age'
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Setter 'age'
	 *
	 * @param age 'age'
	 *
	 *            required parameter : 'age'
	 */

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Getter 'placeOfBirth'
	 *
	 * @return 'placeOfBirth'
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * Setter 'placeOfBirth'
	 *
	 * @param placeOfBirth 'placeOfBirth'
	 *
	 *                     required parameter : 'placeOfBirth'
	 */

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * Getter 'placeOfResedence'
	 *
	 * @return 'placeOfResedence'
	 */
	public String getPlaceOfResedence() {
		return placeOfResedence;
	}

	/**
	 * Setter 'placeOfResedence'
	 *
	 * @param placeOfResedence 'placeOfResedence'
	 *
	 *                         required parameter : 'placeOfResedence'
	 */

	public void setPlaceOfResedence(String placeOfResedence) {
		this.placeOfResedence = placeOfResedence;
	}

}
