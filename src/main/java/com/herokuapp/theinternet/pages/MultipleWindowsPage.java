package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.herokuapp.theinternet.base.TestUtil;


/**
 * class MultipleWindowsPage
 * 
 * @author SD
 * @verision 1.0
 * @since 26.10.2020
 */
public class MultipleWindowsPage extends BasePageObject {
	
	private By clickHereLinkLocator=By.xpath("//*[text()='Click Here']");

	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Open a second window by clicking Click Here link*/
	public void openSecondWindow() {
		this.click(this.clickHereLinkLocator);
	}
	
	

}
