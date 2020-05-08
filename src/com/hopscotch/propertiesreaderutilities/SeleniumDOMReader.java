package com.hopscotch.propertiesreaderutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.hopscotch.seleniumutilities.SeleniumWorkerUtilities;

public class SeleniumDOMReader {
	
	private static Properties prop;
	private final static String propertyPath ="/Users/manpreet/eclipse-workspaceMan/HopscotchSanityAutomation/SeleniumDOMConfiguration.properties";

		public static String accountIdentifier() throws IOException {
			String account = "accountIdentifier";
			return readProperty(account);
		}
		
		public static String primarySignInCssIdentifier() throws IOException {
			String primarySignInCss = "primarySignInCssIdentifier";
			return readProperty(primarySignInCss);
		}
		
		public static String emailLinkIdentifier() throws IOException {
			String emailLink = "emailLinkIdentifier";
			return readProperty(emailLink);
		}
	
		public static String emailIdentifier() throws IOException {
			String email = "emailIdentifier";
			return readProperty(email);
		}
		
		public static String loginIdIdentifier() throws IOException {
			String loginId = "loginIdIdentifier";
			return readProperty(loginId);
		}
		
		public static String loginPasswordIdentifier() throws IOException {
			String loginPassword = "loginPasswordIdentifier";
			return readProperty(loginPassword);
		}
		
		public static String signInXpathIdentifier() throws IOException {
			String signInXpath = "signInXpathIdentifier";
			return readProperty(signInXpath);
		}
		
		public static String invalidLoginMsgIdentifier() throws IOException {
			String invalidLoginMsg = "invalidLoginMsgIdentifier";
			return readProperty(invalidLoginMsg);
		}
		
		public static String invalidMobPasswordMsgIdentifier() throws IOException {
			String invalidMobPasswordMsg = "invalidMobPasswordMsgIdentifier";
			return readProperty(invalidMobPasswordMsg);
		}
		
		public static String EddIdentifier() throws IOException {
			String Edd = "EddIdentifier";
			return readProperty(Edd);
		}
		
		public static String paymentIdentifier() throws IOException {
			String payment = "paymentIdentifier";
			return readProperty(payment);
		}
		
		public static String profileUpdateMsgIdenitifier() throws IOException {
			String profileMsg = "profileUpdateMsgIdenitifier";
			return readProperty(profileMsg);
		}
		
		public static String searchIdentifier() throws IOException {
			String search = "searchIdentifier";
			return readProperty(search);
		}
		
		public static String selectSizeIdentifier() throws IOException {
			String selectFirstSize = "selectSizeIdentifier";
			return readProperty(selectFirstSize);
		}
		
		public static String selectFirstSizeIdentifier() throws IOException {
			String selectSize = "selectFirstSizeIdentifier";
			return readProperty(selectSize);
		}
		
		public static String addToCartIdentifier() throws IOException {
			String addToCart = "addToCartIdentifier";
			return readProperty(addToCart);
		}
		
		public static String qtyIdentifier() throws IOException {
			String qty = "qtyIdentifier";
			return readProperty(qty);
		}
		
		public static String cartIconIdentifier() throws IOException {
			String cartIcon = "cartIconIdentifier";
			return readProperty(cartIcon);
		}
		
		public static String selectBoxIdentifier() throws IOException {
			String selectBox = "selectBoxIdentifier";
			return readProperty(selectBox);
		}
		
		public static String qtyLabelIdentifier() throws IOException {
			String qtyLabel = "qtyLabelIdentifier";
			return readProperty(qtyLabel);
		}
		
		public static String pincodeContainerIdentifier() throws IOException {
			String pincodeContainer = "pincodeContainerIdentifier";
			return readProperty(pincodeContainer);
		}
		
		public static String pincodeIdentifier() throws IOException {
			String pincode = "pincodeIdentifier";
			return readProperty(pincode);
		}
		
		public static String confirmPincodeIdentifier() throws IOException {
			String confirmPincode = "confirmPincodeIdentifier";
			return readProperty(confirmPincode);
		}
		
		public static String checkOutButtonIdentifier() throws IOException {
			String checkOutButton = "checkOutButtonIdentifier";
			return readProperty(checkOutButton);
		}
		
		public static String mobileTextIdentifier() throws IOException {
			String mobileText = "mobileTextIdentifier";
			return readProperty(mobileText);
		}
		
		public static String continueForMobButtonIdentifier() throws IOException {
			String continueForMobButton = "continueForMobButtonIdentifier";
			return readProperty(continueForMobButton);
		}
		
		public static String cancelLinkIdentifier() throws IOException {
			String cancelLink = "cancelLinkIdentifier";
			return readProperty(cancelLink);
		}
		
		public static String nameTextIdentifier() throws IOException {
			String nameText = "nameTextIdentifier";
			return readProperty(nameText);
		}
		
		public static String pincodeTextIdentifier() throws IOException {
			String pincodeText = "pincodeTextIdentifier";
			return readProperty(pincodeText);
		}
		
		public static String addressTextIdentifier() throws IOException {
			String addressText = "addressTextIdentifier";
			return readProperty(addressText);
		}
		
		public static String continueForAddButtonIdentifier() throws IOException {
			String continueForAddButton = "continueForAddButtonIdentifier";
			return readProperty(continueForAddButton);
		}
		
		public static String profileButtonIdentifier() throws IOException {
			String profileButton = "profileButtonIdentifier";
			return readProperty(profileButton);
		}
		
		public static String profileNameIdentifier() throws IOException {
			String profileName = "profileNameIdentifier";
			return readProperty(profileName);
		}
		
		public static String changeNameIdentifier() throws IOException {
			String changeName = "changeNameIdentifier";
			return readProperty(changeName);
		}
		
		public static String saveButtonIdentifier() throws IOException {
			String saveButton = "saveButtonIdentifier";
			return readProperty(saveButton);
		}
		
		public static String searchProductIdentifier() throws IOException {
			String searchProduct = "searchProductIdentifier";
			return readProperty(searchProduct);
		}
		
		public static String searchTextIdentifier() throws IOException {
			String searchText = "searchTextIdentifier";
			return readProperty(searchText);
		}
		
		public static String readProperty(String propertyName) throws IOException {
			
			FileInputStream fileInput = new FileInputStream(propertyPath);
			prop = new Properties();
			prop.load(fileInput);
			return prop.getProperty(propertyName);
			
		}
}
