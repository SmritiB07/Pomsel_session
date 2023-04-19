package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartAutomation {
	static WebDriver driver;
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doActionsSendKeys(By locator, String Value) {
		Actions act=new Actions(driver);
		act.sendKeys(getElement(locator), Value).perform();
		
	}
	public static void doActionsClick(By locator) {
		Actions act=new Actions(driver);
		act.click(getElement(locator)).perform();
		
	}
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
       driver.get("https://accounts.google.com/signup/v2/webcreateaccount?       gmb=exp&biz=true&flowName=GlifWebSignIn&flowEntry=SignUp");
       
       By firstName=By.id("firstName");
       By password=By.name("Passwd");
	   By login=By.xpath("//span[text()='Next']");	
		
	   doActionsSendKeys(firstName, "Smriti");
	   doActionsSendKeys(password, "Smriti@123");
	   doActionsClick(login);
		
		
		
		

	}
	
	
	

}
