package myseleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
		 
        driver.get("https://www.google.com/");
      //  driver.findElement(By.name("q")).sendKeys("Smriti Bhandari");
//      driver.findElement(By.name("q")).sendKeys("naveen automation labs");
//       Thread.sleep(3000);
//       
//       List<WebElement> suggList=driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']"));
//       System.out.println("total suggestion:"+suggList.size());
//		 for(WebElement e:suggList) {
//              String test=e.getText();
//              System.out.println(test);
//              String youtube = null;
//			if(test.contains(youtube)) {
//            	  e.click();
//            	  break;
//              }
//			 
//		 }
		
		By search=By.name("q");
		By suggListLocator=By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']");
		
		 performsearch(search,suggListLocator,"Smriti bhandari instagram","beravishing_sim");
		 
	}

	
	
	
      public static List<WebElement> getElements(By locator) {
    	  return driver.findElements(locator);
      }
      public static WebElement getElement(By locator) {
    	  return driver.findElement(locator);
      }
	  public static void dosendkeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	   }
	
        public static void performsearch(By search,By suggListLocator,String searchEle,String suggName) throws InterruptedException {
        	dosendkeys( search,searchEle );
        	Thread.sleep(3000);
         List<WebElement> suggList=getElements(suggListLocator);
         List<String> suggop=new ArrayList<String>();
         System.out.println("total suggestions:"+suggList.size());
        	for(WebElement e:suggList) {
        		String text= e.getText();
        		suggop.add(text);
        		System.out.println(suggop);
        		if(text.contains(suggName)) {
        			e.click();
        		break;
        		}
        	}
        	
        }	
        	
}







