package com.herokuapp.theinternet.base;

/**
 * class TestUtil.
 * @author SD
 * @version 1.0
 * @since 17.10.2020
 */
public class TestUtil extends BaseTest {
	
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
