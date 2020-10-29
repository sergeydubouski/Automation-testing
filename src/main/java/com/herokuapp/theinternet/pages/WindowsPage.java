package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePageObject {
	
	private By clickHereButtonLocator=By.xpath("//*[text()='Click Here']");

	public WindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	public String getTitleOfNewPage() {
		
		this.click(this.clickHereButtonLocator);
		
		return title;
	}
}
