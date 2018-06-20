package com.qait.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qait.validations.Validate;

public class Configuration {

	WebDriver driver;

	@Test
	public void start() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Validate.validateAnyElement(driver, "//*[@id=\"hplogo\"]");
		Validate.validateTextOnAnyElement(driver, "//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a",
				"Gmail");
		System.out.println("+++++++ Validation Test is Passed +++++++++");
		System.out.println("+++++++ Validation Test is Passed +++++++++");

	}

}
