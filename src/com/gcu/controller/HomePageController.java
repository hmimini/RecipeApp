package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.models.Credentials;
import com.gcu.models.Principle;

/**
 * @author Hermes Mimini and Isaiah Camacho
 * HomePageController is a class used to pass through data from pages as well as direct the user to the correct view
 */

@Controller
@RequestMapping("/welcomepage")
public class HomePageController 
{
	@Autowired
	Principle principle;
	
	Logger logger = LoggerFactory.getLogger(HomePageController.class);
	
	/**
	 * displayHomePage is called from the login page when the validation was successful
	 * @param user - User - object containing all variables of the user 
	 * @return ModelAndView - send the user to the home page
	 */
	@RequestMapping("/homepage")
	public ModelAndView displayHomePage(@Valid Credentials user)
	{
		logger.info("RecipeLogger---Presentation Layer: User has accessed the homepage!");
		logger.info("RecipeLogger---Class Entered: HomePageController.class, Method: displayHomePage()");
		logger.info("RecipeLogger---Method Exited: displayHomePage() ,Class: HomePageController.class");
		return new ModelAndView("homePage");
		
	}
}
