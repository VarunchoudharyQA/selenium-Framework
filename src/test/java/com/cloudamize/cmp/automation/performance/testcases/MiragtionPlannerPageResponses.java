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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class MiragtionPlannerPageResponses extends TestBase {
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
		WebDriverManager.chromedriver().setup();
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
        options.addArguments("--headless");
        options.addArguments("--disable-extensions");*/
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
		azureOverviewPage = new AzureOverviewPage();
		loginPage = new LoginPage();
		migrationPlannerPage = new MigrationPlannerPage();
	}

	@Test(priority = 1)
	public void clickOnMigrationPlannerSummaryTabMigrationDeatilsOpenLink() throws InterruptedException {
		loginPage.getUserNameTextBox().isDisplayed();
		TestBase.loginToCloudamize();
		loginPage.clickOnazureDeatilsButton();
		migrationPlannerPage.clickOnDashboardLink();
		migrationPlannerPage.clickOnMigrationPlannerOption();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		migrationPlannerPage.clickOnproductioTab();
		migrationPlannerPage.clickOnSummaryTab();
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnMigrationDetailsOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go to Migration Planner summary tab and click on Open Link of Migartion Details ", "Migration Planner : Summary Tab Open Links");
	}
	
	@Test(priority = 2)
	public void clickOnMigrationPlannerSummaryTabFireWallRulesOpenLink() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnFirewallRulessOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go Migration Planner summary tab and click on Open Link of Firewall Rules ", "Migration Planner : Summary Tab Open Links ");
	}
	
	@Test(priority = 3)
	public void clickOnMigrationPlannerSummaryTabInstalledAppsOpenLink() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnInstalledAppsOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go Migration Planner summary tab and click on Open Link of Installed Apps ", "Migration Planner : Summary Tab Open Links ");
	}
	
	@Test(priority = 4)
	public void clickOnMigrationPlannerSummaryTabClientAppDNSOpenLink() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnClientAppDNSOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go to Migration Planner summary tab and click on Open Link of Installed Apps ", "Migration Planner : Summary Tab Open Links ");
	}
	
	@Test(priority = 5)
	public void clickOnMigrationPlannerSummaryTabAppCPUUsageOpenLink() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnAppCPUUsageOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go to Migration Planner summary tab and click on Open Link of Installed Apps ", "Migration Planner : Summary Tab Open Links ");
	}
	
	@Test(priority = 6)
	public void clickOnMigrationPlannerSummaryTabIPandDNSOpenOpenLink() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnIPandDNSOpenLink();
		if (TestBase.isLoaderVisible() == true) {
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = ((loginEndTime - lStartTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + totalTime + " " + "Second",
				"Go to Migration Planner summary tab and click on Open Link of Installed Apps ", "Migration Planner : Summary Tab Open Links ");
		loginPage.logoutFromCloudamize();
	}


	@AfterTest
	public void afterTest() {
		System.out.println("Migration Planner open link test cases has been successfully executed ");
		driver.quit();
	}

}
