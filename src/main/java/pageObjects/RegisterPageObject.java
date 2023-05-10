package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailID(String userID) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, userID);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BTN);
		clickToElement(driver, RegisterPageUI.SUBMIT_BTN);
	}

	public String getUserIDText() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrll) {
		openPageUrl(driver, loginPageUrll);
		return new LoginPageObject(driver);
	}
}
