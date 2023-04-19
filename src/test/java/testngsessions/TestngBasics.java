package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {

	@BeforeSuite
	public void connectWithDB() {
	System.out.println("BS--Connect with DB");	
     }
	@BeforeTest
	public void createUser() {
		System.out.println("BT Create User");
	}
	@BeforeClass
	public void luanchBrowser() {
		System.out.println("BC--Launch Browser");
	}	
	
	@BeforeMethod
	public void login() {
		System.out.println("BM--login");
	}
    
	@Test
	public void homepageTest() {
		System.out.println("Home Page Test");
	}
	@Test
	public void searchpageTest() {
		System.out.println("Search Page Test");
	}
	@Test
	public void addtoCartTest() {
		System.out.println("Add to cart Test");
	}
	@AfterSuite
	public void disconnectWithDB() {
	System.out.println("AS--Disconnect with DB");	
     }
	@AfterTest
	public void deleteUser() {
		System.out.println("AC--Delete User");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("AC--Close Browser");
	}	
	
	@AfterMethod
	public void logout() {
		System.out.println("AM--logout");
	}
	
	
	
	
	
	
	
}
