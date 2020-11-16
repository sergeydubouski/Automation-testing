package com.herokuapp.theinternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * class HoversPage.
 * 
 * @author SD
 * @version 1.0
 * @since 15.11.2020
 */
public class HoversPage extends BasePageObject {

	// page url
	String url = "http://the-internet.herokuapp.com/hovers";
	// avatar 3 By locator
	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By avatarTextLocator = By.xpath(".//div[@class='figcaption']/h5");

	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** open a web page by its url */
	public void openPage() {
		this.log.info("Open the web page.");
		this.open(this.url);
		this.log.info("The web page is opened.");
	}

	/** hover overt avatars by its value */
	public WebElement hoverOverAvatar(int avatarIndex) {
		this.log.info("Hovering over avatars.");
		List<WebElement> avatars = this.findAll(this.avatarLocator);
		Actions action = new Actions(this.driver);
		action.moveToElement(avatars.get(avatarIndex)).build().perform();
		this.log.info("Hover over [" + avatarIndex + "] avatar.");
		return avatars.get(avatarIndex);
	}

	/** get text of an avatar */
	public String getTextOfAvatar(int avatarIndex) {
		int avatarArrIndex=avatarIndex-1;
		WebElement avatar = this.hoverOverAvatar(avatarArrIndex);
		this.log.info("Text of avatar [" + avatarIndex + "] is\s"
				+ avatar.findElement(this.avatarTextLocator).getAttribute("textContent") + ".");
		return avatar.findElement(this.avatarTextLocator).getAttribute("textContent");
	}
}
