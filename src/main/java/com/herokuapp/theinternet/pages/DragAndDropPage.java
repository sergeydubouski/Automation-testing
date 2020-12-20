package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * class DragAndDropPage.
 * 
 * @author SD
 * @version 1.0
 * @since 13.11.2020
 */
public class DragAndDropPage extends BasePageObject {

	// page URL
	String url = "http://the-internet.herokuapp.com/drag_and_drop";
	// locate box A
	private By aColumnLocator = By.id("column-a");
	// locate box B
	private By bColumnLocator = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** open the page */
	public void openDragAndDropPage() {
		this.log.info("Opening page " + this.url);
		this.open(url);
	}

	/** drag 'from' element to 'to' element using class Actions */
	private void dragWebElementsUsingActions(By from, By to) {
		Actions action = new Actions(this.driver);
		action.dragAndDrop(this.find(from), this.find(to)).build().perform();
	}

	/** drag 'from' element to 'to' element using class JavascriptExecutor */
	private void dragFromAToBusingJavascriptExecutor(By from, By to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", this.find(from), this.find(to));

	}

	/** drag from box A to box B using class Actions */
	public void dragFromAToB() {
		this.log.info("Dragging from A to B");
		this.dragFromAToBusingJavascriptExecutor(aColumnLocator, bColumnLocator);
	}

	/** get text of column-a */
	public String getTextOfAcolumn() {
		return this.getText(this.aColumnLocator);
	}

	/** get text of column-b */
	public String getTextOfBcolumn() {
		return this.getText(this.bColumnLocator);
	}
}
