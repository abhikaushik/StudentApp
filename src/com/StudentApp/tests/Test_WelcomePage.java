package com.StudentApp.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.StudentApp.utils.GeneralUtilities;
import com.StudentApp.validations.Validate;

public class Test_WelcomePage extends PagesInstances {


	@Test
	public void TC_001_verify_loginpanel_section() throws IOException, InterruptedException {
		System.out.println("driver: "+driver);
		System.out.println("wc_page1: "+wc_page);
		
		wc_page.click_LoginPanel_section();
		driver.manage().window().maximize() ;
		GeneralUtilities.staticwait(500);
		
		GeneralUtilities.takeScreenshot(driver, "TC001_loginfields_PASS");
	}

	

	

	
	
	

}
