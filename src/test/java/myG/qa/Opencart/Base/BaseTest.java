package myG.qa.Opencart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import myG.qa.Opencart.Pages.AccountsPagemyG;
import myG.qa.Opencart.Pages.LoginPagemyG;
import myG.qa.Opencart.Pages.ProdInfoPage;
import myG.qa.Opencart.Pages.RegisterPage;
import myG.qa.Opencart.Pages.SearchResPage;
import myG.qa.Opencart.factory.DriverFactory;

public class BaseTest { 
  public WebDriver driver;
  public DriverFactory df;
  public LoginPagemyG lp;//maintaining page clss refernce 
  public Properties prop;
  public AccountsPagemyG accPg;
  public SearchResPage srchResPg;
  public ProdInfoPage prodInfoPg;
  public SoftAssert softassert;
  public RegisterPage regPage;
	@BeforeTest
	public void setUp() {
	 df=new DriverFactory();
	 prop=df.initiProp();
	 driver=df.initiDriver(prop);//call by reference ,now we have to change the signature of initiDriver method
	//3. String browserName=prop.getProperty("browser"); bcoz we need all the properties in one go
	 
	//1.driver=df.initiDriver("chrome");  //initiDriver is returning this same driver
	//2. driver=df.initiDriver(browserName);
	lp=new LoginPagemyG(driver);
	softassert= new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	
	
	
}
