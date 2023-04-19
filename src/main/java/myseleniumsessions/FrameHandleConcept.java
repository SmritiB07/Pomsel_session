package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandleConcept {

	public static void main(String[] args) {
	

		
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		//driver.switchTo().frame(2);
		//driver.switchTo().frame("main");
////frame[@name='content']
		driver.switchTo().frame(driver.findElement(By.name("navbar")));
		
		
		
		
		String header=driver.findElement(By.tagName("h3")).getText();
		System.out.println(header);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
