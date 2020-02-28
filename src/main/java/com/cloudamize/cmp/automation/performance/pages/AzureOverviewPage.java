package com.cloudamize.cmp.automation.performance.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cloudamize.cmp.automation.performance.base.Constants;
import com.cloudamize.cmp.automation.performance.base.TestBase;

public class AzureOverviewPage extends TestBase
{

	LoginPage loginPage = new LoginPage();
	
	@FindBy(xpath = Constants.summarytab)
	public WebElement summaryTab;
	
	@FindBy(xpath = Constants.computetab)
	public WebElement computeTab;
	
	@FindBy(xpath = Constants.MigrationPlannerButton)
	public WebElement migrationPlannerButton;
	
	@FindBy(xpath = Constants.MoreToolsButton)
	public WebElement moreToolsButton;
	
	@FindBy(xpath = Constants.loadingIcon)
	public WebElement LoadingIcon;
	
	@FindBy(xpath = Constants.PopUpPanel)
	public WebElement popuppanel;
	
	@FindBy(xpath = Constants.PopUpPanleGlass)
	public WebElement popUpPanelGalss;
	
	@FindBy(xpath = Constants.settings)
	public WebElement Settings;
	
	@FindBy(xpath = Constants.assetsettingstab)
	public WebElement assetSettingsTab;
	
	@FindBy(xpath = Constants.StorageTab)
	public WebElement StorageTab;
	
	@FindBy(xpath = Constants.NetwrokTab)
	public WebElement NetwrokTab;
	
	@FindBy(xpath = Constants.MoreToolsButton500Nodes)
	public WebElement MoreToolsButton500Nodes;

	public WebElement getAssetSettingsTab() {
		return assetSettingsTab;
	}

	public WebElement getSettings() {
		return Settings;
	}

	public WebElement getLoadingIcon() {
		return LoadingIcon;
	}

	public WebElement getMoreToolsButton() {
		return moreToolsButton;
	}

	public WebElement getMigrationPlannerButton() {
		return migrationPlannerButton;
	}
	

	public AzureOverviewPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSummaryTab() {
		return summaryTab;
	}
	
	public WebElement getComputeTab() {
		return computeTab;
	}
	
	
	
	public void clickOnComputeTab() throws InterruptedException {
		TestBase.Wait5();
		getComputeTab().isDisplayed();
		getComputeTab().click();
	}
	
	public void clickOnStorageTab() throws InterruptedException {
		TestBase.Wait5();
		StorageTab.isDisplayed();
		StorageTab.click();
	}

	public void clickOnNetwrokTab() throws InterruptedException {
		TestBase.Wait5();
		NetwrokTab.isDisplayed();
		NetwrokTab.click();
	}

	
	
	public void clickOnMigrationPlannerButton() throws InterruptedException 
	{
		TestBase.Wait5();
		getMigrationPlannerButton().isDisplayed();
		getMigrationPlannerButton().click();
	}
	
	public void clickOnSettingOptions() throws InterruptedException 
	{
		TestBase.Wait5();
		loginPage.getUsernameLink().click();
		getSettings().click();
		
		
	}
	
	public void clickOnMoreTools() throws InterruptedException
	{
		TestBase.Wait5();
		List<WebElement> elements = driver.findElements(By.xpath(Constants.MoreToolsButton));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 0) 
        	{
        	elements.get(i).click();
        	}
        }
	}
	
	public void clickOnMoreToolsButton500Nodes() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.MoreToolsButton));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 0) 
        	{
        	elements.get(i).click();
        	}
        }
	}
	
}