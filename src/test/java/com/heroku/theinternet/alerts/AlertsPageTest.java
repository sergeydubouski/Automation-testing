package com.heroku.theinternet.alerts;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.WelcomePage;

@Test
public class AlertsPageTest extends TestUtil {
	
	public void testAlerts() {
		//open welcome page
		new WelcomePage(this.driver, this.log).openWelcomePage();
		

		// get text of JS alert
		alertsPage.clickOkForJsAlertButton();
		//get text of result field for JS confirm
		alertsPage.clickCancelForJsConfirm();
		// type text to JS promrt
		alertsPage.typeToJsPrompt();
	}
	
	
}
