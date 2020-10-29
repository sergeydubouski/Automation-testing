package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class AlertsPage
 * 
 * @author SD
 * @verision 1.0
 * @since 20.10.2020
 */
public class AlertsPage extends BasePageObject {

	private By jsAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	private By jsConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
	private By jsPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
	private By resultFieldLocator = By.id("result");

	public AlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}	
	/**cancel JS Confirm Alert*/
	public void cancelJsConfirmAlert() {
		this.click(jsConfirmButtonLocator);
		this.waitForAlertToBePresent(this.driver, 5);
		Alert alert=this.driver.switchTo().alert();
		this.log.info("Opened JavaScript Confirmed alert.");
		this.dismissAlert();
	}
	/**Type text to JS Prompt Alert*/
	public void typeToJsPromptAlert(String text) {
		this.click(jsPromptButtonLocator);
		this.waitForAlertToBePresent(this.driver, 5);
		Alert alert=this.driver.switchTo().alert();
		this.log.info("Opened JavaScript Prompt alert.");
		alert.sendKeys(text);
	}
	/**get text from Result field*/
	public String getTextFromResultField() {
		this.waitForVisibility(resultFieldLocator, 5);
		this.log.info("Looking for outer text in the Result element.");
		return this.find(resultFieldLocator).getAttribute("innerText");
	}
	
}
