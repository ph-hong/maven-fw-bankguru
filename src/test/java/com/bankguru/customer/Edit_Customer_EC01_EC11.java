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

public class Edit_Customer_EC01_EC11 extends BaseTest {
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
	public void EC01_Address_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("addr");
		editCustomerPage.inputToTextboxByName("addr", "");
		editCustomerPage.tabToTextBoxByName("city");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("addr"), "Address Field must not be blank");
	}

	@Test
	public void EC02_City_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("city");
		editCustomerPage.inputToTextboxByName("city", "");
		editCustomerPage.tabToTextBoxByName("state");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("city"), "City Field must not be blank");
	}

	@Test
	public void EC03_City_cannot_numeric() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("city");

		editCustomerPage.inputToTextboxByName("city", "123");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("city"), "Numbers are not allowed");

		editCustomerPage.inputToTextboxByName("city", "city 123");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("city"), "Numbers are not allowed");
	}

	@Test
	public void EC04_City_cannot_have_special_characters() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("city");

		editCustomerPage.inputToTextboxByName("city", "!@#");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("city"), "Special characters are not allowed");

		editCustomerPage.inputToTextboxByName("city", "city !@#");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("city"), "Special characters are not allowed");
	}

	@Test
	public void EC05_State_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("state");
		editCustomerPage.inputToTextboxByName("state", "");
		editCustomerPage.tabToTextBoxByName("state");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("state"), "State must not be blank");
	}

	@Test
	public void EC06_State_cannot_numeric() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("state");

		editCustomerPage.inputToTextboxByName("state", "123");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("state"), "Numbers are not allowed");

		editCustomerPage.inputToTextboxByName("state", "state 123");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("state"), "Numbers are not allowed");
	}

	@Test
	public void EC07_State_cannot_have_special_characters() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();

		editCustomerPage.inputToTextboxByName("state", "!@#");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("state"), "Special characters are not allowed");

		editCustomerPage.inputToTextboxByName("state", "state !@#");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("state"), "Special characters are not allowed");
	}

	@Test
	public void EC08_PIN_cannot_be_blank() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("pinno");
		editCustomerPage.inputToTextboxByName("pinno", "");
		editCustomerPage.tabToTextBoxByName("telephoneno");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("pinno"), "PIN Code must not be blank");
	}

	@Test
	public void EC09_PIN_must_be_numeric() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("pinno");
		editCustomerPage.inputToTextboxByName("pinno", "tpin");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");

		editCustomerPage.inputToTextboxByName("pinno", "1234pin");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("pinno"), "Characters are not allowed");
	}

	@Test
	public void EC10_PIN_Code_must_have_6_Digits() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("pinno");
		editCustomerPage.inputToTextboxByName("pinno", "1233");
		editCustomerPage.tabToTextBoxByName("telephoneno");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("pinno"), "PIN Code must have 6 Digits");
	}

	@Test
	public void EC11_PIN_cannot_have_special_characters() {
		editCustomerPage = homePage.clickEditCustomer();
		editCustomerPage.inputToTextboxByName("cusid", Common_New_Customer.customerID);
		editCustomerPage.clickSubmitBtn();
		editCustomerPage.clickToTextboxByName("pinno");
		editCustomerPage.inputToTextboxByName("pinno", "123!@#");
		editCustomerPage.tabToTextBoxByName("telephoneno");
		Assert.assertEquals(editCustomerPage.getValidateMsgByName("pinno"), "Special characters are not allowed");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
