package myseleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HeadlessInCognito {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions co=new ChromeOptions();
		EdgeOptions eo=new EdgeOptions();
        eo.addArguments("---headless");
		//co.setHeadless(true);
		// eo.addArguments("---incognito");
        WebDriver driver=new EdgeDriver(eo);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
       driver.quit();
		
       //headless: 
       //no browser is displayed
       //testing is fast
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
