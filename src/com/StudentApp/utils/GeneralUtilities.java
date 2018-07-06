package com.StudentApp.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	public static void takeScreenshot(WebDriver driver, String imagename) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File f1 = ss.getScreenshotAs(OutputType.FILE);
		File f2 = new File("./screenshots/" + imagename + ".png");
		FileUtils.copyFile(f1, f2);

	}

	public static void staticwait(int timeinmilliseconds) throws InterruptedException {
		Thread.sleep(timeinmilliseconds);
	}

	public static void waitForSomeElementVisibility(WebDriver driver, int timeOutInSeconds, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
	}

}
