package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";
	private By formAuthenticationLink = By.xpath("//*[@id=\'content\']/ul/li[21]/a");
	private By checkboxesLinkLocator=By.linkText("Checkboxes");
	private By alertsLinkLocator=By.linkText("JavaScript Alerts");
	private By multipleWindowsLocator=By.xpath("//*[text()='Multiple Windows']");

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/**open welcome page*/
	public void openWelcomePage() {
		this.log.info("Open Welcome page.");
		this.open(this.pageUrl);
	}

	/**open login page by clicking form Authentication link*/
	public LoginPage clickFormAuthenticationLink() {
		this.log.info("Click form Authentication link.");
		this.click(this.formAuthenticationLink);
		return new LoginPage(this.driver, this.log);
	}
	
	/**open checkboxes page by clicking checkboxes link*/
	public CheckboxesPage clickCheckboxesLink() {
		this.log.info("Click Checkboxes link.");
		this.click(this.checkboxesLinkLocator);
		return new CheckboxesPage(this.driver, this.log);		
	}
	
	/**open JavaScript Alerts page by clicking  js alerts link*/
	public AlertsPage clickAlertsLink() {
		this.log.info("Click JavaScript Alerts link.");
		this.click(this.alertsLinkLocator);
		return new AlertsPage(this.driver, this.log);
	}
	
	/**open Multiple windows page by clicking multiple windows link*/
	public MultipleWindowsPage clickMultipleWindowsLink() {
		this.log.info("Click Multiple Windows link.");
		this.click(this.multipleWindowsLocator);
		return new MultipleWindowsPage(this.driver, this.log);
	}
}
