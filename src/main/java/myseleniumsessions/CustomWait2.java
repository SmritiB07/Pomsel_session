package myseleniumsessions;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait2 {
 static WebDriver driver;
 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		By amazonScience=By.linkText("Amazon Science11");//FAIL IT DELIBERATELY by changing locator Amazon Science11
		waitForPageLoad(5);
		retryingElement(amazonScience, 10,2000).click();//max timeout =10sec with interval of 2sec, execution is getting slow due to polling time
		// when element is never found,on clicking it will give null pointer exception 
		//Two types of retrying method will be created
//		retryingElement(amazonScience, 10)
//		retryingElement(amazonScience, 10,2000)
	}

	
	
	public static WebElement getElement(By locator) {  
		return driver.findElement(locator);
	}
	public static WebElement retryingElement(By locator, int timeOut, int intervaltime) {//interval time or polling time
		//timeout is max time we gonna wait for element
		WebElement element=null;
		int attempts=0;
		while(attempts<timeOut) {        //0<20----- btw every two attempts there is polling time of 0.5 sec
	    try {
	    	element=getElement(locator);
	    	System.out.println("element is found:"+(attempts+1));
	    	break;
	    }
	    catch(NoSuchElementException e){
	    	System.out.println("Element is not found in attempts:"+attempts+"for locator:"+locator);
	    try {
	    	Thread.sleep(intervaltime); //500 mili sec i.e. wait for 0.5sec
	    }	
	    catch(InterruptedException e1) {
	    	e1.printStackTrace();
	    }
	    }
		attempts++;	//what if element is not available after 10s(Max time),write this condition as below
			
		}
		if(element==null) {
			try {
				throw new Exception("Element not found Excepetion");
			}
			catch(Exception e) {
				System.out.println("Element not found tried for:"+timeOut+" "+"secs"+"with interval of:"+intervaltime+"msec");
			}
			
		}
		return element;
		
		
	}
	
	public static void waitForPageLoad(int timeOut) {
		
		long endTime = System.currentTimeMillis() + timeOut;
		
		while (System.currentTimeMillis() < endTime) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String pageState = js.executeScript("return document.readyState;").toString();
			System.out.println("page loading state: " + pageState);
			if (pageState.equals("complete")) {
				System.out.println("page is fully loaded with all scripts, images, css...");
				break;
			}
		}

	}
//	public static WebElement retryingElement(By locator, int timeOut) {
//        
//		WebElement element=null;
//		int attempts=0;
//		
//		while(attempts < timeOut) {                 
//	       try {
//	    	element = getElement(locator);
//	    	System.out.println("element is found...:"+(attempts+1)+" "+"for By locator:"+locator);
//	    	break;
//	    	
//	        } catch(NoSuchElementException e){
//	    	System.out.println("Element is not found in attempts:"+attempts+"for locator:"+locator);
//	    	
//	          try {
//	    	       Thread.sleep(500);                        
//	            }	
//	            catch(InterruptedException e1) {
//	    	      e1.printStackTrace();
//	             }
//	           } 
//		attempts++;	                     
//			
//		}
//		if(element==null) {
//			try {
//				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");// throw our own custom 
//			}
//			catch(Exception e) {
//				System.out.println("Element not found exception tried for:" +timeOut+ "secs with interval of:"+500 +"msec");
//			}
//			
//		}
//		return element;
//	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
