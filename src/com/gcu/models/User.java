package com.gcu.models;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	// initialize properties used for the user class
	@NotNull(message="First name cannot be null.")
	@Size(min=2, max=30, message="First name must be between 2 and 30 characters.")
	String firstName = "";
	@NotNull(message="Last name cannot be null.")
	@Size(min=2, max=30, message="Last name must be between 2 and 30 characters.")
	String lastName = "";

	@NotNull(message="Email cannot be null.")
	@Email(message="Must be a valid email.")
	@Size(min=2, max=30, message="Email must be between 2 and 30 characters.")
	String email = "";

	@NotNull(message="Phone Number cannot be null.")
	@Pattern(regexp="([0-9]{3}+-[0-9]{3}+-[0-9]{4})|([0-9]{10})", message="Please enter a valid phone number.")
	String phoneNumber = "";

	@NotNull(message = "Please enter an ID. This is a required field.")
	private int ID;

	@Valid
	private Credentials credentials = new Credentials();

	// Constructor
	public User(int ID, String firstName, String lastName, String email, String phoneNumber, String userName,
			String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.credentials.setUsername(userName);
		this.credentials.setPassword(password);
		this.ID = ID;
	}

	// For test purposes only
	public User() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
		this.credentials.setUsername("");
		this.credentials.setPassword("");
		this.ID = -1;

	}

	// getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
