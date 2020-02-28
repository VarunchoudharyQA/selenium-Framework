package com.cloudamize.cmp.automation.performance.testcases;

import org.testng.annotations.Test;

import com.cloudamize.cmp.automation.performance.base.Constants;
import com.cloudamize.cmp.automation.performance.base.TestBase;
import com.cloudamize.cmp.automation.performance.base.WriteUtil;
import com.cloudamize.cmp.automation.performance.pages.AzureOverviewPage;
import com.cloudamize.cmp.automation.performance.pages.LoginPage;
import com.cloudamize.cmp.automation.performance.pages.MigrationPlannerPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MigrrationPlannerDetailedLinkResponses extends TestBase{
 
	
	LoginPage loginPage;
	AzureOverviewPage azureOverviewPage;
	MigrationPlannerPage migrationPlannerPage;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String startTime = dateFormat.format(date);
	WebDriverWait wait;

	String filename = "ResponceTime.csv";

	@BeforeTest
	public void beforeTest() {
		/*// final String binaryPath = "chromeBinary";
		String Chromepath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",Chromepath + "/chromedriver.exe");*/
		WebDriverManager.chromedriver().setup();
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");*/
        // options.setBinary(binaryPath);
		HashMap<String, Object> chromePref = new HashMap<>();
		chromePref.put("download.default_directory", System.getProperty("java.io.tmpdir"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		azureOverviewPage = new AzureOverviewPage();
		loginPage = new LoginPage();
		migrationPlannerPage = new MigrationPlannerPage();
	}

	@Test(priority = 1)
	public void clickOnMigrationPlannerSummaryTabMigrationDeatilsDetailedLink() throws InterruptedException {
		loginPage.getUserNameTextBox().isDisplayed();
		TestBase.loginToCloudamize();
		loginPage.clickOnazureDeatilsButton();
		migrationPlannerPage.clickOnDashboardLink();
		migrationPlannerPage.clickOnMigrationPlannerOption();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		migrationPlannerPage.clickOnproductioTab();
		migrationPlannerPage.clickOnSummaryTab();
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnMigrationDetailsDetailedLink();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 10000;
		long finalTime = ((totalTime - ExtraTime) / 1000); 
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Download machine details from summary Tab" , "Migration Planner : Summary Tab Details Links");
		
	}
	
	@Test(priority = 2)
	public void clickOnMigrationPlannerSummaryTabFirewallRulesDetailedLink() throws InterruptedException {
		TestBase.Wait5();
		migrationPlannerPage.clickOnSummaryTab();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnFirewallRulessDetailedLink();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000); 
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Download firewall rules details from summary Tab", "Migration Planner : Summary Tab Details Links");
		migrationPlannerPage.clickOnProjectManagementTab(); 
		loginPage.logoutFromCloudamize();
	}
		
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
