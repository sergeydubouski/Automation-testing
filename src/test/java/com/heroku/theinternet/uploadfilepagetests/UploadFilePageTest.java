package com.heroku.theinternet.uploadfilepagetests;

import org.testng.Assert;
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
		UploadFilePage uploadFilePage = new UploadFilePage(this.driver, this.log);
		uploadFilePage.openPage();

		// upload file
		uploadFilePage.uploadFile();
		
		//verification
		//verify if upload was successful
		Assert.assertTrue(uploadFilePage.getSuccessMsg().contains("File Uploaded!"), "Success message doesn't contain text [File Uploaded!]. Actual ["+uploadFilePage.getSuccessMsg()+"],"
				+ "], but Expected[File Uploaded!]");

	}
}
