package myseleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchh {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By search=By.name("q");
		By sugglist=By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']");
		driver.findElement(search).sendKeys("Naveen Automation Lab");
		List<WebElement> suggopt=driver.findElements(sugglist);
		System.out.println("suggest list size:"+suggopt.size());
		List<String> suggopns=new ArrayList<String>();
		for(WebElement e:suggopt) {
			String text=e.getText();
			suggopns.add(text);
			System.out.println(text);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
