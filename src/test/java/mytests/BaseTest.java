package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

  public class BaseTest {
       WebDriver driver;
        
       @Parameters({"url","browser"})
       @BeforeTest
	    public void setup(String Url,String browserName) {
    	   if(browserName.equalsIgnoreCase("chrome")) {
    		   WebDriverManager.chromedriver().setup();
    			driver=new ChromeDriver();   
    	   }
    	   else if(browserName.equalsIgnoreCase("firefox")) {
    		   WebDriverManager.chromedriver().setup();
   			driver=new FirefoxDriver();
    	   }
    	   
    	   else if(browserName.equalsIgnoreCase("edge")) {
    		   WebDriverManager.chromedriver().setup();
      			driver=new EdgeDriver(); 
    	   }
    	   else {
    		   System.out.println("please passs the right browser:"+browserName);
    	   }
    	   
		driver.get(Url);
	
        }
		
  
         @AfterTest
		public void teardown() {
			driver.quit();
		
		}
		
		
}
