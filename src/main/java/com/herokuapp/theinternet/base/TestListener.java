package com.herokuapp.theinternet.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

/**
 * class TestListener.
 * 
 * @author SD
 * @version 1.0
 * @since 26.11.2020
 */
public class TestListener implements ITestListener {

	private Logger logListener;
	private String testName;

	@Attachment(value = "Page screenshot", type = "image/png")
	private byte[] saveScreenshot() {
		TakesScreenshot scrShot = ((TakesScreenshot) BrowserFactory.getThreadDriver());
		return scrShot.getScreenshotAs(OutputType.BYTES);

	}

	@Attachment(value = "{0}", type = "text/plain")
	private String saveTextLog(String msg) {
		return msg;
	}
	@Override
	public void onTestStart(ITestResult result) {
		this.logListener.info("[TEST METHOD\s" + result.getName() + " STARTED]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.logListener.info("[TEST METHOD\s" + result.getName() + " PASSED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName()+"\sPASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + "\sFAILED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName()+"\sFAILED");
		this.saveTextLog(result.getThrowable().getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + "\sSKIPPED]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName()+"\sSKIPPED");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		this.logListener.info("[TEST METHOD " + result.getName() + "\sFAILED WITH TIMEOUT]");
		this.saveScreenshot();
		this.saveTextLog(result.getMethod().getMethodName()+"\sFAILED WITH TIMEOUT");
	}

	@Override
	public void onStart(ITestContext context) {
		this.logListener = LogManager.getLogger(context.getName() + "@Listener");
		this.logListener.info("[TEST " + context.getName() + " STARTED]");

	}

	@Override
	public void onFinish(ITestContext context) {
		this.logListener.info("[TEST " + context.getName() + " FINISHED]");
	}

}
