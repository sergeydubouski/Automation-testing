package com.heroku.theinternet.iframetests;

import org.testng.annotations.Test;

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
	public void iFramesPageTest() {

		// open welcome page
		WelcomePage we = new WelcomePage(this.driver, this.log);
		we.openWelcomePage();

		// click iframes link
		IFramePage ifp = we.clickWYSIWYGLink();

		// get default content in the iframe
		System.out.println(ifp.getIframeContent());
	}

}
