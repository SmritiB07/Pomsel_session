package myseleniumsessions;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator {
    WebDriver driver;
	
    @BeforeClass
    public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://automationbookstore.dev/");
        driver.manage(). window().maximize();
    }
    
    @AfterClass
    public void tearDown() {
    	driver.close();
    }
    
    @Test(description="Test Book5 is left of Book6 and Below Book1")
    public void test1() 
    {
    	//String rightIndex = driver.findElement(with(By.tagName("p")).toRightOf(baseEle)).getText();
	//	System.out.println(rightIndex);	
   driver.findElement(with(By.tagName
    		("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));	
    }
    
    
    
    
    
    
    
    
    
	}


