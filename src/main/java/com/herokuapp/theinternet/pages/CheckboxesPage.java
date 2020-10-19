package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * class CheckboxesPage.
 * 
 * @author SD
 * @version 1.0
 * @since 18.10.2020
 */
public class CheckboxesPage extends BasePageObject {

	private By checkboxLocator = By.xpath("//input[@type='checkbox']");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Select all checkboxes */
	public void selectAllCheckboxes() {
		this.log.info("Selecting all checkboxes.");
		List<WebElement> checkboxes = this.findAll(this.checkboxLocator);
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	/** Unselect all checkboxes */
	public void unSelectAllCheckboxes() {
		this.log.info("Unselecting all checkboxes.");
		List<WebElement> checkboxes = this.findAll(this.checkboxLocator);
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}

	public boolean areAllCheckboxesSelected() {
		List<WebElement> checkboxes = this.findAll(this.checkboxLocator);
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}
}
