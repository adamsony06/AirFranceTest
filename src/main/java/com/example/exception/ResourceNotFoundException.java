package com.example.exception;

/**
 * 
 * @author harmand Exception created for the method getUsersById,
 */
public class ResourceNotFoundException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the class ResourceNotFoundException
	 * 
	 * @param s
	 */
	public ResourceNotFoundException(String s) {
		super(s);
	}
}
