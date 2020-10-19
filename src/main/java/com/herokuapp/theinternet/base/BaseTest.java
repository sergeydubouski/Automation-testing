package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * class BaseTest.
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class BaseTest {
	
	protected String browser;
	protected Logger log;
	protected WebDriver driver;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	protected void setUpDriver(@Optional("chrome")String browser,ITestContext ctx) {
		
		this.browser=browser;
		
		String name=ctx.getCurrentXmlTest().getName();
		this.log=LogManager.getLogger(name);

		
		this.driver=new BrowserFactory(this.browser,this.log).createDriver();
	}
	
	@AfterTest(alwaysRun=true)
	protected void tearDown() {
		this.log.info("Close browser\s"+this.browser+".");
		this.driver.quit();
	}
	
}
