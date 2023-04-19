package myseleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketNavigation {
	static WebDriver driver;
	public static void selectLevel4Prod(List<String> prodSeq)throws InterruptedException{
		WebElement mainCat=driver.findElement(By.cssSelector("a.meganav-shop"));	
		Actions act=new Actions(driver);
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(6000);
//		List<String> prodSeq=new ArrayList<String>();
//		
//		prodSeq.add("Beauty & Hygiene");
//		prodSeq.add("Skin Care");
//		prodSeq.add("Eye Care");
//		prodSeq.add("Castor Oil");
		
		
		WebElement mainCat=driver.findElement(By.cssSelector("a.meganav-shop"));
		Actions act=new Actions(driver);
		act.moveToElement(mainCat).perform();
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(By.linkText("Beauty & Hygiene"))).perform();
		Thread.sleep(1500);
		act.moveToElement(driver.findElement(By.linkText("Skin Care"))).perform();
		Thread.sleep(1500);
		act.moveToElement(driver.findElement(By.linkText("Eye Care"))).perform();
		Thread.sleep(1500);
		act.moveToElement(driver.findElement(By.linkText("Castor Oil"))).click().build().perform();
		Thread.sleep(1500);
		
		
		
		
		
		

	}

}
