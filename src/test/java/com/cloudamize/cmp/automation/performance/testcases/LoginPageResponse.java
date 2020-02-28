package com.cloudamize.cmp.automation.performance.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cloudamize.cmp.automation.performance.base.Constants;
import com.cloudamize.cmp.automation.performance.base.TestBase;
import com.cloudamize.cmp.automation.performance.base.WriteUtil;
import com.cloudamize.cmp.automation.performance.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



// @Listeners(com.cloudamize.cmp.automation.performance.listeners.ListenersBlog.class)
public class LoginPageResponse extends TestBase {
	LoginPage loginPage;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String startTime = dateFormat.format(date);

	String filename = "ResponceTime.csv";

	public LoginPageResponse() {
		super();
	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");*/
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage();
		
	}

	@Test(priority = 1)
	public void LoginTocloudmizeApplication() throws InterruptedException {

			loginPage.enterUserName(prop.getProperty("username"));
			loginPage.enterPassword(prop.getProperty("password"));
			long lStartTime = new Date().getTime();
			loginPage.clickOnLoginButton();
			if(TestBase.isLoaderVisible() == true) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 3000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
			}
			System.out.println(driver.findElement(By.xpath("//div[@id='nodeCountLabel']")).getText());
			long loginEndTime = System.currentTimeMillis();
			long totalTime = ((loginEndTime - lStartTime) / 1000);
			WriteUtil.writeData(startTime, "" + totalTime + " " + "Second", "Login To Cloudmize Application", "Login");
			loginPage.logoutFromCloudamize();
	}

	@Test(priority = 2)
	public void LogoutFromCloudamizeApplication() throws InterruptedException {
		
			loginPage.enterUserName(prop.getProperty("username"));
			loginPage.enterPassword(prop.getProperty("password"));
			//loginPage.enterPassword(System.getProperty("Password"));
			loginPage.clickOnLoginButton();
			
			
			if(TestBase.isLoaderVisible() == true) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 3000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
			}
			long lStartTime = new Date().getTime();
			loginPage.getAzureDeatilsButton().isDisplayed();
			loginPage.logoutFromCloudamize();
			long loginEndTime = System.currentTimeMillis();
			long totalTime = ((loginEndTime - lStartTime) / 1000);
			WriteUtil.writeData(startTime, "" + totalTime + " " + "Second", "Logout from Application", "Login");

	}
	
	@Test(priority = 3)
	public void viewDetailsofMicrosoftAzure() throws InterruptedException {
		
			loginPage.enterUserName(prop.getProperty("username"));
			loginPage.enterPassword(prop.getProperty("password"));
			//loginPage.enterPassword(System.getProperty("Password"));
			loginPage.clickOnLoginButton();
			if(TestBase.isLoaderVisible() == true) 
			{
				WebDriverWait wait = new WebDriverWait(driver, 3000);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
			}
			long lStartTime = new Date().getTime();
			loginPage.clickOnazureDeatilsButton();
			long loginEndTime = System.currentTimeMillis();
			long totalTime = ((loginEndTime - lStartTime) / 1000);
			WriteUtil.writeData(startTime, "" + totalTime + " " + "Second", "Click on View Details of Microsoft Azure" , "Login");
			loginPage.logoutFromCloudamize();

	}


	@AfterTest
	public void afterTest() {
		System.out.println("Login page test cases has been successfully executed ");
		driver.quit();
	}

}
