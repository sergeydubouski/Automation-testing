package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	Logger log;
	String testName;
	String testMethodName;

	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		this.log.info("[TEST METHOD " + this.testMethodName + " STARTED]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.log.info("[TEST METHOD " + this.testMethodName + " PASSED]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.log.info("[TEST METHOD " + this.testMethodName + " FAILED]");
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
		this.testName = context.getSuite().getName()+"->"+context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(this.testName);
		this.log.info("[TEST " + this.testName + " STARTED]");

	}

	@Override
	public void onFinish(ITestContext context) {
		this.log.info("[TEST " + this.testName + " FINISHED]");
	}

}
