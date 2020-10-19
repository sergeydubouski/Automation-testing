package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class LoginPage.
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class LoginPage extends BasePageObject {

	private By usernameLocator = By.xpath("//input[@id='username']");
	private By passwordLocator = By.xpath("//input[@id='password']");
	private By loginButtonLocator = By.xpath("//button[@type='submit']");
	private By errMsgForInvalidLoginLocator = By.id("flash");
	private String pageUrl="http://the-internet.herokuapp.com/login";

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Execute log in */
	public SecureAreaPage logIn(String username, String password) {
		this.log.info("Executing log in with username [" + username + "] and password [" + password + "].");
		this.type(this.usernameLocator, username);
		this.type(this.passwordLocator, password);
		this.click(this.loginButtonLocator);
		return new SecureAreaPage(this.driver, this.log);
	}

	/** Execute negative log in */
	public void negativeLogin(String username, String password) {
		this.log.info("Executing negative log in with username [" + username + "] and password [" + password + "].");
		this.type(this.usernameLocator, username);
		this.type(this.passwordLocator, password);
		this.click(this.loginButtonLocator);
	}
	
	/**Verification if login button is displayed*/
	public boolean isLoginButtonVisible() {
		this.waitForVisibility(this.loginButtonLocator, 5);
		return this.find(this.loginButtonLocator).isDisplayed();
	}
	
	/**Get page url*/
	public String getPageUrl() {
		return this.pageUrl;
	}

	/** Get error message after invalid login */
	public String getErrMsgForInvalidLogin() {
		waitForErrorMessageForInvalidLogIn();
		return this.find(this.errMsgForInvalidLoginLocator).getText();
	}

	/** Wait for error message after invalid log in */
	private void waitForErrorMessageForInvalidLogIn() {
		this.waitForVisibility(this.errMsgForInvalidLoginLocator, 5);
	}
}
