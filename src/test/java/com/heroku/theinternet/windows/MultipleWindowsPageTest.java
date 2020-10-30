package com.heroku.theinternet.windows;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;

public class MultipleWindowsPageTest extends TestUtil {
	
	
	@Test
	public void multipleWindowsPageTest() {

	//open welcome page
	WelcomePage we=new WelcomePage(this.driver, this.log);
	we.openWelcomePage();
	
	//open Multiple windows page
	MultipleWindowsPage wp=we.clickMultipleWindowsLink();
	
	//get page title
	System.out.println(wp.getTitleOfNewPage());
}
}
