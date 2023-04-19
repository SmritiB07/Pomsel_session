package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadMethod {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("");
		//type="file" should be there with with any tag....
		//dont provide .click with this, as if we click it will block the Selenium ,it will automatically upload the file without clicking
		driver.findElement(By.name("upfile")).sendKeys("path of anyfile fromyour computer system.jpeg,.xl,.png");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
