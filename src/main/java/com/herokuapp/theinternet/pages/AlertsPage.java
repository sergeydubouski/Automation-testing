package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class AlertsPage
 * 
 * @author SD
 * @verision 1.0
 * @since 20-10-2020
 */
public class AlertsPage extends BasePageObject {

	private By jsAlertButtonLocator = By.linkText("Click for JS Alert");
	private By jsConfirmButtonLocator = By.linkText("Click for JS Confirm");
	private By jsPromptButtonLocator = By.linkText("Click for JS Prompt");
	private By resultLocator = By.id("result");

	public AlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** accept JS Alert */
	public void acceptJsAlert() {
		this.log.info("Open JS Alert.");
		this.click(this.jsAlertButtonLocator);
		this.acceptAlert();
	}

	/** get text from JS Alert */
	public String getTextFromJsAlert() {
		this.click(this.jsAlertButtonLocator);
		return this.getTextFromAlert();
	}

	/** accept JS Confirm alert */
	public void acceptJsConfirmAlert() {
		this.log.info("Open JS Confirm.");
		this.click(this.jsConfirmButtonLocator);
		this.acceptAlert();
	}

	/** dismiss JS Confirm alert */
	public void dismissJsConfirmAlert() {
		this.click(this.jsConfirmButtonLocator);
		this.dismissAlert();
	}

	/** type text to JS Prompt alert */
	public void typeToJsPrompt(String text) {
		this.log.info("Open JS Prompt.");
		this.click(this.jsPromptButtonLocator);
		this.typeTextToAlert(text);
	}

	/** get result text */
	public String getResult() {
		return this.getText(this.resultLocator);
	}

}
