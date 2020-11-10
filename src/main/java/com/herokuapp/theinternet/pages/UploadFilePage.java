package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * class UploadFilePage.
 * 
 * @author SD
 * @version 1.0
 * @since 10.11.2020
 */
public class UploadFilePage extends BasePageObject {
	
	private String pageUrl="http://the-internet.herokuapp.com/upload";
	private By fileUploadElementLocator=By.xpath("file-upload");
	private By fileSubmitButtonLocator=By.xpath("file-submit");
	

	public UploadFilePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Open Upload file page*/
	public void openPage() {
	this.open(this.pageUrl);
	}
	
	

}
