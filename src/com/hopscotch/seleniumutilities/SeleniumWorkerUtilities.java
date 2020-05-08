package com.hopscotch.seleniumutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hopscotch.propertiesreaderutilities.SeleniumDOMReader;

public class SeleniumWorkerUtilities {
	
	static WebElement webElement;
	
	public static WebElement workWithWebElement(WebDriver driver, String element) {
		return elementIdentifier(driver, element);
	}
//	
//	public static WebElement workWithWebElements(WebDriver driver, String elements) {
//		return elementsIdentifier(driver, elements);
//	}
	
	private static WebElement elementIdentifier(WebDriver driver, String element) {
		
		String value[] = element.split(":");
		String identifier = value[0];
		String identifierValue = value[1];
		
		switch(identifier) {
		
			case "Id":
				webElement = SeleniumGeneralUtilitites.findElementById(driver, identifierValue);
				break;
					
			case "LinkText":
				webElement = SeleniumGeneralUtilitites.findElementByLinkText(driver, identifierValue);
				break;
			
			case "CSS":
				webElement = SeleniumGeneralUtilitites.findElementByCss(driver, identifierValue);
				break;
			
			case "XPath":
				webElement = SeleniumGeneralUtilitites.findElementByXpath(driver, identifierValue);
				break;
			
			case "Name":
				webElement = SeleniumGeneralUtilitites.findElementByName(driver, identifierValue);
				break;
			
			case "ClassName":
				webElement = SeleniumGeneralUtilitites.findElementByClassName(driver, identifierValue);
				break;
			}
		
		return webElement;
		}
}
