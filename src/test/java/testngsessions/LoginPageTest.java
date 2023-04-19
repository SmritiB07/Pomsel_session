package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	WebDriver driver;

	@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.amazon.com/");
	}
	
	
	@Test
	public void logoTest() {
boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
	Assert.assertEquals(flag, true);
	}
	
	@Test
	public void giftbuttonTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Gift Cards']")).isDisplayed());	
	}
	@Test
	public void loginTest() {
	Assert.assertTrue(driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).isDisplayed());	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
