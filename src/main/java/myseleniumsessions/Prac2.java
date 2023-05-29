package myseleniumsessions;

import java.util.ArrayList;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Prac2 {
	 static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions opt= new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver(opt);
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/search&search=Macboo");
			//By Camera= By.xpath("//a[text()='Cameras']");
			//By link=By.xpath("//div[@class='col-sm-9']//h2[text()='New Customer']");
			//driver.findElement(By.linkText("Cameras")).click();
			//String value=driver.findElement(link).getText();
		//System.out.println("value of linktext a is----:"+" "+value );
			//By link=By.xpath("//label[@class='checkbox-inline']//input[@name='description']");
			//driver.findElement(link).click();
			/*
			By devices=By.xpath("//select[@name='category_id']");
			Select select = new Select(driver.findElement(devices));
			List<WebElement> deviceslist= select.getOptions();
			//List<String> devicesText=new ArrayList<String>();
			System.out.println("Total no of devices:"+deviceslist.size());
			if(deviceslist.size()-1==38) {
				System.out.println("Pass");
			}
			
			for(WebElement e:deviceslist) {
				String text=e.getText();
				if(text.contains("Components")) {
					e.click();
				}
				//System.out.println(text);
				//devicesText.add(text);
			}
			//System.out.println(devicesText.toString());
			*/
			/*
			WebElement header=driver.findElement(By.xpath("(//div[@class='col-sm-9']//h2)[1]"));
			if(header.isDisplayed()) {
				System.out.println("pass");
			}
			*/
			 /* 
			Actions act=new Actions(driver);
			By test =By.linkText("MP3 Players");
			By child=By.xpath("((//ul[@class='list-unstyled'])[4]//li)[2]//a");
			act.moveToElement(driver.findElement(test)).perform();
			Thread.sleep(2000);
			driver.findElement(child).click();
			
			Actions act=new Actions(driver);
			By ser=By.name("search");
			By click=By.xpath("//span[@class='input-group-btn']//button");
			act.sendKeys(driver.findElement(ser),"Macbook").perform();
			act.contextClick(driver.findElement(click)).perform();
			*/
			String text=driver.findElement(By.name("search")).getAttribute("value");
			System.out.println(text);
			
			
			
			
		

	}

}
