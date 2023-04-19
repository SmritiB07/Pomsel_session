package myseleniumsessions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationConcept {
     static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
        driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().to(new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/login"));
		
		System.out.println(driver.getTitle());

		
		
		
		
		
		
		
		
		
		
		
		

	}

}
