package com.bankguru.login;

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
import pageObjects.RegisterPageObject;

public class Customer_Login extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String userID, password, loginPageUrl;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		loginPage = PageGeneratorManager.getLoginPage(driver);

		loginPageUrl = loginPage.getLoginPageUrl();
	}

	@Test
	public void LG_01_Register() {
		registerPage = loginPage.clickHereLink();
		registerPage.inputEmailID("test" + randomNumber() + "@live.com");
		registerPage.clickSubmitButton();

		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();

		loginPage = registerPage.openLoginPage(loginPageUrl);
	}

	@Test
	public void LG_02_Reset_Button() {
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);
		loginPage.clickResetButton();

		Assert.assertEquals(loginPage.getUserIDText(), "");
		Assert.assertEquals(loginPage.getPasswordText(), "");
	}

	@Test
	public void LG_03_Login_Successful() {
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);

		homePage = loginPage.clickSubmitButton();
		Assert.assertTrue(homePage.isWelcomMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}
