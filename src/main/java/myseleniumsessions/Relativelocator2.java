package myseleniumsessions;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relativelocator2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement baseEle=driver.findElement(By.linkText("Oliver Paipoonge, Canada"));
		String rightIndx=driver.findElement(with(By.tagName("p")).toRightOf(baseEle)).getText();
System.out.println(rightIndx);
	}

}
