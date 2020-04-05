package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	Logger logger = LoggerFactory.getLogger(RecipeBusinessService.class);

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getRecipes() {
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: getRecipes()");
		logger.info("RecipeLogger---Business Layer: List of all recipes being grabbed");
		// call the recipeDataService to return the recipe list
		return recipeDataService.viewAll();
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int addRecipe(Recipe recipe, int userID) {
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: addRecipe()");
		logger.info("RecipeLogger---Business Layer: User adding a recipe");
		// call the create dataService function
		return recipeDataService.create(recipe, userID);

	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@Override
	public int deleteRecipe(Recipe recipe) {
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: deleteRecipe()");
		logger.info("RecipeLogger---Business Layer: User deleting recipe");
		// call the create dataService function
		return recipeDataService.delete(principle.getRecipeID());
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int editRecipe(Recipe recipe, int id) {
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: editRecipe()");
		logger.info("RecipeLogger---Business Layer: User editing recipe");
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
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: findRecipeByObject()");
		logger.info("RecipeLogger---Business Layer: User searching for recipe");
		return (Recipe) recipeDataService.viewByObject(recipe);
	}
	
	/**
	 * @see RecipeBusinessInterface
	 */
	@Override
	public Recipe findRecipeById(int id) 
	{
		logger.info("RecipeLogger---Class Entered: RecipeBusinessService.class, Method: findRecipeById()");
		logger.info("RecipeLogger---Business Layer: Finding by recipe ID");
		return (Recipe) recipeDataService.viewById(id);
	}

	/**
	 * @see RecipeBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getUserRecipes(int ID) {
		logger.info("RecipeLogger---Class Entered: UserBusinessService.class, Method: getUserRecipes()");
		logger.info("RecipeLogger---Business Layer: Greabbing users recipe");
		return recipeDataService.viewByParentId(principle.getUserID());
	}

}
