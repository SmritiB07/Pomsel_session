package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginwithNegativeTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://app.hubspot.com/login/");
	}
@DataProvider
public Object[][] getLoginNegativeData() {
	return new Object[][] {//2d array literals
		{"test121211121@gmail.com","test@1234"},
		{"test121214561@gmail.com","test@13234"},
		{"test1212178981@gmail.com","selenium@1234"},
		{"  ","test@12354"},
		{"test121211acb1@gmail.com","  "}	
	};
}

	@Test(dataProvider="getLoginNegativeData")
	public void logInNegativeTest(String username,String password) {	
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("loginBtn")).click();
	String errMsg=driver.findElement(By.xpath("//div[@role='alert']")).getText().trim();	
	System.out.println(errMsg);	
	Assert.assertEquals(errMsg, "That email address doesn't exist.");	
		
	
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
