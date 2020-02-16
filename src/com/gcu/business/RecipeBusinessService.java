package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.models.Principle;
import com.gcu.models.Recipe;

/**
 * This is the business service for the Recipe model, all the logic that
 * connects the controller and the database is used in here.
 * 
 * @author Hermes Mimini
 *
 */
public class RecipeBusinessService implements RecipeBusinessInterface {

	// Inject the recipeDataService
	@SuppressWarnings("rawtypes")
	@Autowired
	DataAccessInterface recipeDataService;
	
	@Autowired
	Principle principle;

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getRecipes() {
		// call the recipeDataService to return the recipe list
		return recipeDataService.viewAll();
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int addRecipe(Recipe recipe, int userID) {
		// call the create dataService function
		return recipeDataService.create(recipe, userID);

	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@Override
	public int deleteRecipe(Recipe recipe) {
		// call the create dataService function
		return recipeDataService.delete(principle.getRecipeID());
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int editRecipe(Recipe recipe, int id) {
		// call the create dataService function
		return recipeDataService.update(recipe, id);
	}
	
	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Recipe findRecipeByObject(Recipe recipe) 
	{
		return (Recipe) recipeDataService.viewByObject(recipe);
	}
	
	/**
	 * @see RecipeBusinessInterface
	 */
	@Override
	public Recipe findRecipeById(int id) 
	{
		return (Recipe) recipeDataService.viewById(id);
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getUserRecipes(int ID) {
		return recipeDataService.viewByParentId(principle.getUserID());
	}

}
