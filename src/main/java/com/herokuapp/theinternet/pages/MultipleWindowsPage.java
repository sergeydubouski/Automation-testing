
package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class MultipleWindowsPage.
 * 
 * @author SD
 * @version 1.0
 * @since 30.10.2020
 */
public class MultipleWindowsPage extends BasePageObject {
	
	private By clickHereButtonLocator=By.xpath("//*[text()='Click Here']");

	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	/**Switch to a window with a given title and return the title*/
	public String getTitleOfNewWindow(String title) {		
		this.click(this.clickHereButtonLocator);
		this.switchToWindow(title);
		this.log.info("Current window title:\s"+this.driver.getTitle());
		return this.driver.getTitle().toLowerCase();
	}
}
