package myseleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		driver.findElement(By.name("proceed")).click();
//		Thread.sleep(5000);
		// Alert alert=driver.switchTo().alert();//driver instance will switch to alert
//		String text=alert.getText();
//		System.out.println(text);
		//alert.accept();
		//alert.dismiss();
		// 1. executed alert from heerokuapp 
//		driver.findElement(By.xpath("(//div[@id='content']//ul[@style='list-style-type: none;']/li)/button[1]")).click();
//		Thread.sleep(5000);
//		Alert alert=driver.switchTo().alert();
//			String text=alert.getText();
//			System.out.println(text);
//             Thread.sleep(3000);
//	         alert.accept();/alert.dismiss();
		//2. execute confirm alert
//	 		driver.findElement(By.xpath("((//div[@id='content']//ul[@style='list-style-type: none;']//li)//button)[2]")).click();
//	 		Thread.sleep(5000);
//			Alert alert=driver.switchTo().alert();
//				String text=alert.getText();
//				System.out.println(text);
//	             Thread.sleep(3000);
//		           alert.dismiss();
		//3. execute prompt alert
		driver.findElement(By.xpath("((//div[@id='content']//ul[@style='list-style-type: none;']//li)//button)[3]")).click();
		 Thread.sleep(5000);
		 Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			System.out.println(text);
			alert.sendKeys("sim");
             Thread.sleep(3000);
	           alert.accept();
		alert.sendKeys("smriti");
		
		
		
		
		
		
		
	}

}
