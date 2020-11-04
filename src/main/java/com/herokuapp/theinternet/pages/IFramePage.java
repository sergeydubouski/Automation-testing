package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * class IFramePage.
 * 
 * @author SD
 * @version 1.0
 * @since 3.11.2020
 */
public class IFramePage extends BasePageObject {

	String frameId = "mce_0_ifr";
	private By frameTextBox = By.xpath("//body[@id='tinymce']");

	public IFramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** get iframe editor default content */
	public String getIframeContent() {
		this.log.info("Switched to iframe.");
		this.switchToIFrame(frameId);
		return this.find(this.frameTextBox).getText();//getAttribute("innerHTML");
		
	}
}
