package myseleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowTabConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.switchTo().newWindow(WindowType.TAB);//driver is available on blank tab
		driver.get("https://selectorshub.com/");
		System.out.println(driver.getTitle());
        //always use close method, don't use quit method as that will close google as well as hub
		//close will close only those sites which we launched mid of our projects ,like we can check
		//all the links of social media midst working with some other website.
	
		driver.switchTo().newWindow(WindowType.WINDOW);
	//this will open new window after google in other window, driver is available at new window
	
	
	
	}
	
	
	

}
