package SA_PROD;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class validateLogin {

	public WebDriver driver;

	loginLocators locator;
	FileWriter writer;
	WebDriverWait wait;
	Actions ac;
	String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	String unifyURL = "https://unify.performancematters.com";
	String scanViewURL = "https://scanview.performancematters.com";
	String olaURL = "https://ola.performancematters.com/ola/ola.html?clientCode=flsunshine";

	String userName_Unify_ScanView = "districtadmin11";
	String password_Unify_ScanView = "training";

	String userName_OLA = "4423678870";
	String password_OLA = "sunshine";


	public void fileWriter(String log) {
		try {
			writer = new FileWriter(System.getProperty("user.dir")+ "/Output/"+timeLog+".txt", true);
			writer.write(log);
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	public boolean waitElementPresent(WebElement element) {
		wait = new WebDriverWait(driver, 120);
		if(element != null) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return true;
			}catch(Exception e){
				System.err.println(e.getMessage());
				fileWriter(e.getMessage());
				return false;
			}
		}
		else
			return false;
	}

	public boolean waitForJSandJQueryToLoad() {

		String js = "return document.readyState";

		ExpectedCondition<Boolean> isLoad = (driver) -> {
			Object obj = ((JavascriptExecutor) driver).executeScript(js);
			return (obj != null && obj.toString().equals("complete"));
		};

		return wait.until(isLoad);
	}

	public void browserSetup() {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		locator = PageFactory.initElements(driver, loginLocators.class);
	}

	public void unifyLogin() {
		try {
			browserSetup();
			fileWriter("============================================");
			driver.get(unifyURL);
			fileWriter("Navigate to URL :" + unifyURL);
			waitElementPresent(locator.goBtnUnify);
			locator.goBtnUnify.click();
			fileWriter("Go button has been clicked.");
			waitElementPresent(locator.userNameUnify_ScanView);
			locator.userNameUnify_ScanView.sendKeys(userName_Unify_ScanView);
			fileWriter("UserName has been entered :" + userName_Unify_ScanView);
			locator.passwordUnify_ScanView.sendKeys(password_Unify_ScanView, Keys.ENTER);
			fileWriter("Password has been entered & hit the login button :" + password_Unify_ScanView);
			waitElementPresent(locator.logoutDropDownUnify);
			System.out.println("Home Page Title" + driver.getTitle());
			fileWriter("Home Page Title :" + driver.getTitle());
			locator.logoutDropDownUnify.click();
			waitElementPresent(locator.logoutBtnUnify);
			moveToElement(locator.logoutBtnUnify);
			locator.logoutBtnUnify.click();
			fileWriter("Unify Successfully Logged out");
			driver.close();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			fileWriter(ex.getMessage());
		}
	}

	public void scanViewLogin() {
		try {
			browserSetup();
			fileWriter("============================================");
			driver.get(scanViewURL);
			fileWriter("Navigate to URL :" + scanViewURL);
			waitElementPresent(locator.userNameUnify_ScanView);
			locator.userNameUnify_ScanView.sendKeys(userName_Unify_ScanView);
			fileWriter("UserName has been entered :" + userName_Unify_ScanView);
			locator.passwordUnify_ScanView.sendKeys(password_Unify_ScanView, Keys.ENTER);
			fileWriter("Password has been entered & hit the login button :" + password_Unify_ScanView);
			waitElementPresent(locator.batchLink);
			System.out.println("Home Page Title "+ driver.getTitle());
			fileWriter("Home Page Title :" + driver.getTitle());
			waitElementPresent(locator.logoutScanView);
			locator.logoutScanView.click();
			fileWriter("Scanview Successfully Logged out");
			driver.close();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
			fileWriter(ex.getMessage());
		}
	}

	public void olaLogin() {
		try {
			browserSetup();	
			fileWriter("============================================");
			driver.get(olaURL);
			fileWriter("Navigate to URL :" + olaURL);
			waitElementPresent(locator.usernameTxtBox_Ola);
			locator.usernameTxtBox_Ola.sendKeys(userName_OLA);
			fileWriter("UserName has been entered :" + userName_OLA);
			locator.password_Ola.sendKeys(password_OLA, Keys.ENTER);
			fileWriter("Password has been entered & hit the login button :" + password_OLA);
			System.out.println("Home Page Title " + driver.getTitle());
			fileWriter("Home Page Title :" + driver.getTitle());
			locator.olaSettingsIcon.click();
			locator.logoutOla.click();
			fileWriter(" OLA Successfully Logged out");
			driver.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
			fileWriter(ex.getMessage());
		}

	}

	public static void main(String arg[]) {
		validateLogin login = new validateLogin();
		login.unifyLogin();
		login.scanViewLogin();
		login.olaLogin();
	}













}
