package myseleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePagination {
	static WebDriver driver;

	// multiple selection
	public static void selectMultipleNames(String Country) {
		List<WebElement> CountryName = driver.
	findElements(By.xpath("(//td[text()='" + Country + "'])/preceding-sibling::td/input[@type='checkbox']"));
		for (WebElement e : CountryName) {
			e.click();
		}
	}

	// single selection
	public static void selectCity(String value) {
driver.findElement(By.xpath("//td[text()='" + value + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(4000);
		// multiple selection
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='India']")).size() > 0) {
				selectMultipleNames("India");
				WebElement next = driver.findElement(By.linkText("Next"));
				if (next.getAttribute("class").contains("disabled")) {
					System.out.println("Country is not found");
					break;
				}
				next.click();
				Thread.sleep(1000);

			}
		}
		// single selection
//       while(true) {
		// if(driver.findElements(By.xpath("//td[text()='Denmark']")).size()>0) {
//    		selectCity("Denmark");
//   		     break;
// 	   }
//    	   else {
		// pagination logic:
//    		  WebElement next= driver.findElement(By.linkText("Next"));
//    		  if(next.getAttribute("class").contains("disabled")) {
//               System.out.println("Country is not found");
//               break;
//    		  }
//    		  next.click();
//    		  Thread.sleep(1000);
//    	   }  
//    	 
//       }
// 

	}

}
