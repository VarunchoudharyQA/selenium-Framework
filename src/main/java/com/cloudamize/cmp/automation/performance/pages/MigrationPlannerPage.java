package com.cloudamize.cmp.automation.performance.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cloudamize.cmp.automation.performance.base.Constants;
import com.cloudamize.cmp.automation.performance.base.TestBase;

public class MigrationPlannerPage extends TestBase {
	@FindBy(xpath = Constants.productiontab)
	public WebElement productioTab;
	
	@FindBy(xpath = Constants.advancedFiltering)
	public WebElement advancedFilteingTab;
	
	@FindBy(xpath = Constants.lowUtilization)
	public WebElement LowUtilization;
	
	@FindBy(xpath = Constants.closeIconPanel)
	public WebElement closeIconPanel;
	
	@FindBy(xpath = Constants.MigrateYourEnvironment)
	public WebElement MigrateYourEnvironment;
	
	@FindBy(xpath = Constants.BuildMachineBasedMoveGroups)
	public WebElement BuildMachineBasedMoveGroups;
	
	@FindBy(xpath = Constants.BuildApplicationBasedMoveGroups)
	public WebElement BuildApplicationBasedMoveGroups;
	
	@FindBy(xpath = Constants.clearAllCheckBox)
	public WebElement clearAllCheckBox;
	
	@FindBy(xpath = Constants.productionCheckBox)
	public WebElement productionCheckBox;
	
	@FindBy(xpath = Constants.ApplicationInventorySettings)
	public WebElement ApplicationInventorySettings;
	
	@FindBy(xpath = Constants.SummaryTab)
	public WebElement SummaryTab;
	
	@FindBy(xpath = Constants.MigrationDeatilsOpenLink)
	public WebElement MigrationDeatilsOpenLink;
	
	@FindBy(xpath = Constants.SummaryTabOpenLinks)
	public WebElement summaryTabOpenLinks;
	

	@FindBy(xpath = Constants.DetailedLinks)
	public WebElement DetailedLinks;
	
	@FindBy(xpath = Constants.undoMigrationPlannerChanges)
	public WebElement undoMigrationPlannerChanges;
	
	@FindBy(xpath = Constants.CSVBuilder)
	public WebElement CSVBuilder;
	
	@FindBy(xpath = Constants.CSVExporter)
	public WebElement CSVExporter;
	
	@FindBy(xpath = Constants.SQLServerAndLicenseUsage)
	public WebElement SQLServerAndLicenseUsage;
	
	@FindBy(xpath = Constants.ApplicationView)
	public WebElement applicationView;
	
	@FindBy(xpath = Constants.MachineDetailsDetailed)
	public WebElement MachienDetailsDetailed;
	
	@FindBy(xpath = Constants.FirewallRulesDetailedLink)
	public WebElement FirewallRulesDetailedLink;
	
	@FindBy(xpath = Constants.InstalledAppsDetailedLink)
	public WebElement InstalledAppsDetailedLink;
	
	@FindBy(xpath = Constants.ClientAppDNS)
	public WebElement ClientAppDNS;
	
	@FindBy(xpath = Constants.AppCPUUsage)
	public WebElement AppCPUUsage;
	
	@FindBy(xpath = Constants.IPAndDNS)
	public WebElement IPAndDNS;
	
	@FindBy(xpath = Constants.APPInterconnectivityAll)
	public WebElement APPInterconnectivityAll;
	
	@FindBy(xpath = Constants.APPInterconnectivitySelectedOnly)
	public WebElement APPInterconnectivitySelectedOnly;
	
	@FindBy(xpath = Constants.DownloadAll)
	public WebElement DownloadAll;
	
	@FindBy(xpath = Constants.Isodr)
	public WebElement ISODR;
	
	@FindBy(xpath = Constants.NJHealthPAS)
	public WebElement NJHealthPAS;
	
	@FindBy(xpath = Constants.others50000)
	public WebElement others50000;
	
	@FindBy(xpath = Constants.DashboardLink)
	public WebElement DashboardLink;
	
	@FindBy(xpath = Constants.MigrationPlannerOption)
	public WebElement MigrationPlannerOption;
	
	@FindBy(xpath = Constants.MigrationPlannerLink)
	public WebElement MigrationPlannerLink;

	@FindBy(xpath = Constants.Dashboardoption)
	public WebElement Dashboardoption;
	
	
	@FindBy(xpath = Constants.ProjectManagementTab)
	public WebElement ProjectManagementTab;
	
	public WebElement getUndoMigrationPlannerChanges() {
		return undoMigrationPlannerChanges;
	}
	
	public WebElement getBuildMachineBasedMoveGroups() {
		return BuildMachineBasedMoveGroups;
	}
	
	public WebElement getBuildApplicationBasedMoveGroups() {
		return BuildApplicationBasedMoveGroups;
	}


