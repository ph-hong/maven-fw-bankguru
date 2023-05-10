package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWelcomMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MSG_TEXT);
		return isElementDisplayedInDOM(driver, HomePageUI.WELCOME_MSG_TEXT);
	}

	public NewCustomerPageObject clickNewCustomer() {
		waitForElementClickable(driver, HomePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.NEW_CUSTOMER_LINK);
		return PageGeneratorManager.getNewCustomerPage(driver);
	}

//	public RegisterPageObject clickHereLink() {
//		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
//		clickToElement(driver, LoginPageUI.HERE_LINK);
//		return PageGeneratorManager.getRegisterPage(driver);
//	}

	public EditCustomerPageObject clickEditCustomer() {
		waitForElementClickable(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, HomePageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratorManager.getEditCustomerPage(driver);
	}
}
