package com.bankguru.customer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bankguru.CustomerData;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class New_Customer_NC16_NC31 extends BaseTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	CustomerData customerData;
	String userID, password, registerEmail, registerPassword, loginPageUrl;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
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
	}

	/*
	 * Verify PIN field
	 */

	@Test
	public void NC16_PIN_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("pinno");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "PIN Code must not be blank");
	}

	@Test
	public void NC17_PIN_must_be_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1234pin");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");
	}

	@Test
	public void NC18_PIN_Code_must_have_6_Digits() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1233");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "PIN Code must have 6 Digits");
	}

	@Test
	public void NC19_PIN_cannot_have_special_character() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("pinno", "1233#$");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Special characters are not allowed");
	}

	@Test
	public void NC20_First_character_of_PIN_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("pinno", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "First character can not have space");
	}

	@Test
	public void NC21_PIN_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("pinno", "1233 3");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");
	}

	/*
	 * Verify Mobile Number field
	 */

	@Test
	public void NC22_Mobile_Number_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("telephoneno");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Mobile no must not be blank");
	}

	@Test
	public void NC23_Mobile_Number_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("telephoneno", "123 33");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Characters are not allowed");
	}

	@Test
	public void NC24_Mobile_Number_cannot_have_special_character() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("telephoneno", "1233#$");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Special characters are not allowed");
	}

	@Test
	public void NC25_First_character_of_Mobile_Number_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("telephoneno", "1233 3");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("telephoneno"), "Characters are not allowed");
	}

	/*
	 * Verify Email field
	 */

	@Test
	public void NC26_Email_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("emailid");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID must not be blank");
	}

	@Test
	public void NC27_Email_must_be_in_correct_format() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("emailid", "guru12@gmail");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "Guru12@");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12@gmail.");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		newCustomerPage.inputToTextboxByName("emailid", "guru12gmail.com");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");
	}

	@Test
	public void NC28_Email_cannot_have_blank_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("emailid", "gruru 12");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");
	}

	/*
	 * Verify Password field
	 */

	@Test
	public void NC29_Password_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("password");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("password"), "Password must not be blank");
	}

	/*
	 * Verify Reset Button
	 */

	@Test
	public void NC30_All_New_Customer_data_are_reset() {
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
		newCustomerPage.clickResetButton();

		Assert.assertEquals(newCustomerPage.getTextByName("name"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("dob"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("addr"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("city"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("state"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("pinno"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("telephoneno"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("emailid"), "");
		Assert.assertEquals(newCustomerPage.getTextByName("password"), "");
	}

	/*
	 * Register New Customer Successfully!
	 */

	@Test
	public void NC31_Add_new_customer_successfully() {
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
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
