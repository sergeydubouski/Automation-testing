package com.heroku.theinternet.checkboxpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestListener;
import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

/**
 * class CheckboxesPageTest.
 * @author SD
 * @version 1.0
 * @since 18.10.2020
 */
public class CheckboxesPageTest extends TestListener {

	@Test
	public void selectingTwoCheckboxesTest() {
	
	//open welcome page
	WelcomePage welcomePage=new WelcomePage(this.driver,this. log);
	welcomePage.openWelcomePage();
	//click checkboxes link
	CheckboxesPage checkboxesPage=welcomePage.clickCheckboxesLink();
	//check all checkboxes
	checkboxesPage.selectAllCheckboxes();
	//verify if all checkboxes are selected
	Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Not all checkboxes are selected.");
	//uncheck all checkboxes
	checkboxesPage.unSelectAllCheckboxes();
	//verify if all checkboxes are unchecked
	Assert.assertFalse(checkboxesPage.areAllCheckboxesSelected(), "Some checkboxes are selected");
}
}
