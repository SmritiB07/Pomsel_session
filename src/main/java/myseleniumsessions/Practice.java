package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.amazon.in/Apple-MacBook-Laptop-10%E2%80%91core-16%E2%80%91core/dp/B0BSHHL4TY/ref=sr_1_5?crid=1JW6JCTW7BVU7&keywords=macbook&qid=1675096250&sprefix=%2Caps%2C781&sr=8-5");
		By sales = By.xpath("//span[@id='productTitle']");
		String header=driver.findElement(sales).getText();
           System.out.println(header);
	}

}