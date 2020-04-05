package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.business.UserBusinessInterface;
import com.gcu.models.Principle;
import com.gcu.models.User;
import com.gcu.models.Credentials;

@Controller
@RequestMapping("/loginRegistration")
public class UserController {
	
UserBusinessInterface service;
	
	@Autowired
	Principle principle;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	
	/**
	 * Displays the registration form to the user with an empty user object
	 * @return ModelAndView - sends the user to the registration page with a blank user
	 */
	@RequestMapping(path="/registrationForm", method=RequestMethod.GET)
	public ModelAndView displayRegistrationForm()
	{
		logger.info("RecipeLogger---Class Entered: UserController.class, Method: displayRegistrationForm()");
		logger.info("Presentation Layer: RecipeLogger---User has accessed the registration from.");
		return new ModelAndView("registration", "user", new User());
	}
	
	/**
	 * Displays the user the login form and send a empty user to the view in order to fill with information inputed by the user
	 * @return ModelAndView - send the user to the login page with an empty user credentials objects
	 */
	@RequestMapping(path="/loginForm", method=RequestMethod.GET)
	public ModelAndView displayLoginForm()
	{
		logger.info("RecipeLogger---Class Entered: UserController.class, Method: displayRegistrationForm()");
		logger.info("Presentation Layer: RecipeLogger---User has accessed the login form.");
		return new ModelAndView("login", "user", new Credentials());
	}
	
	/**
	 * After the user is presses submit on the registration form this method is called to first validate the 
	 * input of the user is correct. Then will add the user to the data base and send them to the login page to complete 
	 * the login process
	 * @param user - User - object containing all variables of the user 
	 * @param result - BindingResult - object used to determine if the information inputed was valid
	 * @return ModelAndView
	 */
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user") User user, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("registration", "user", user);
		}
		
		try
		{
			//Adding the user to the data base
			int returnNum = service.registerUser(user);
			
			//If all Database actions were completed successfully
			if(returnNum > 0)
			{
				logger.info("RecipeLogger---Class Entered: UserController.class, Method: registerUser()");
				logger.info("Presentation Layer: RecipeLogger---User has registered successfully.");
				return new ModelAndView("login", "user" , user.getCredentials());
			}
			
			//If a user was already created with the same user name
			else if(returnNum == -1)
			{
				logger.info("RecipeLogger---Class Entered: UserController.class, Method: registerUser()");
				logger.info("Presentation Layer: RecipeLogger---User has failed to register.");
				ModelAndView modelAndView = new ModelAndView();
				user.setCredentials(new Credentials());
				modelAndView.setViewName("registration");
				modelAndView.addObject("user", user);
				modelAndView.addObject("message", new String("That User Name is Already Taken!"));
				return modelAndView; 
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPageIndex");
			modelAndView.addObject(e);
			return modelAndView;
			
		}

		return null;
	}
	
	/**
	 * After the user submits their user name and password the loginUser method is called to validate
	 * their information and send them to the home page
	 * @param user - User - object containing all variables of the user 
	 * @param result - BindingResult - object used to determine if the information inputed was valid
	 * @return ModelAndView - returns the user to a new page based on the information they had given
	 */
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("user")Credentials user, BindingResult result)
	{
		//Validates the users information for data validation errors 
		if(result.hasErrors())
		{
			return new ModelAndView("login", "user", user);
		}
		
		try
		{		
			//Validates users information 		
			if(service.validateUsers(user))
			{
				logger.info("RecipeLogger---Class Entered: UserController.class, Method: loginUser()");
				logger.info("Presentation Layer: RecipeLogger---User has logged in successfully.");
				HomePageController homePageObject = new HomePageController();
				return homePageObject.displayHomePage(user);
			}
			
			else
			{
				logger.info("RecipeLogger---Class Entered: UserController.class, Method: loginUser()");
				logger.info("Presentation Layer: RecipeLogger---Unsuccessful login, invalid credentials.");
				ModelAndView modelAndView = new ModelAndView("login", "user", user);
				modelAndView.addObject("message", "Invalid Credentials");
				return modelAndView;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return new ModelAndView("errorPageIndex");
		}

	}
	
	/**
	 * Displays Page with all the user information
	 * @return ModelAndView - display the page with current users information
	 */
	@RequestMapping(path="/userInformation", method=RequestMethod.GET)
	public ModelAndView displayUserInfo()
	{
		logger.info("RecipeLogger---Class Entered: UserController.class, Method: displayUserInfo()");
		logger.info("Presentation Layer: RecipeLogger---User accessing personal information.");
		try
		{
			ModelAndView modelAndView = new ModelAndView("userInformation");
		
			int userID = principle.getUserID();
			
			User returnUser = service.getCurrentUser(userID);
			
			
			modelAndView.addObject("user", returnUser);
			return modelAndView;
		}
		
		catch(Exception e)
		{
			return new ModelAndView("errorPageIndex");
		}
	}
	
	/**
	 * Sends the user to the user form
	 * 
	 * @return ModelAndView - displays a user form with populated text boxes
	 */
	@RequestMapping(path="/editUserForm", method=RequestMethod.GET)
	public ModelAndView displayEditUserFrom()
	{
		logger.info("RecipeLogger---Class Entered: UserController.class, Method: displayEditUserFrom()");
		logger.info("Presentation Layer: RecipeLogger---User accessing editUserFrom.");
		int userID = principle.getUserID();
		User user = service.getCurrentUser(userID);
		
		ModelAndView modelAndView = new ModelAndView("editUser", "user", user);
		return modelAndView;
	}
	
	/**
	 * This method w-ll call the business service and edit the user in the database. 
	 * 
	 * @param user - User Model that will be updated
	 * @param result - BindingResult
	 * @return ModelAndView - With the new updated information
	 */
	@RequestMapping(path="/editUser", method=RequestMethod.POST)
	public ModelAndView editUser(@Valid @ModelAttribute("user") User user, BindingResult result)
	{
		logger.info("RecipeLogger---Class Entered: UserController.class, Method: editUser()");
		logger.info("Presentation Layer: RecipeLogger---User editing personal information.");
		if(result.hasErrors())
		{
			return new ModelAndView("editUser", "user", user);
		}
		
		int userID = principle.getUserID();
		
		try
		{
			//Adding the user to the data base
			service.updateUser(user, userID);
			
			return new ModelAndView("userInformation");
		}
		
		catch(Exception e)
		{
			return new ModelAndView("errorPage");
		}
		
	}
	
	/**
	 * setUserBusinessService is used to inject out data service through IoC and Dependecy Injection
	 * @param service - UserBusinessInterface - service in order to interact with the business service
	 */
	@Autowired
	public void setUserBusinessService(UserBusinessInterface service)
	{
		this.service = service;
	}

}
