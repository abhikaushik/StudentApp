package com.StudentApp.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 

{

	WebDriver driver;
	ResourceBundle Home;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		Home = ResourceBundle.getBundle("HomePage");
	}

	public void click_LoginPanel_section() {
		driver.findElement(By.xpath(Home.getString("Home_Test"))).click();
		
		driver.findElement(By.xpath(Home.getString("Home_Test_New_Test"))).click();
	}

	

}