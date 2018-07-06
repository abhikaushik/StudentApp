package com.StudentApp.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {

	WebDriver driver;
	ResourceBundle welcome;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		welcome = ResourceBundle.getBundle("WelcomePage");
	}

	public void click_LoginPanel_section() {
		driver.findElement(By.xpath(welcome.getString("Customer_Login_xpath"))).click();

	}

	
	
	public void doLogin(String uname, String pwd)
	{
		driver.findElement(By.xpath(welcome.getString("login_uname_xpath"))).sendKeys(uname);
		driver.findElement(By.xpath(welcome.getString("login_pwd_xpath"))).sendKeys(pwd);
		driver.findElement(By.xpath(welcome.getString("login_sigin_xpath"))).click();
	}
	
	
	
	

}
