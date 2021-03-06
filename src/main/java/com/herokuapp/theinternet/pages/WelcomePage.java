package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

	private String pageUrl = "http://the-internet.herokuapp.com/";
	private By formAuthenticationLinkLocator = By.xpath("//*[@id=\'content\']/ul/li[21]/a");
	private By checkboxesLinkLocator=By.linkText("Checkboxes");
	private By alertsLinkLocator=By.linkText("JavaScript Alerts");
	private By multipleWindowsLinkLocator=By.xpath("//*[text()='Multiple Windows']");
	private By wYSIWYGLinkLocator=By.linkText("WYSIWYG Editor");
	private By keyPressesLinkLocator=By.linkText("Key Presses");

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
		this.click(this.formAuthenticationLinkLocator);
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
		this.click(this.multipleWindowsLinkLocator);
		return new MultipleWindowsPage(this.driver, this.log);
	}
	
	/**open WYSIWYG Editor page by clicking WYSIWYG Editor link*/
	public IFramePage clickWYSIWYGLink() {
		this.log.info("Click WYSIWYG Editor link.");
		this.click(this.wYSIWYGLinkLocator);
		return new IFramePage(this.driver, this.log);
	}
	
	/**open Key Presses page by clicking Key Presses link*/
	public KeyPressesPage clickKeyPressesLink() {
		this.log.info("Click Key Presses link.");
		this.click(this.keyPressesLinkLocator);
		return new KeyPressesPage(this.driver, this.log);
	}
}
