package myseleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterListWithStaleElement {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
       driver.get("https://naveenautomationlabs.com/");
       
       List<WebElement> footerList=driver.findElements(By.xpath("//div[@id='pages-3']//li"));
       for(WebElement e: footerList) {
    	   e.click();
    	   Thread.sleep(2000);
    	   driver.navigate().back();
    	   footerList=driver.findElements(By.xpath("//div[@id='pages-3']//li"));  
       }
       
       
       
       
       
       

	}

}
