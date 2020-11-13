package com.heroku.theinternet.draganddroppagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.DragAndDropPage;

/*
 * DragAndDropPageTest.
 * 
 * @author SD
 * @version 1.0
 * @since 13.11.2020
 */
public class DragAndDropPageTest extends TestUtil {

	@Test
	public void dragAndDropPageTest() {

		// log start
		this.log.info("Starting dragAndDropPageTest.");
		// open drag_and_drop page
		DragAndDropPage dragAndDropPage = new DragAndDropPage(this.driver, this.log);
		dragAndDropPage.openDragAndDropPage();
		// drag box A to box B
		dragAndDropPage.dragFromAToB();

		// verification
		// verify if header of column-a is B
		Assert.assertTrue(dragAndDropPage.getTextOfAcolumn().contains("B"),
				"Test failed. Expected[B], but Actual[" + dragAndDropPage.getTextOfAcolumn() + "]");
		// verify if header of column-b is A
		Assert.assertTrue(dragAndDropPage.getTextOfBcolumn().contains("A"),
				"Test failed. Expected[A], but Actual[" + dragAndDropPage.getTextOfAcolumn() + "]");
	}
}
