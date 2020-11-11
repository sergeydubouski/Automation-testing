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
	private By fileUploadElementLocator=By.id("file-upload");
	private By fileUploadButtonLocator=By.id("file-submit");
	private String fileToUploadDirectory="D:\\Books\\eclipse-workspace\\Automation-testing\\src\\main\\resources\\Test\\Test.txt";
	

	public UploadFilePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	/**Open Upload file page*/
	public void openPage() {
	this.open(this.pageUrl);
	}
	
	/**Send the path to file upload web element*/
	private void sendFilePath(By fileUploadElementLocator,String fileToUploadDirectory) {
		this.type(fileUploadElementLocator,fileToUploadDirectory);
	}
	
	/**Click upload button*/
	private void clickUploadButton() {
		this.click(this.fileUploadButtonLocator);
	}
	
	/**Upload a file by sending a path to a file upload web element and clicking upload button*/
	public void uploadFile() {
		this.sendFilePath(this.fileUploadElementLocator,this.fileToUploadDirectory);
		this.clickUploadButton();
	}
}
