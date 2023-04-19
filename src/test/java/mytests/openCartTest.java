package mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class openCartTest extends BaseTest {
	
	
	@Test
	public void signNowTest() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']")).isDisplayed());
	}
	
	@Test
	public void signUpTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[@id='a-autoid-1-announce']")).isDisplayed());
	}
	
	
	
	
	
	
	
	
	
}
