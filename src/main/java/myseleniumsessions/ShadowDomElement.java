package myseleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomElement {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//html DOM page---->elements
		      //----->iframe
		             //---->Shadow DOM
		                     //----->input tea 
		//html DOM page---->elements
	          //----->iframe
	                     //----->input tea 
		
		
		
		
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.get("https://selectorshub.com/xpath-practice-page/");
     Thread.sleep(3000);
    //No such element exception
    // driver.findElement(By.id("tea")).sendKeys("Masala Tea");
    driver.switchTo().frame("pact");
    Thread.sleep(3000);
    
    JavascriptExecutor js=(JavascriptExecutor)driver;
 WebElement tea=(WebElement)js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector('#tea')");
    tea.sendKeys("Masala Tea");
	}

}
