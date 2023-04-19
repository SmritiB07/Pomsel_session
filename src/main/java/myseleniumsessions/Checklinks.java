package myseleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checklinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
         List<WebElement> linksele=driver.findElements(By.tagName("a"));
         System.out.println("total links"+":"+linksele.size());
         
//         for(int i=0;i<linksele.size();i++) {
//        	 String text=linksele.get(i).getText();
//        	 if(!text.isEmpty()) {
//        		 System.out.println(i+":"+text); 
//        	 }
//        	 
//         }
         int count=0;
         for(WebElement e:linksele) {
        	 String text=e.getText();
        	 if (!text.isEmpty()) {
        		 System.out.println("links are available at"+":"+count+" "+text); 
             }
        	 count++;
         }
        

	}

}
