package testngsessions2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageBMtest {
	
	WebDriver driver;
	@BeforeMethod
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://accounts.google.com/signup/v2/webcreateaccount?gmb=exp&biz=true&flowName=GlifWebSignIn&flowEntry=SignUp");
	}
	
	@Test(priority=1)
	public void signInTest() {
boolean flag=driver.findElement(By.xpath("//span[text()='Sign in instead']")).isDisplayed();
	Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void nextbuttonTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Next']")).isDisplayed());	
	}
	@Test(priority=2)
	public void signUpTest() {
	driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Sim");	
	driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Bhan");	
	driver.findElement(By.name("ConfirmPasswd")).sendKeys("12345678");	
	driver.findElement(By.name("Passwd")).sendKeys("12345678");	
	driver.findElement(By.xpath("//span[text()='Next']")).click();	
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
