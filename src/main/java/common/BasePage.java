package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	/*
	 * Web Browser
	 */

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String castRestParameter(String locator, String... dynamicLocator) {
		System.out.println("Locator before adding value: " + locator);
		locator = String.format(locator, (Object[]) dynamicLocator);
		System.out.println("Locator after adding value: " + locator);
		return locator;
	}

	/*
	 * Web Element
	 */

	private By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("ID=")) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("CSS=")) {
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("XPATH=")) {
			by = By.xpath(locator.substring(6));
		} else {
			throw new RuntimeException("Locator is invalid.");
		}
		return by;
	}

	private WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}

	public void sendKeyToElement(WebDriver driver, String locator, String valueToInput) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(valueToInput);
	}

	public void sendKeyToElement(WebDriver driver, String locator, String valueToInput, String... dynamicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dynamicLocator));
		element.clear();
		element.sendKeys(valueToInput);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPaeTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText().trim();
	}

	public String getElementText(WebDriver driver, String locator, String... dynamicLocator) {
		return getWebElement(driver, castRestParameter(locator, dynamicLocator)).getText().trim();
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... dynamicLocator) {
		getWebElement(driver, castRestParameter(locator, dynamicLocator)).click();
	}

	public boolean isElementDisplayedInDOM(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}

	/*
	 * User Action
	 */

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... dynamicLocator) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(locator, dynamicLocator)), key).perform();
	}

	/*
	 * Wait
	 */

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... dynamicLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, longTimeout)
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... dynamicLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	private long longTimeout = 20;

}
