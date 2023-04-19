package myseleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Online")) {
			System.out.println("Correct title");	
		}
		else {
			System.out.println("Incorrect Title");
		}
       
		
        
		
		
		
		
		
		
		
		
		
	}

}
