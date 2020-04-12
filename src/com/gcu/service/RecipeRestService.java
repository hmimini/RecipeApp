package com.gcu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.models.Recipe;
import com.gcu.business.RecipeBusinessInterface;
import com.gcu.models.Principle;

/**
 * @author Hermes Mimini 
 * RecipeRestService give developers access to see the blogs wiht the database
 */

@RestController
@RequestMapping("/v1")
public class RecipeRestService 
{
	@Autowired
	RecipeBusinessInterface service;
	
	@Autowired
	Principle priciple;
	
	/**
	 * A method to return all recipes from database in JSON formated data
	 * @return List - List containing all Recipes in the database
	 */
	@GetMapping("/recipes")	
	public List<Recipe> getAllRecipes()
	{
		List<Recipe> recipePosts = service.getRecipes();
		
		return recipePosts;
	}
	
	/**
	 * A method to return Recipes from database based on a specified user id in JSON formated data
	 * @param userID - int - Integer to link the user to the database
	 * @return List - refined list containing Recipes in the database
	 */
	@GetMapping("/userRecipes")
	public List<Recipe> getUserRecipes(int userID)
	{
		List<Recipe> recipePosts = service.getUserRecipes(userID);
		
		return recipePosts;
	}
}
