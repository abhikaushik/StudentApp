package com.StudentApp.tests;

import java.util.ResourceBundle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.StudentApp.base.Configuration;
import com.StudentApp.pages.HomePage;
import com.StudentApp.pages.WelcomePage;

public class PagesInstances extends Configuration{

	public ResourceBundle welcome;
	public WelcomePage wc_page;
	public ResourceBundle Home;
	public HomePage home_page;
	
	
	@BeforeClass
	public void createInstances()
	{
		welcome = ResourceBundle.getBundle("WelcomePage");
		wc_page = new WelcomePage(driver);
		Home =ResourceBundle.getBundle("HomePage");
		home_page = new HomePage(driver);
		
	}
	
}
