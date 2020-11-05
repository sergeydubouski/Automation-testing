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

	String iFrameId = "mce_0_ifr";
	private By iFrameEditorWindow = By.xpath("//body[@id='tinymce']");

	public IFramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** get iframe editor default content */
	public String getEditorContent() {
		this.log.info("Switched to iframe.");
		this.switchToIFrame(iFrameId);
		String editorText=this.find(this.iFrameEditorWindow).getText();
		this.log.info("The editor window text:\s"+editorText);
		return editorText;
		
	}
}
