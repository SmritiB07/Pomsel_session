package myseleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonShop {

//	private  WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		By signIn = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
		By email = By.xpath("//input[@id='ap_email']");
		By click = By.xpath("//input[@id='continue']");
		By pwd = By.xpath("//input[@id='ap_password']");
		By amazonSignIn = By.xpath("//input[@id='signInSubmit']");
		// By forgotpwd = By.xpath("//a[@id='auth-fpp-link-bottom']");
		// By productHeader = By.xpath(
		// "//div[@id='ppd']//div[@id='titleSection']//span[text()=' Apple 2023 MacBook
		// Pro Laptop M2 Pro chip with 10‑core CPU and 16‑core GPU: 33.74 cm
		// (14.2-inch), 16GB Unified Memory, 512GB SSD Storage. Works with iPhone/iPad;
		// Space Grey ']");
		By imagecount = By.xpath("//li[@class='a-spacing-small item imageThumbnail a-declarative']");
		By searchField = By.xpath("//input[@id='twotabsearchtextbox']");

		By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
		By prodHeader = By.xpath("//div[@id='dp']//div[@id='titleSection']//span[@id='productTitle']");
		String mainProdName="Apple 2023 MacBook Pro Laptop M2"; 
		
		By mainProd=By.xpath("//h1[text()='"+mainProdName+"']");
		System.out.println(driver.getTitle());
		driver.findElement(signIn).click();
		driver.findElement(email).sendKeys("gpsim0703@gmail.com");
		driver.findElement(click).click();
		driver.findElement(pwd).sendKeys("Amazon007");
		driver.findElement(amazonSignIn).click();
//	boolean result=driver.findElement(forgotpwd).isDisplayed(); 
//	System.out.println(result); 

		driver.findElement(searchField).sendKeys("Macbook");
		driver.findElement(searchBtn).click();
		By product = By.partialLinkText(
				"Apple 2023 MacBook Pro Laptop M2 Pro chip with 10‑core CPU and 16‑core GPU: 33.74 cm (14.2-inch), 16GB Unified Memory, 512GB SSD Storage. Works with iPhone/iPad; Space Grey");
		driver.findElement(product).click();
		System.out.println(driver.findElement(mainProd).getText());

	//String header = driver.findElement(productHeader).getText();
      
//		List<WebElement> countlist=driver.findElements(imagecount);
//		int count=countlist.size();
		// List<String> suggopns=new ArrayList<String>();
		// System.out.println("images count:"+count);
//		for(WebElement e:countlist) {
//			String text=e.getText();
//			suggopns.add(text);
//			System.out.println(text);
//		}
//		
		// System.out.println(header);

	}

}