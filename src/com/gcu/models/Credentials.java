package com.gcu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Credentials {

	// initialize properties used for the Credentials class
	@NotNull(message="User name cannot be null.")
	@Size(min=2, max=30, message="User name must be between 2 and 30 characters.")
	String username = "";

	@NotNull(message="Pass word cannot be null.")
	@Size(min=2, max=30, message="Password must be between 2 and 30 characters.")
	String password = "";

	@NotNull(message = "Please enter an ID. This is a required field.")
	int ID;

	// Constructor with parameters
	public Credentials(String username, String password, int ID) {
		super();
		this.username = username;
		this.password = password;
		this.ID = ID;
	}

	// Default Constructor
	public Credentials() {
		this.username = "";
		this.password = "";
		this.ID = -1;
	}

	// getters and setters for the variables
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
