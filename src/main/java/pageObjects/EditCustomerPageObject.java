package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByName(String textboxName, String valueToInput) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		sendKeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, valueToInput, textboxName);
	}

	public void clickToTextboxByName(String textboxName) {
		waitForElementClickable(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		clickToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
	}

	public void tabToTextBoxByName(String textboxName) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, textboxName);
		pressKeyToElement(driver, EditCustomerPageUI.DYNAMIC_TEXTBOX_BY_NAME, Keys.TAB, textboxName);
	}

	public String getValidateMsgByName(String textboxName) {
		waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_VALAIDATE_MSG, textboxName);
		return getElementText(driver, EditCustomerPageUI.DYNAMIC_VALAIDATE_MSG, textboxName);
	}

	public EditCustomerPageObject clickSubmitBtn() {
		waitForElementClickable(driver, EditCustomerPageUI.SUBMIT_BTN);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BTN);
		return PageGeneratorManager.getEditCustomerPage(driver);

	}
}
