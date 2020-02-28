package com.cloudamize.cmp.automation.performance.testcases;

import org.testng.annotations.Test;

import com.cloudamize.cmp.automation.performance.base.Constants;
import com.cloudamize.cmp.automation.performance.base.TestBase;
import com.cloudamize.cmp.automation.performance.base.WriteUtil;
import com.cloudamize.cmp.automation.performance.pages.AzureOverviewPage;
import com.cloudamize.cmp.automation.performance.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AzureOverviewResponses extends TestBase {
	AzureOverviewPage azureOverviewPage;
	LoginPage loginPage;
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
	}

	@Test(priority = 1)
	public void clickOnSummaryTabOfOverviewDetailsGrid() throws InterruptedException {
		loginPage.getUserNameTextBox().isDisplayed();
		TestBase.loginToCloudamize();
		loginPage.clickOnazureDeatilsButton();
		long lStartTime = new Date().getTime();
		azureOverviewPage.clickOnComputeTab();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"click on Compute Tab of overview Details grid", "Microsoft Azure Overview Tab");

	}
	
	@Test(priority = 2)
	public void clickOnStorageTabOverviewDetailsGrid() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		azureOverviewPage.clickOnStorageTab();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"click on Storage Tab of overview Details grid", "Microsoft Azure Overview Tab");

	}

	@Test(priority = 3)
	public void clickOnNetworkTabOverviewDetailsGrid() throws InterruptedException {
		TestBase.Wait5();
		long lStartTime = new Date().getTime();
		azureOverviewPage.clickOnNetwrokTab();
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"click on Network Tab of overview Details grid", "Microsoft Azure Overview Tab");

	}

	@Test(priority = 4)
	public void clickOnSettings() throws InterruptedException 
	{
		TestBase.Wait10();
		long lStartTime = new Date().getTime();
		azureOverviewPage.clickOnSettingOptions();
		if(TestBase.isLoaderVisible() == true) 
		{
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Constants.loadingIcon)));
		}
		String text = azureOverviewPage.getAssetSettingsTab().getText();
		System.out.println(text);
		Assert.assertEquals(text, "Asset Settings");
		long loginEndTime = System.currentTimeMillis();
		long totalTime = loginEndTime - lStartTime;
		long ExtraTime = 5000;
		long finalTime = ((totalTime - ExtraTime) / 1000);
		WriteUtil.writeData(startTime, "" + finalTime + " " + "Second",
				"click on Setting option of username link", "Microsoft Azure Overview Tab");
		TestBase.Wait5();
		loginPage.logoutFromCloudamize();		
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AzureOverview page test cases has been successfully executed ");
		driver.quit();
	}

}
