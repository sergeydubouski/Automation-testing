package com.herokuapp.theinternet.base;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

/**
 * class CsvDataProvider.
 * 
 * @author SD
 * @version 1.0
 * @since 18.11.2020
 */

public class CsvDataProvider {

	/** read parameters from csv file to parametrize a test */
	@DataProvider(name = "dataprovider")
	public static Iterator<Object[]> csvDataProvider(Method m) {

		String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "dataproviders"
				+ File.separator + m.getDeclaringClass().getSimpleName() + File.separator + m.getName();
		return null;

	}
}
