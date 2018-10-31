package SA_PROD;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginLocators {
	
	@FindBy (id = "pmlogin")
	WebElement goBtnUnify;
	
	@FindBy (name = "username")
	WebElement userNameUnify_ScanView;
	
	@FindBy (name = "password")
	WebElement passwordUnify_ScanView;
	
	@FindBy (xpath = "//span[text()='Robert Pattinson']")
	WebElement logoutDropDownUnify;
	
	@FindBy (xpath = "//a[text()='Logout']")
	WebElement logoutBtnUnify;
	
	@FindBy (xpath = "//a[text()='Logout']")
	WebElement logoutScanView;
	
	@FindBy (xpath = "//a[contains(text(),'batch')]")
	WebElement batchLink;
	
	@FindBy (id = "login")
	WebElement usernameTxtBox_Ola;
	
	@FindBy (id = "ola-password")
	WebElement password_Ola;
	
	@FindBy (xpath = "//i[@class = 'fa fa-cog fa-2x']")
	WebElement olaSettingsIcon;
	
	@FindBy (xpath = "//a[text()='Logout']")
	WebElement logoutOla;

}
