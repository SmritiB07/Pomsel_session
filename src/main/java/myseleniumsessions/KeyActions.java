package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyActions {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		//driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.name("q"));
		Actions act =new Actions(driver);
		act.keyDown(ele, Keys.SHIFT).sendKeys("smriti bhandari").build().perform();

	}

}
