package myseleniumsessions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyUpDownConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions act=new Actions(driver);
		
		//ScrollDown using Action class
       act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
       Thread.sleep(2000);
       //ScrollUp using action class
       act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	//To refresh the page
       act.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();
		
		

	}

}
