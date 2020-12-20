package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * class KeyPressesPage.
 * 
 * @author SD
 * @version 1.0
 * @since 9.11.2020
 */
public class KeyPressesPage extends BasePageObject {
	
	private By result=By.id("result");
	

	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**press key using keyboard*/
	public void pressKey(Keys keys) {
		this.log.info("Pressing a key "+keys.name());
		Actions action=new Actions(this.driver);
		action.sendKeys(keys).build().perform();
	}
	
	/**get text of the result field*/
	public String getTextOfResultField() {
		this.log.info("Getting text of the result field.");
		return this.getText(this.result);
	}

	
}
