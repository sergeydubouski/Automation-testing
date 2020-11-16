package com.heroku.theinternet.hoverspagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.HoversPage;

/*
 *HoversPageTest.
 * 
 * @author SD
 * @version 1.0
 * @since 15.11.2020
 */
public class HoversPageTest extends TestUtil {

	@Test
	@Parameters({ "avatar" })
	public void hoversPageTest(int avatar) {

		// open hovers page
		HoversPage hoversPage = new HoversPage(this.driver, this.log);
		hoversPage.openPage();
		// hover over third avatar
		String avatarText=hoversPage.getTextOfAvatar(avatar);
		// verification
		// verify if third avatar has text "user3"
		Assert.assertTrue(avatarText.contains("user"+avatar), "Avatar ["+avatar+"] contains ["+avatarText+"]");
	}
}
