package myseleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUp {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String username = "admin";
		String password = "admin";

		driver.get("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		// "https://username:password@abc.com/basic_auth"
		// we are injecting username and password in the url itself , always remember
		// not to use @ in password otherwise error will occur
		// correct username and password is mandatory other it cannot handle this
		// scenario

	}

}
