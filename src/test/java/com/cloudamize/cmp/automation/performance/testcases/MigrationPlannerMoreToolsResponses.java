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

public class MigrationPlannerMoreToolsResponses extends TestBase{
  
	AzureOverviewPage azureOverviewPage;
	LoginPage loginPage;
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
	public void clickOnMigrationPlannerButton() throws InterruptedException {
		loginPage.getUserNameTextBox().isDisplayed();
		TestBase.loginToCloudamize();
		loginPage.clickOnazureDeatilsButton();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnDashboardLink();
		migrationPlannerPage.clickOnMigrationPlannerOption();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000); 
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner Button", "Migration Planner");

	}
	
	
	@Test(priority = 2)
	public void clickOnMigrationPlannerMoreToolsAdvancedFiltering() throws InterruptedException 
	{
		System.out.println("Migaration Planner Tools AdvancedFiltering");
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		azureOverviewPage.clickOnMoreToolsButton500Nodes();
		migrationPlannerPage.clickOnAdvancedFilteringOption();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 10000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		TestBase.Wait5();
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools Advanced Filtering Option", "Migration Planner : More Tools ");		
	}
	
	@Test(priority = 3)
	public void clickOnMigrationPlannerMoreToolsMigrateYourEnvironment() throws InterruptedException 
	{
		System.out.println("Migaration Planner Tools MigrateYourEnvironment");
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnMigarteYouEnvironmentOption();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.closeIconPanel)));
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools Migarte Your Environment Option", "Migration Planner : More Tools ");
	
	}
	
	@Test(priority = 4)
	public void clickOnMigartionPlannerMoreToolsBuildMachineBasedMoveGroups() throws InterruptedException 
	{	
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnBuildMachineBasedMoveGroups();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools Machine Based Move Groups", "Migration Planner : More Tools ");	
		
	}
	
	@Test(priority = 5)
	public void clickOnMigartionPlannerMoreToolsBuildApplicationBasedMoveGroups() throws InterruptedException 
	{
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnBuildApplicationBasedMoveGroups();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools Application Based Move Groups", "Migration Planner : More Tools ");	
		
	}
	
	@Test(priority = 6)
	public void clickOnMigartionPlannerMoreToolsUndoMigrationPlannerChanges() throws InterruptedException 
	{
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnUndoMigrationPlannerChanges();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		TestBase.Wait5();
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools Undo Migration Planner Changes", "Migration Planner : More Tools ");	
		
	}
	
	@Test(priority = 7)
	public void clickOnMigartionPlannerMoreToolsCSVBuilder() throws InterruptedException 
	{
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickonCSVBuilder();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools CSV Builder" , "Migration Planner : More Tools ");	
		
	}
	
	@Test(priority = 8)
	public void clickOnMigartionPlannerMoreToolsCSVExporter() throws InterruptedException 
	{
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickonCSVExporter();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		TestBase.Wait5();
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools CSV Exporter", "Migration Planner : More Tools ");	
		
	}
	
	@Test(priority = 9)
	public void clickOnMigartionPlannerMoreToolsSQLServerAndLicenseUsage() throws InterruptedException 
	{
		TestBase.Wait5();
		azureOverviewPage.clickOnMoreTools();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnSQLServerAndLicenseUsage();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		TestBase.Wait5();
		migrationPlannerPage.clickOnCloseIconPanel();
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner More Tools SQL Server and License Usage", "Migration Planner : More Tools ");
		
	}
	
	@Test(priority = 10)
	public void clickOnMigartionPlannerApplicationView() throws InterruptedException 
	{
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		migrationPlannerPage.clickOnApplicationView();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"Click on Migration Planner Application View", "Migration Planner : More Tools ");
		loginPage.logoutFromCloudamize();
		
	}
	

  
	@AfterTest
	public void afterTest() {
		System.out.println("Migration Planner More Tools test cases has been successfully executed ");
		driver.quit();
	}

}
