package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class SecureAreaPage.
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class SecureAreaPage extends BasePageObject {

	private By successLoginMsgLocator = By.id("flash");
	private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
	private String pageUrl = "http://the-internet.herokuapp.com/secure";

	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Get page url of Secure Area page */
	public String getPageUrl() {
		return this.pageUrl;
	}

	/** Get a success login message */
	public String getSuccessLoginMsg() {
		return this.find(this.successLoginMsgLocator).getText();
	}

	/** Verification if LogOut button is displayed */
	public boolean isVisibleLogOutButton() {
		return this.find(this.logOutButtonLocator).isDisplayed();
	}
}
