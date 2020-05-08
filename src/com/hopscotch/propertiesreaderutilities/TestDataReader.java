package com.hopscotch.propertiesreaderutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
	
	private static Properties prop;
	private final static String propertyPath ="/Users/manpreet/eclipse-workspaceMan/HopscotchSanityAutomation/TestData.properties";
	
	public static String webSiteUrl() throws IOException {
		String webSiteUrl = "webSiteUrl";
		return readProperty(webSiteUrl);
	}
	
	public static String pdpUrl() throws IOException {
		String pdpUrl = "pdpUrl";
		return readProperty(pdpUrl);
	}
	
	public static String validUserName() throws IOException {
		String validUserName = "validUsername";
		return readProperty(validUserName);
	}
	
	public static String invalidUserName() throws IOException {
		String invalidUserName = "invalidUsername";
		return readProperty(invalidUserName);
	}
	
	public static String validPassword() throws IOException {
		String validPassword = "validPassword";
		return readProperty(validPassword);
	}
	
	public static String invalidPassword() throws IOException {
		String invalidPassword = "invalidPassword";
		return readProperty(invalidPassword);
	}

	public static String validMobile() throws IOException {
		String validMobile = "validMobile";
		return readProperty(validMobile);
	}
	
	public static String invalidMobile() throws IOException {
		String invalidMobile = "invalidMobile";
		return readProperty(invalidMobile);
	}
	
	public static String validMobPassword() throws IOException {
		String validMobPassword = "validMobPassword";
		return readProperty(validMobPassword);
	}
	
	public static String mobile() throws IOException {
		String mobile = "mobile";
		return readProperty(mobile);
	}
	
	public static int expectedQtyToBeAdded() throws IOException {
		String expectedQtyToBeAdded = "expectedQtyToBeAdded";
		return Integer.parseInt(readProperty(expectedQtyToBeAdded));
	}
	
	public static int qtyToBeIncreasedTo() throws IOException {
		String qtyToBeIncreasedTo = "qtyToBeIncreasedTo";
		return Integer.parseInt(readProperty(qtyToBeIncreasedTo));
	}
	
	public static String name() throws IOException {
		String name = "name";
		return readProperty(name);
	}
	
	public static String zipCode() throws IOException {
		String zipCode = "zipCode";
		return readProperty(zipCode);
	}
	
	public static String address() throws IOException {
		String address = "address";
		return readProperty(address);
	}
	
	public static String product() throws IOException {
		String product = "product";
		return readProperty(product);
	}
	
	public static String readProperty(String propertyName) throws IOException {

		FileInputStream fileInput = new FileInputStream(propertyPath);
		prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty(propertyName);
	}
}
