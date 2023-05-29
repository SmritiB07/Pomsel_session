package myseleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class JavascriptExecutorConcept {
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		driver.get("https://www.swiggy.com/");
		//browser--JS
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		js.executeScript("return document.title;");//-------return document.title;--this is javascript
		//return document.title;--this is javascript string, we need to convert this e
		//js string into equivalent java string 
//		String title=js.executeScript("return document.title;").toString();
//		System.out.println(title);
		//custom alert
		//js.executeScript("alert(' hello java')");//execute javascript on browser
		
	//create an object of javascriptUtil
		JavascriptUtil javasriptUtil=new JavascriptUtil(driver);
		String title=javasriptUtil.getTitleByJS();
		System.out.println(title);
		
		javasriptUtil.refreshBrowserByJS();//refreshes the application
		
		//javasriptUtil.generateAlert("Welcome to myG world of Unique Gadgets");
		//javasriptUtil.refreshBrowserByJS();
	String text=javasriptUtil.getPageInnerText();
//	System.out.println(text);
//	if(text.contains("call us")) {
//		System.out.println("Pass-1");
//	}
//		WebElement login=driver.findElement(By.xpath("//input[@type='text']"));
//		javasriptUtil.drawBorder(login);
//		WebElement login=driver.findElement(By.xpath("//input[@type='submit']"));
//		javasriptUtil.sendKeyswithId("input-email","gpsim0703@gmail.com");
//		javasriptUtil.sendKeyswithId("input-password","Autosel007");
//		javasriptUtil.clickElementByJS(login);	
//		javasriptUtil.scroolPageDown();
//		Thread.sleep(5000);
//		javasriptUtil.scroolPageUp();
//		Thread.sleep(5000);
//		javasriptUtil.scroolPageDown();
//		Thread.sleep(5000);
//		javasriptUtil.scroolPageUp();
//		
     	//javasriptUtil.scroolPageDown();
     	//WebElement tag=driver.findElement(By.xpath("//div[@id='city-links']/h4"));
     	//javasriptUtil.scroolPageintoView(tag);
		//WebElement ele=driver.findElement(By.xpath("(//div[@id='city-links']//ul[@class='_1w9D3'])[1]//a[text()='bareilly']"));
		//javasriptUtil.scroolPageintoView(ele);
		
		//Thread.sleep(2000);
		//javasriptUtil.clickElementByJS(ele);
		
		//String title2=javasriptUtil.getTitleByJS();
		//System.out.println(title2);
		
		
		
		
	}

}
