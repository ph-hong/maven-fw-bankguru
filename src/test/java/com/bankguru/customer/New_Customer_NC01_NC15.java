package com.bankguru.customer;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class New_Customer_NC01_NC15 extends BaseTest {
	WebDriver driver;
	NewCustomerPageObject newCustomerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String userID, password, loginPageUrl;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPageUrl = loginPage.getLoginPageUrl();

		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailID("test" + randomNumber() + "@live.com");
		registerPage.clickSubmitButton();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();

		loginPage = registerPage.openLoginPage(loginPageUrl);
//		userID = "mngr495936";
//		password = "ajYhanE";
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);

		homePage = loginPage.clickSubmitButton();
	}

	/*
	 * Verify Customer Name field
	 */

	@Test
	public void NC01_Name_Cannot_Be_Blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("name");
		
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "Customer name must not be blank");
	}

	@Test
	public void NC02_Name_cannot_be_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("name", "123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "Numbers are not allowed");

		newCustomerPage.inputToTextboxByName("name", "name 123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "Numbers are not allowed");
	}

	@Test
	public void NC03_Name_cannot_have_special_characters() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("name", "!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "Special characters are not allowed");

		newCustomerPage.inputToTextboxByName("name", "name!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "Special characters are not allowed");
	}

	@Test
	public void NC04_First_character_of_Name_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("name", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("name"), "First character can not have space");
	}

	/*
	 * Verify Date of Birth field
	 */

	@Test
	public void NC05_Date_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("dob");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("dob"), "Date Field must not be blank");
	}

	/*
	 * Verify Address field
	 */

	@Test
	public void NC06_Address_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("addr");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("addr"), "Address Field must not be blank");
	}

	@Test
	public void NC07_First_character_of_Address_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("addr", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("addr"), "First character can not have space");
	}

	/*
	 * Verify City field
	 */

	@Test
	public void NC08_City_cannot_be_blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("city");
		
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "City Field must not be blank");
	}

	@Test
	public void NC09_City_cannot_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("city", "123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "Numbers are not allowed");

		newCustomerPage.inputToTextboxByName("city", "city 123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "Numbers are not allowed");
	}

	@Test
	public void NC10_City_cannot_have_special_characters() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("city", "!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "Special characters are not allowed");

		newCustomerPage.inputToTextboxByName("city", "name!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "Special characters are not allowed");
	}

	@Test
	public void NC11_First_character_of_City_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("city", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("city"), "First character can not have space");
	}

	/*
	 * Verify State field
	 */

	@Test
	public void NC12_State_Cannot_Be_Blank() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.tabToTextBoxByName("state");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "State must not be blank");
	}

	@Test
	public void NC13_State_cannot_be_numeric() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("state", "123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "Numbers are not allowed");

		newCustomerPage.inputToTextboxByName("state", "name 123");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "Numbers are not allowed");
	}

	@Test
	public void NC14_State_cannot_have_special_characters() {
		newCustomerPage = homePage.clickNewCustomer();

		newCustomerPage.inputToTextboxByName("state", "!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "Special characters are not allowed");

		newCustomerPage.inputToTextboxByName("state", "name!@#");
		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "Special characters are not allowed");
	}

	@Test
	public void NC15_First_character_of_State_can_not_have_space() {
		newCustomerPage = homePage.clickNewCustomer();
		newCustomerPage.inputToTextboxByName("state", " ");

		Assert.assertEquals(newCustomerPage.getValidateMsgByName("state"), "First character can not have space");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	public void sleepInsecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
