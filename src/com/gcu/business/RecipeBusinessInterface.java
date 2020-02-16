package com.gcu.business;

import java.util.List;

import com.gcu.models.Recipe;

/**
 * This is the business service for the Recipe model, all the logic that
 * connects the controller and the database is used in here.
 * 
 * @author Hermes Mimini
 *
 */
public interface RecipeBusinessInterface {

	// Interface methods

	/**
	 * This method will utilize the recipeDataService and return a list of all the
	 * recipes in the database.
	 * 
	 * @return list - List(Type Recipe) Class
	 */
	public List<Recipe> getRecipes();

	/**
	 * This method will utilize the recipeDataService and return a list of recipes
	 * in the database that are unique to the user that is calling it.
	 * 
	 * @return list - List(Type Recipe) Class (List of all recipes in the database.)
	 */
	public List<Recipe> getUserRecipes(int ID);

	/**
	 * This method will take in a recipe object and will add it to the database,
	 * after the recipe is added it will return a Boolean.
	 * 
	 * @param recipe - Recipe Class (Recipe that will be added to the database.)
	 * @param uniqueId The foreign key of the user.
	 * @return Boolean Class - (Boolean value depending on the result of the
	 *         dataService.)
	 */
	public int addRecipe(Recipe recipe, int userID);

	/**
	 * This method will delete the recipe that is sent to it, it will grab the
	 * recipe ID and use the dataService to delete the recipe. Once complete a
	 * boolean object is going to be returned.
	 * 
	 * @param recipe - Recipe Class (Recipe that will be removed from the database.)
	 * @return Boolean Class - (Boolean value depending on the result of the
	 *         dataService.)
	 */
	public int deleteRecipe(Recipe recipe);

	/**
	 * This method will update the content of the recipe by using the
	 * recipeDataService.
	 * 
	 * @param recipe - Recipe Class (Recipe that will be updated in the database.)
	 * @param recipeId - The foreign key.
	 * @return Boolean Class - (Boolean value depending on the result of the
	 *         dataService.)
	 */
	public int editRecipe(Recipe recipe, int id);
	
	/**
	 * This method will prompt the database for a recipe, by using the object model as a parameter. 
	 * 
	 * @param recipe - Recipe Class
	 * @return Recipe Class
	 */
	public Recipe findRecipeByObject(Recipe recipe);
	
	/**
	 * This method will prompt the database for a recipe, by using the recipeID as a parameter.
	 * 
	 * @param id - Recipe ID
	 * @return - Recipe Model
	 */
	public Recipe findRecipeById(int id);

}
