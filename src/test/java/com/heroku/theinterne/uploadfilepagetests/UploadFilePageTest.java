package com.heroku.theinterne.uploadfilepagetests;

import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtil;
import com.herokuapp.theinternet.pages.UploadFilePage;

/*
 * UploadFilePageTest.
 * 
 * @author SD
 * @version 1.0
 * @since 10.11.2020
 */
public class UploadFilePageTest extends TestUtil {

	@Test
	public void uploadFileTest() {

		// open upload file page
		UploadFilePage uploadFilePage = new UploadFilePage(driver, log);
		uploadFilePage.openPage();

		// upload file
		uploadFilePage.uploadFile();
		this.sleep(5000);
	}
}
