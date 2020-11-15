package com.heroku.theinternet.windowspagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;

/**
 * class MultipleWindowsPageTest.
 * @author SD
 * @version 1.0
 * @since 3.11.2020
 */
public class MultipleWindowsPageTest extends TestUtil {

	@Test
	@Parameters({ "title" })
	public void multipleWindowsPageTest(String title) {

		// open welcome page
		WelcomePage we = new WelcomePage(this.driver, this.log);
		we.openWelcomePage();

		// open Multiple windows page
		MultipleWindowsPage wp = we.clickMultipleWindowsLink();
		
		//switch to a window by a title
		String currentTitle=wp.getTitleOfNewWindow(title);
		
		//Verification
		//switch to a window by its title and verify the title
		
		  Assert.assertTrue(currentTitle.contains(title.toLowerCase()),
		  "Title of the page doesn't match the expected title. Expected:\s"+title+
		  ", but actual:\s"+currentTitle);
		 
				
		
		//

	}
}
