package com.cloudamize.cmp.automation.performance.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersBlog implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		System.out.println(" TestNG Started execution of Test case named as : " + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
		System.out.println(result.getName() + " Test Case is successfully executed ");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		System.out.println(result.getName() + " Test Case got Failed ");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		
		
	}

	
}
