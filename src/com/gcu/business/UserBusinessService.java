package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.models.Credentials;
import com.gcu.models.Principle;
import com.gcu.data.DataAccessInterface;
import com.gcu.models.User;

/**
 * This is the business service for the User model, all the logic that connects
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

	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public Boolean validateUsers(Credentials user) {
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

		return validUser;
	}

	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int registerUser(User user) {
		// Add user to database
		return userDataService.create(user, -1);
	}
	
	/**
	 * @see UserBusinessInterface
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateUser(User user, int userID) {
		return userDataService.update(user, userID);
	}
	
	/**
	 * @see UserBuesinessInterface
	 */
	@Override
	public User getCurrentUser(int userID) {
		return (User) userDataService.viewById(userID);
	}
}
