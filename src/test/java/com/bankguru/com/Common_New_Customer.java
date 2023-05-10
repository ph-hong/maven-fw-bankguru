package com.bankguru.com;

import bankguru.CustomerData;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Common_New_Customer extends BaseTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	CustomerData customerData;
	String registerEmail, registerPassword, loginPageUrl;
	public static String userID, password, customerID;

	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		customerData = CustomerData.getCustomerData();

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();

		registerEmail = customerData.getEmail() + getRandomNumber() + "@hotmail.com";
		registerPassword = customerData.getPassword();
		userID = customerData.getLoginUserID();
		password = customerData.getLoginPassword();
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);

		homePage = loginPage.clickSubmitButton();
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("name", customerData.getCustomerName());
		newCustomerPage.inputToTextboxByName("dob", customerData.getDateOfBirth());
		newCustomerPage.inputToTextboxByName("addr", customerData.getAddress());
		newCustomerPage.inputToTextboxByName("city", customerData.getCity());
		newCustomerPage.inputToTextboxByName("state", customerData.getState());
		newCustomerPage.inputToTextboxByName("pinno", customerData.getPinNumber());
		newCustomerPage.inputToTextboxByName("telephoneno", customerData.getTelephoneNumber());
		newCustomerPage.inputToTextboxByName("emailid", registerEmail);
		newCustomerPage.inputToTextboxByName("password", registerPassword);
		newCustomerPage.clickSubmitButton();
		Assert.assertEquals(newCustomerPage.getRegisterMsg(), "Customer Registered Successfully!!!");

		customerID = newCustomerPage.getCustomerID();
		System.out.println("==================== Customer ID: " + customerID);

		closeBrowserDriver();
	}
}
