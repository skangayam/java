package com.cloudwick.exception;

@SuppressWarnings("serial")
public class InvalidUserException extends Exception {

	private String firstname;
	private String lastname;

	public InvalidUserException(String message) {
		super(message);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
