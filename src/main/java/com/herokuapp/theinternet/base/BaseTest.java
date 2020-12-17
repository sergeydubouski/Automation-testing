package com.herokuapp.theinternet.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * class BaseTest.
 * 
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */

@Listeners({ com.herokuapp.theinternet.base.TestListener.class })
public class BaseTest {

	protected String browser;
	protected Logger log;
	protected WebDriver driver;
	protected String testSuiteName;//used in takeScreenshot method
	protected String testName;//used in takeScreenshot method
	protected String testMethodName;//used in takeScreenshot method

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	protected void setUpDriver(Method method, @Optional("chrome") String browser, ITestContext ctx) {

		this.browser = browser;

		String name = ctx.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(name);

		this.driver = new BrowserFactory(this.browser, this.log).createDriver();

		this.testSuiteName = ctx.getSuite().getName();
		this.testName = name;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		this.log.info("Close browser\s" + this.browser + ".");
		this.driver.quit();
	}

}
