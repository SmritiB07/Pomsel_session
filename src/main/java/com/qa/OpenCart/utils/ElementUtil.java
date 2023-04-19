package com.qa.OpenCart.utils;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public By getBy(String locatorType, String selector) {
		By locator = null;

		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(selector);
			break;
		case "name":
			locator = By.name(selector);
			break;
		case "class":
			locator = By.className(selector);
			break;
		case "xpath":
			locator = By.xpath(selector);
			break;
		case "cssselector":
			locator = By.cssSelector(selector);
			break;
		case "linktext":
			locator = By.linkText(selector);
			break;
		case "tagname":
			locator = By.tagName(selector);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(selector);
			break;

		default:
			break;
		}
		return locator;

	}

//------------New Method utility-------------

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeysusingstring(String locatorType, String selector, String value) {
		By locator = getBy(locatorType, selector);
		getElement(locator).sendKeys(value);
	}

	public void doClickusingstring(String locatorType, String selector) {
		By locator = getBy(locatorType, selector);
		getElement(locator).click();
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doclick(By locator) {
		getElement(locator).click();
	}

	// --------Actions----------
	public void doActionsSendKeys(By locator, String value) {
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		act.click(getElement(locator)).perform();
	}

	// ---------------GetAttribute----------
	public String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public String doElementGetText(By locator) {
		String eletext = getElement(locator).getText();
		return eletext;
	}

	/// non blank list count:

	public int getElementsTextCount(By locator) {
		return getElementsTextList(locator).size();
	}

	// non blank Text List:
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

	public int getEmptyElementTextList(By locator) {
		int totalLinks = getPageElementsCount(locator);
		int totalNonEmptyLinks = getElementsTextCount(locator);
		return totalLinks - totalNonEmptyLinks;
	}

	// 1. total no of links on the page

	public int getPageElementsCount(By locator) {
		return getElements(locator).size();
	}

	public List<String> getElementAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrValueList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrValue = e.getAttribute(attrName);
			eleAttrValueList.add(attrValue);
		}
		return eleAttrValueList;
	}

	public void performSearch(By search, String searchKey, By suggListLocator, String suggName)
			throws InterruptedException {
		doSendKeys(search, searchKey);
		Thread.sleep(2000);
		List<WebElement> suggList = getElements(suggListLocator);
		System.out.println("total suggestion list" + suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}
	}

	public void selectItem(String productName) {
		By locator = By.xpath("//li[text()='" + productName + "']");
		doclick(locator);
	}

	// **********************element displayed Utils*********

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public int getElementCount(By locator) {
		int eleCount = getElements(locator).size();
		return eleCount;
	}

	public boolean checkSingleElementExist(By locator) {
		if (getElementCount(locator) == 1) {
			return true;
		}
		return false;
	}

	public boolean checkMultipleElementExist(By locator) {
		if (getElementCount(locator) > 1) {
			return true;
		}
		return false;
	}

//******************select tag based dropdown utils*********************
	public void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectByVisibleText(By locator, String VisibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(VisibleText);
	}

	public void doSelectByValue(By locator, String Value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(Value);
	}

	public void getDropDownCount(By locator) {
		Select select = new Select(getElement(locator));
		select.getOptions().size();
	}

	public void doSelectValueFromDropDown(By locator, String Value) {

	}

	// *********** Wait Utils***************

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public void doSendKeysWithWait(By locator, int timeOut, String value) {
		waitForElementPresence(locator, timeOut).sendKeys(value);
	}

	public void doSendKeysWithWaitModified(By locator, int timeOut, String value) {
		WebElement ele = waitForElementVisible(locator, timeOut);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClickWithWait(By locator, int timeOut) {
		waitForElementPresence(locator, timeOut).click();
	}

	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForFrame(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameUsingLocatorAndSwitchToIt(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void waitForFrameUsingIndexAndSwitchToIt(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void waitForFrameUsingNameOrIdAndSwitchToIt(int timeOut, int frameNameOrId) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}

	public void waitForFrameUsingElementOrIdAndSwitchToIt(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void printAllElementsText(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

	public List<String> getAllElementsTextList(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

	public WebElement waitForElementVisibleWithFluentWait(By locator, int timeout, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
				.withMessage("Element is not present on the page.....");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsToBeVisibleWithPolling(By locator, int timeOut, int PollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(PollingTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}

	public String waitForTitleToBe(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleIs(titleValue))) {
				return driver.getTitle();
			}
		} catch (Exception e) {
			System.out.println("title is not found....");
		}
		return null;
	}

	public String waitForTitleContains(String titleFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if (wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
			}
			return driver.getTitle();
		}

		catch (Exception e) {
			System.out.println("title is not found....");
		}
		return null;
	}

	public String waitForUrl(String urlFractionValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFractionValue))) {
			return driver.getCurrentUrl();
		} else {
			System.out.println("Url is not found....");
			return null;
		}
	}

	public String waitForUrlToBe(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		} else {
			System.out.println("Url is not found....");
			return null;
		}
	}

	

}
