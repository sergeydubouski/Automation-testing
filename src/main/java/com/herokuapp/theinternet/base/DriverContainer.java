package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;

public class DriverContainer {

	static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
}
