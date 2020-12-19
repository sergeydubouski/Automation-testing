package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * class TestListener.
 * 
 * @author SD
 * @version 1.0
 * @since 26.11.2020
 */
public class TestListener implements ITestListener {

	private Logger logListener;
	private WebDriver driver;
	

	@Override
	public void onTestStart(ITestResult result) {
		this.logListener.info("[TEST METHOD\s" + result.getName() + " STARTED]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.logListener.info("[TEST METHOD\s" +  result.getName() + " PASSED]");		
		TestUtil.takeScreenshot(result.getTestContext().getName(),"PASSED TEST\s"+result.getName());			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.logListener.info("[TEST METHOD " +  result.getName() + " FAILED]");
		TestUtil.takeScreenshot(result.getTestContext().getName(),"\sFAILED@"+result.getName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		this.logListener = LogManager.getLogger(context.getName()+"@Listener");
		this.logListener.info("[TEST " + context.getName() + " STARTED]");

	}

	@Override
	public void onFinish(ITestContext context) {
		this.logListener.info("[TEST " + context.getName() + " FINISHED]");
	}

}
