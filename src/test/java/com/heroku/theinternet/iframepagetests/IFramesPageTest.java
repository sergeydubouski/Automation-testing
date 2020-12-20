package com.heroku.theinternet.iframepagetests;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.IFramePage;
import com.herokuapp.theinternet.pages.WelcomePage;

/**
 * class IFramesPageTest.
 * 
 * @author SD
 * @version 1.0
 * @since 4.11.2020
 */
public class IFramesPageTest extends TestUtil {

	@Test
	public void defaultEditorValueTest() {

		this.log.info("Starting defaultEditorValueTest.");

		// open welcome page
		WelcomePage we = new WelcomePage(this.driver, this.log);
		we.openWelcomePage();

		// click iframes link
		IFramePage editorPage = we.clickWYSIWYGLink();

		// Verification
		// get default content in the iframe editor window
		String editorContent = editorPage.getEditorContent();

		// verify that a new page contains expected content in the editor window
		Assert.assertTrue(editorContent.equals("Your content goes here."),
				"Editor content is not expected. It's: " + editorContent);

	}

}
