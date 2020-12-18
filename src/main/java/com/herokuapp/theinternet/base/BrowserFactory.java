package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class BrowserFactory.
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class BrowserFactory {

	//private ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	private Logger log;
	private String browser;

	public BrowserFactory(String browser, Logger log) {
		this.browser = browser;
		this.log = log;
	}

	public WebDriver createDriver() {
		switch (this.browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			DriverContainer.driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			DriverContainer.driver.set(new FirefoxDriver());
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			DriverContainer.driver.set(new ChromeDriver());
			break;
		}
		this.log.info("Created browser\s"+this.browser+".");
		return DriverContainer.driver.get();		
	}
}
