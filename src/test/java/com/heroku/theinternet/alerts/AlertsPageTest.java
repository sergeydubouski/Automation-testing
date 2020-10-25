package com.heroku.theinternet.alerts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.AlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
/*
 * Test.
 * 
 * @author SD
 * @version 1.0
 * @since 25.10.2020
 */

public class AlertsPageTest extends TestUtil {

	@Test
	@Parameters({ "message" })
	public void testAlerts(String message) {

		// open welcome page
		WelcomePage we = new WelcomePage(this.driver, this.log);
		we.openWelcomePage();
		// click JS Prompt alerts
		AlertsPage alertsPage = we.clickAlertsLink();
		// type text to JS Prompt Alert
		alertsPage.typeToJsPromptAlert(message);
		alertsPage.acceptAlert();

		// Verification
		// Verify is Result text field displays a text sent to JavaScript Promt Alert
		Assert.assertTrue(alertsPage.getTextFromResultField().contains(message),
				"JavaSscript Prompt alert message doesnot match to the Result text!");
	}

}
