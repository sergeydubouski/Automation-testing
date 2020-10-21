package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class BasePageObject.
 * 
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}

	/** open a web page */
	void open(String url) {
		this.driver.get(url);
	}

	/** find a web element using By locator */
	WebElement find(By by) {
		return this.driver.findElement(by);
	}

	/** find all web elements using By locator */
	List<WebElement> findAll(By by) {
		return this.driver.findElements(by);
	}

	/** click on a web element */
	void click(By by) {
		this.waitForVisibility(by, 5);
		this.find(by).click();
	}
	
	/**get text of a web element*/
	String getText(By locator) {
		return this.find(locator).getText();
	} 

	/** send keys to a web element */
	void type(By by, String keysToSend) {
		this.waitForVisibility(by, 5);
		this.find(by).sendKeys(keysToSend);
	}

	/** get current ur */
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
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

	/** wait for visibility of a web element */
	public void waitForVisibility(By locator, Integer... timeInSec) {
		int attempt = 0;
		while (attempt < 2) {
			try {
				this.waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						timeInSec != null ? timeInSec[0] : null);
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempt++;
		}
	}

	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeInSec) {
		WebDriverWait wait = new WebDriverWait(driver, (timeInSec != null ? timeInSec : 30));
		wait.until(condition);
	}
}
