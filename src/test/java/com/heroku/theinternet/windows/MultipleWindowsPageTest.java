package com.heroku.theinternet.windows;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;

public class MultipleWindowsPageTest extends TestUtil {
	
	
	@Test
	public void multipleWindowsPageTest() {

	//open welocme page
	WelcomePage we=new WelcomePage(this.driver, this.log);
	we.openWelcomePage();
	
	//open Multiple windows page
	WindowsPage wp=we.clickMultipleWindowsLink();
}
}
