package com.gcu.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Priciple object is the websites way of keeping track of the users information throught there time on the webite
 * throught a session scoped class
 * 
 * @author Hermes Mimini and Isaiah Camacho
 *
 */
@Component
@Scope("session")
public class Principle 
{
	/**
	 * Defining the properties of the class
	 */
	private int userID;
	private int recipeID;
	private String username;
	private Recipe recipe;
	
	/**
	 * Default constructor to initialize the variables
	 */
	public Principle()
	{
		userID = -1;
		recipeID = -1;
	}
	
	
	/**
	 * Getters and setters for the properties of the class
	 * @return object - return the object of the property
	 */
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Recipe getRecipe() {
		return recipe;
	}


	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
}
