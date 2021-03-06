package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.models.Credentials;
import com.gcu.models.Principle;
import com.gcu.data.DataAccessInterface;
import com.gcu.models.User;

/**
 * This is the business service for the User Object, all the logic that connects
 * the controller and the database is used in here.
 * 
 * @author Hermes Mimini
 *
 */
public class UserBusinessService implements UserBusinessInterface {

	// Inject the dataSerice
	@SuppressWarnings("rawtypes")
	@Autowired
	DataAccessInterface userDataService;
	
	@Autowired
	Principle principle;
	
	Logger logger = LoggerFactory.getLogger(UserBusinessService.class);

	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public Boolean validateUsers(Credentials user) {
		logger.info("RecipeLogger---Class Entered: UserBusinessService.class, Method: validateUser()");
		logger.info("RecipeLogger---Business Layer: User being validated with UserID" + user.getID());
		// Initialize variable to set the user valid or not
		boolean validUser = false;

		// Gets the full list of users from the Database
		List<User> userList = userDataService.viewAll();

		// For loop to iterate through the list of users to match the credentials
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getCredentials().getUsername().equals(user.getUsername())
					&& userList.get(i).getCredentials().getPassword().equals(user.getPassword())) {
				validUser = true;
				principle.setUserID(userList.get(i).getID());
				principle.setUserName(userList.get(i).getCredentials().getUsername());
				break;
			}
		}
		logger.info("RecipeLogger---Method Exited: validateUsers() ,Class: UserBusinessService.class");
		return validUser;
	}

	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int registerUser(User user) {
		logger.info("RecipeLogger---Class Entered: UserBusinessService.class, Method: registerUser()");
		logger.info("RecipeLogger---Business Layer: User being registered.");
		// Add user to database
		logger.info("RecipeLogger---Method Exited: registerUser() ,Class: UserBusinessService.class");
		return userDataService.create(user, -1);
	}
	
	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateUser(User user, int userID) {
		logger.info("RecipeLogger---Class Entered: UserBusinessService.class, Method: updateUser()");
		logger.info("RecipeLogger---Business Layer: User info being updated.");
		logger.info("RecipeLogger---Method Exited: updateUser() ,Class: UserBusinessService.class");
		return userDataService.update(user, userID);
	}
	
	/**
	 * @see UserBusinessInterface
	 */
	@Override
	public User getCurrentUser(int userID) {
		logger.info("RecipeLogger---Class Entered: UserBusinessService.class, Method: getCurrentUser()");
		logger.info("RecipeLogger---Business Layer: getting user with userID: " + userID);
		logger.info("RecipeLogger---Method Exited: getCurrentUser() ,Class: UserBusinessService.class");
		return (User) userDataService.viewById(userID);
	}
}
