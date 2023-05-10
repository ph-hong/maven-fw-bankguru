package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public RegisterPageObject clickHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputUserID(String userID) {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public String getUserIDText() {
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		return getElementText(driver, LoginPageUI.USER_ID_TEXTBOX);
	}
	
	public String getPasswordText() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		return getElementText(driver, LoginPageUI.PASSWORD_TEXTBOX);
	}

	public void clickResetButton() {
		waitForElementClickable(driver, LoginPageUI.RESET_BTN);
		clickToElement(driver, LoginPageUI.RESET_BTN);
	}

	public HomePageObject clickSubmitButton() {
		waitForElementClickable(driver, LoginPageUI.SUBMIT_BTN);
		clickToElement(driver, LoginPageUI.SUBMIT_BTN);
		return PageGeneratorManager.getHomePage(driver);
	}
}
