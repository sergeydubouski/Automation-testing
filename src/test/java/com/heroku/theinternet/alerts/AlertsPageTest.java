package com.heroku.theinternet.alerts;

import org.testng.annotations.Test;

@Test
public class AlertsPageTest {

	// get text of JS alert
	alertsPage.clickOkForJsAlertButton();
	//get text of result field for JS confirm
	alertsPage.clickCancelForJsConfirm();
	// type text to JS promrt
	alertsPage.typeToJsPrompt();
}
