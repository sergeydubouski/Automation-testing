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
	private By jsPromptButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	private By resultLocator = By.id("result");

	public AlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/** accept alert */
	protected void acceptAlert() {
		this.driver.switchTo().alert().accept();

	}

	/** dismiss alert */
	protected void dismissAlert() {
		this.driver.switchTo().alert().dismiss();

	}
	
	/**get text from alert*/
	String getTextFromAlert() {
		return this.driver.switchTo().alert().getText();
	}

	/** send keys to alert */
	protected void typeTextToAlert(String text) {
		this.driver.switchTo().alert().sendKeys(text);
	}
	
}
