package myseleniumsessions;

import java.util.ArrayList;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyGcom {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myg.in/");
		//By locators
		
		//By img = By.xpath("//a[@class='cm-image-previewer cm-previewer ty-previewer']");
		//By header=By.xpath("//h1[@class='ty-product-block-title']//bdi");
		By accPgHeaders=By.xpath("//span[@class='item-with-icon']");
		//PageActions
//		String headerValue=driver.findElement(header).getText();
//		System.out.println(headerValue);
		
		
//		List<WebElement> imgEle=driver.findElements(img);
//		int imgCount=imgEle.size();
//		System.out.println("size is"+" "+imgCount);
	
		List<WebElement> ele=driver.findElements(accPgHeaders);
		List<String> eleText= new ArrayList<String>();
		for(WebElement e:ele) {
			String text=e.getText();
			eleText.add(text);
			System.out.println(eleText);
		}
		
		
		
		
//		int imgCount = waitForElementsToBeVisible(img, 20).size();
//		System.out.println(imgCount);
	}

//	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
//		WebDriver driver = null;
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//	}

}
