package com.qait.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Validate {

	public static boolean validateUrl(WebDriver driver, String expUrl) {

		boolean flag = false;
		if (driver.getCurrentUrl().equalsIgnoreCase(expUrl)) {
			flag = true;
		}
		return flag;

	}

	public static boolean validatePageTitle(WebDriver driver, String expTitle) {

		boolean flag = false;
		if (driver.getTitle().equalsIgnoreCase(expTitle)) {

			flag = true;
		}

		return flag;
	}

	public static boolean validateAnyElement(WebDriver driver, String xpath) {

		boolean flag = false;
		if (driver.findElement(By.xpath(xpath)) != null) {

			flag = true;
		}

		return flag;
	}

	public static boolean validateTextOnAnyElement(WebDriver driver, String xpath, String expText) {

		boolean flag = false;
		if (driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(expText)) {

			flag = true;
		}

		return flag;
	}

}
