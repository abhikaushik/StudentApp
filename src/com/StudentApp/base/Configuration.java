package com.StudentApp.base;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Configuration {

	protected WebDriver driver;
	protected ResourceBundle config;

	@BeforeClass
	public void start() 
	{
		config = ResourceBundle.getBundle("Config");
		if (config.getString("browser").equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (config.getString("browser").equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.get(config.getString("baseURL"));
		System.out.println("1"+driver);
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}
