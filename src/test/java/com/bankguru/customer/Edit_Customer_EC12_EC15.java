package com.bankguru.customer;

import org.testng.annotations.Test;

import com.bankguru.common.Common_New_Customer;

import bankguru.CustomerData;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class Edit_Customer_EC12_EC15 extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	CustomerData customerData;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.inputUserID(Common_New_Customer.userID);
		loginPage.inputPassword(Common_New_Customer.password);

		homePage = loginPage.clickSubmitButton();
	}

	@Test
	public void EC12_Mobile_Number_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("telephoneno");
		editCustomerPage.inputToTextboxByName("telephoneno", "");
		editCustomerPage.tabToTextBoxByName("emailid");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("telephoneno"), "Mobile no must not be blank");
	}

	@Test
	public void EC13_Mobile_Number_cannot_have_special_characters() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("telephoneno");
		editCustomerPage.inputToTextboxByName("telephoneno", "123!@#");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("telephoneno"), "Special characters are not allowed");
	}

	@Test
	public void NC14_Email_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("emailid");
		editCustomerPage.inputToTextboxByName("emailid", "");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID must not be blank");
	}

	@Test
	public void NC15_Email_must_be_in_correct_format() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("emailid");

		editCustomerPage.inputToTextboxByName("emailid", "guru12@gmail");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		editCustomerPage.inputToTextboxByName("emailid", "guru12");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		editCustomerPage.inputToTextboxByName("emailid", "Guru12@");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		editCustomerPage.inputToTextboxByName("emailid", "guru12@gmail.");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");

		editCustomerPage.inputToTextboxByName("emailid", "guru12gmail.com");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("emailid"), "Email-ID is not valid");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
