package com.heroku.theinternet.keypressespagetests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesPageTest extends TestUtil {

	@Test
	public void keyPressesTest() {
		
		//open welcome page
		WelcomePage welcomePage=new WelcomePage(this.driver, this.log);
		welcomePage.openWelcomePage();
		
		//open Key Presses page
		KeyPressesPage keyPressesPage=welcomePage.clickKeyPressesLink();
		
		//press Shift key on the Key Presses page
		keyPressesPage.pressKey(Keys.SPACE);
		
		this.sleep(5000);
		
		//Verification
		//Verify the result after pressing key
		Assert.assertTrue(keyPressesPage.getTextOfResultField().contains("You entered: SPACE"), "The rusult is not as expected. Expected[You entered: SPACE], "
				+ "but Actual["+keyPressesPage.getTextOfResultField()+"]");
		
	}
}
