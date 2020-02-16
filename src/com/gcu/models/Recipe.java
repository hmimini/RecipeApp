package com.gcu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Recipe {

	// initialize properties used for the Recipe class
	@NotNull(message = "Please enter a Name. This is a required field.")
	@Size(min = 4, max = 15)
	String name;

	@NotNull(message = "Please enter a Description. This is a required field.")
	@Size(min = 10)
	String description;

	@NotNull(message = "Please enter Ingredients. This is a required field.")
	@Size(min = 10, max = 2000)
	String ingredients;

	@NotNull(message = "Please enter nutritional information. This is a required field.")
	@Size(min = 10, max = 5000)
	String nutritionalInformation;

	@NotNull(message = "Please enter a price. This is a required field.")
	float price;

	@NotNull(message = "Please enter a price. This is a required field.")
	int ID;

	// Default Constructor
	public Recipe() {
		this.name = "";
		this.description = "";
		this.ingredients = "";
		this.nutritionalInformation = "";
		this.price = 0;
		this.ID = -1;
	}

	// Constructor with properties
	public Recipe(int ID, String name, String description, String ingredients, String nutritionalInformation,
			int price) {
		super();
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.nutritionalInformation = nutritionalInformation;
		this.price = price;
		this.ID = ID;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getNutritionalInformation() {
		return nutritionalInformation;
	}

	public void setNutritionalInformation(String nutritionalInformation) {
		this.nutritionalInformation = nutritionalInformation;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
