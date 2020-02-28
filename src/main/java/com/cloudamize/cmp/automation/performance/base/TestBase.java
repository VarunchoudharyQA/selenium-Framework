package com.cloudamize.cmp.automation.performance.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudamize.cmp.automation.performance.pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;



public class TestBase 

{
	
	public static  WebDriver driver;


	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/cloudamize/cmp/automation/"
					+ "/performance/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openBrowser(){
		String browserName = prop.getProperty("browserchrome");
		
		if(browserName.equals("chrome")){
			//String Chromepath = System.getProperty("user.dir");
			//System.out.println(Chromepath);
			//System.setProperty("webdriver.chrome.driver",Chromepath + "/chromedriver");		
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			String Firefoxpath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver",Firefoxpath + "/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));		
	}
	
	public static void openBrowserInHeadlessMode() 
	{
		String browserName = prop.getProperty("browserchromelinux");
		System.out.println(browserName);
		if(browserName.equals("chrome_linux")){
			/*String Chromepath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",Chromepath + "/chromedriver");*/	
			ChromeOptions options = new ChromeOptions();
			/*options.addArguments("--no-sandbox");
			options.addArguments("--start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-dev-shm-usage");*/

			options.addArguments("--test-type");
	        options.addArguments("--headless");
	        options.addArguments("--disable-extensions");
			/*options.setExperimentalOption("useAutomationExtension", false);*/
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/Applications/UIAutomation_Wireframe/cmp-automation-performance/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("chrome")) 
		{
			String pathForChrome = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",pathForChrome + "/chromedriver.exe");	
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
	}
	
	public static void openBrowserInHeadlessModeForDownloadFiles() throws ClientProtocolException, IOException
	{
		String downloadpath = System.getProperty("user.dir");
		String downloadFilepath = downloadpath +  "/FileDownloads";
		
		HashMap<String, Object> chromePreferences = new HashMap<String, Object>();
		chromePreferences.put("profile.default_content_settings.popups", 0);
		chromePreferences.put("download.prompt_for_download", "false");
		chromePreferences.put("download.default_directory", downloadFilepath);
		ChromeOptions chromeOptions = new ChromeOptions();
		String Chromepath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",Chromepath + "/chromedriver");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("headless");	
		chromeOptions.setExperimentalOption("prefs", chromePreferences);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		ChromeDriverService driverService = ChromeDriverService.createDefaultService();
		ChromeDriver driver = new ChromeDriver(driverService, chromeOptions);
		Map<String, Object> commandParams = new HashMap<>();
		commandParams.put("cmd", "Page.setDownloadBehavior");
		Map<String, String> params = new HashMap<>();
		params.put("behavior", "allow");
		params.put("downloadPath", downloadFilepath);
		commandParams.put("params", params);
		ObjectMapper objectMapper = new ObjectMapper();
		HttpClient httpClient = HttpClientBuilder.create().build();
		String command = objectMapper.writeValueAsString(commandParams);
		String u = driverService.getUrl().toString() + "/session/" + driver.getSessionId() + "/chromium/send_command";
		HttpPost request = new HttpPost(u);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(command));
		httpClient.execute(request);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void Wait5() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void Wait10() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void loginToCloudamize() {
		LoginPage loginPage = new LoginPage();
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(System.getProperty("Password"));
		  loginPage.clickOnLoginButton();
	}
	
	public static WebElement waitUntilVisible(WebElement element) 
	{
		final int timeToWait = 10000;
		WebDriverWait wait = new WebDriverWait(driver, timeToWait);
		return wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	
	public static WebElement waitUntileClickable(By element) 
	{
		final int timeTowait = 10000;
		WebDriverWait wait = new WebDriverWait(driver, timeTowait);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static boolean isLoaderVisible() 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.loadingIcon)));	
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public static boolean isGridLoaderVisible() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.Gridloader)));
		return true; 
	}

	

		
}
