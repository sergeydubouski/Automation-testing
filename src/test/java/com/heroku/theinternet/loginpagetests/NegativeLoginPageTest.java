package com.heroku.theinternet.loginpagetests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.CsvDataProvider;
import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;

/*
 * Test.
 * 
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class NegativeLoginPageTest extends TestUtil {

	@Test(priority = 1, dataProvider = "csvDataReader", dataProviderClass = CsvDataProvider.class)
	void negativeLogInTest(Map<String,String>testData) {
		
		String no=testData.get("no");
		String description=testData.get("description");
		String username=testData.get("username");
		String password=testData.get("password");
		String expectedErrMsgForInvalidLogin=testData.get("expectedErrMsg");
		
		
		this.log.info("Starting negative login page test ["+no+"]["+description+"]");

		// Open welcome page
		WelcomePage welcomePage = new WelcomePage(this.driver, this.log);
		welcomePage.openWelcomePage();
		this.takeScreenshot("WelcomePage opened");

		// Click form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		this.takeScreenshot("LoginPage opened");

		// Execute log in with incorrect credentials
		loginPage.negativeLogin(username, password);
		this.takeScreenshot("LoginPage with invalid login message");

		// Verification

		// Login button is visible
		Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button is not visible");
		// Same page url is expected
		Assert.assertEquals(loginPage.getCurrentUrl(), loginPage.getPageUrl(),
				"Incorrect url. Expected:\s" + loginPage.getPageUrl() + ",but actual:\s " + loginPage.getCurrentUrl());
		// Error message is expected
		String actualErrMsg = loginPage.getErrMsgForInvalidLogin();
		Assert.assertTrue(actualErrMsg.contains(expectedErrMsgForInvalidLogin),
				"Error message is incorrect. Expected:\s " + expectedErrMsgForInvalidLogin + ", but actual:\s"
						+ actualErrMsg);
	}
}
