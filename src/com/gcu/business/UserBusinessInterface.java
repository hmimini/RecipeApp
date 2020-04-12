package com.gcu.business;

import com.gcu.models.Credentials;
import com.gcu.models.User;

public interface UserBusinessInterface {

	// Interface methods

	/**
	 * This method will register(write) a User to the database.
	 * 
	 * @param user- User Class - (User that will be added to the database.)
	 * @return Boolean Class - (Boolean value depending on the result of the
	 *         dataService.)
	 */
	public int registerUser(User user);

	/**
	 * This method will use comparing logic and return true or false if the
	 * credentials that were sent equal to the credentials in the database.
	 * 
	 * @param user- User Class - (User that will be used in the login authentication
	 *            logic.)
	 * @return Boolean Class - (Boolean value depending on the result of the
	 *         dataService.)
	 */
	public Boolean validateUsers(Credentials user);
	
	/**
	 * This method will take in a user model from the view and a userID onto
	 *  which the elements of are going to be updated
	 *  
	 * @param user - User model with elements that are going to change into
	 * @param userID - User ID that is going to be updated
	 * @return integer
	 */
	public int updateUser(User user, int userID);
	
	/**
	 * getCurrentUser takes in a userID a returns a filled out user model from the data service
	 * 
	 * @param userID - The ID of the User that is searched
	 * @return user - User - object containing all the information of the properties
	 */
	public User getCurrentUser(int userID);

}
