package com.heroku.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;

/*
 * Test.
 * 
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class PositiveLoginPageTest extends TestUtil {

	@Test
	@Parameters({ "username", "password","expectedSuccessLoginMsg" })
	public void loginTest(String username, String password, String expectedSuccessLoginMsg) {

		// open welcome page
		WelcomePage welcomePage = new WelcomePage(this.driver, this.log);
		welcomePage.openWelcomePage();

		// click form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// Execute log in
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);

		// Verification
		// New page url is expected
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Logout button is visible
		Assert.assertTrue(secureAreaPage.isVisibleLogOutButton(), "Logout button is not visible!");

		// Success login message is correct
		Assert.assertTrue(secureAreaPage.getSuccessLoginMsg().contains(expectedSuccessLoginMsg),
				"Success login message is incorrect. Expected:\s" + expectedSuccessLoginMsg + ", but actual is\s"
						+ secureAreaPage.getSuccessLoginMsg());
	}
}
