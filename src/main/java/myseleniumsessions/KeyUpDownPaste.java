package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyUpDownPaste {

	public static void main(String[] args) {
	 
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	     //driver.manage().window().maximize();
	
		WebElement ele=driver.findElement(By.name("q"));
		
		Actions act=new Actions(driver);
		act.keyDown(ele, Keys.SHIFT).sendKeys("naveen automation labs").build().perform();
		//entire sendkeys text will get converted into capital letter as we have pressed shift key
		
// any action related to select, copy, paste: we need this code; create google account 
		
//By locator==firstName.sendkeys("smriti")
		
		
//act.KeyDown(keys.CONTROL).sendkeys("a").keyUp(keys.CONTROL).build().perform();		
//act.KeyDown(keys.CONTROL).sendkeys("c").keyUp(keys.CONTROL).build().perform();
//By locator==userName.click();
//act.KeyDown(keys.CONTROL).sendkeys("v").keyUp(keys.CONTROL).build().perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
 
}