	public MigrationPlannerPage(){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCloseIconPanel() {
		return closeIconPanel;
	}

	public WebElement getLowUtilization() {
		return LowUtilization;
	}

	public WebElement getproductioTab() {
		return productioTab;
	}
	
	public WebElement getadvancedFiltering() {
		return advancedFilteingTab;
	}


	public void clickOnproductioTab() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.productiontab));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 1) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}

	
	public void clickOnAdvancedFilteringOption() throws InterruptedException
	{
		TestBase.Wait5();
		advancedFilteingTab.click();
	}
	
	public void clickOnCloseIconPanel()
	{
		TestBase.Wait5();
		getCloseIconPanel().click();
	}
	
	public void clickOnMigarteYouEnvironmentOption() throws InterruptedException
	{
		TestBase.Wait5();
		MigrateYourEnvironment.click();
	}
	
	public void clickOnBuildMachineBasedMoveGroups() throws InterruptedException
	{
		TestBase.Wait5();
		getBuildMachineBasedMoveGroups().click();
		
	}
	
	public void clickOnBuildApplicationBasedMoveGroups() throws InterruptedException
	{
		TestBase.Wait5();
		getBuildApplicationBasedMoveGroups().click();
		
	}
	
	public void clickOnClearAllCheckBox() throws InterruptedException
	{
		TestBase.Wait5();
		clearAllCheckBox.click();
		
	}
	
	public void clickOnProductionCheckBox() throws InterruptedException
	{
		TestBase.Wait5();
		productionCheckBox.click();
		
	}
	
	public void clickOnApplicationInventorySettings() throws InterruptedException 
	{
		TestBase.Wait5();
		ApplicationInventorySettings.click();
	}
	
	public void clickOnSummaryTab() 
	{
		SummaryTab.click();
	}
	
	public void clickOnMigrationDetailsOpenLink() 
	{
		MigrationDeatilsOpenLink.click();
	}
	
	public void clickonCSVBuilder() throws InterruptedException
	{
		TestBase.Wait5();
		CSVBuilder.click();
	}
	
	
	public void clickonCSVExporter() throws InterruptedException
	{
		TestBase.Wait5();
		CSVExporter.click();
	}
	
	public void clickOnSQLServerAndLicenseUsage() throws InterruptedException
	{
		TestBase.Wait5();
		SQLServerAndLicenseUsage.click();
		
	}
	
	public void clickOnApplicationView() throws InterruptedException
	{
		TestBase.Wait5();
		applicationView.click();
	}
	
	public void clickOnUndoMigrationPlannerChanges() throws InterruptedException
	{
		TestBase.Wait5();
		getUndoMigrationPlannerChanges().click();
	}
	
	public void clickOnFirewallRulessOpenLink() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.FirewallOpenLink));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 0) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}
	
	public void clickOnInstalledAppsOpenLink() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.InstalledAppsOpenLink));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 1) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}
	
	public void clickOnClientAppDNSOpenLink() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.ClientAppDNSOpenLink));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 2) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}
	
	public void clickOnAppCPUUsageOpenLink() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.AppCPUUsageOpenLink));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 3) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}
	
	public void clickOnIPandDNSOpenLink() 
	{
		List<WebElement> elements = driver.findElements(By.xpath(Constants.IPandDNSOpenLink));
        for(int i=0 ; i<elements.size();i++)
        {
        	if(i == 4) 
        	{
        	elements.get(i).click();
        	}
        }
        
	}
	
	public void clickOnMigrationDetailsDetailedLink() 
	{
		TestBase.Wait5();
		MachienDetailsDetailed.click();	
        
	}
	
	public void clickOnFirewallRulessDetailedLink() 
	{
		TestBase.Wait5();
		FirewallRulesDetailedLink.click();
	}
	
	public void clickOnInstalledAppsDetailedLink() 
	{
		TestBase.Wait5();
		InstalledAppsDetailedLink.click();
		
	}
	
	public void clickOnClientAppDNSDetailedLink() 
	{
		TestBase.Wait5();
		ClientAppDNS.click();
		
	}
	
	public void clickOnAppCPUUsageDetailedLink() 
	{
		TestBase.Wait5();
		AppCPUUsage.click();	
	}
	
	public void clickOnIPAndDNSDetailedLink() 
	{
		TestBase.Wait5();
		IPAndDNS.click();	
	}
	
	public void clickOnAPPInterconnectivityAll() 
	{
		TestBase.Wait5();
		APPInterconnectivityAll.click();
	}
	
	public void clickOnAPPInterconnectivitySelectedOnly() 
	{
		TestBase.Wait5();
		APPInterconnectivitySelectedOnly.click();
	}
	
	public void clickOnDownloadAll() 
	{
		TestBase.Wait5();
		DownloadAll.click();
	}
	
	public void clickOnISODR() 
	{
		TestBase.Wait5();
		ISODR.click();
	}
	
	public void clickNJHealthPAS() 
	{
		TestBase.Wait5();
		NJHealthPAS.click();
	}
	
	public void clickothers50000() 
	{
		TestBase.Wait5();
		others50000.click();
		
	}
	
	public void clickOnDashboardLink() 
	{
		TestBase.Wait5();
		DashboardLink.click();
	}
	
	public void clickOnMigrationPlannerOption() 
	{
		TestBase.Wait5();
		MigrationPlannerOption.click();
	}
	
	public void clickOnDashboardOption() 
	{
		TestBase.Wait5();
		Dashboardoption.click();
	}
	
	public void clickOnMigrationPlannerLink() 
	{
		TestBase.Wait5();
		MigrationPlannerLink.click();
	}
	
	public void clickOnProjectManagementTab() 
	{
		TestBase.Wait5();
		ProjectManagementTab.click();
	}

}
