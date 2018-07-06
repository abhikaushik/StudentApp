package com.StudentApp.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Test_Home extends PagesInstances {


	
	@Test
	public void TC001_Login_With_Credentials() throws InterruptedException {
		System.out.println("2"+driver);
		System.out.println("wc_page2: "+wc_page);
		wc_page.click_LoginPanel_section();
		
driver.manage().window().maximize() ;
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "/html/body/div/div[1]/div/div[1]/form/div[1]/input")));
		
		wc_page.doLogin("districtadmin11", "training");
		Thread.sleep(1000);
		
	}

}


