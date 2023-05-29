package myseleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowTogether {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.get("https://selectorshub.com/");
		String parentWindowId = driver.getWindowHandle();
		Thread.sleep(2000);
		//WebElements to access elements on html page
driver.findElement(By.xpath("//*[local-name()='svg' and @class='e-font-icon-svg e-fab-twitter' ]")).click();
driver.findElement(By.xpath("//*[local-name()='svg' and @class='e-font-icon-svg e-fab-linkedin' ]")).click();
driver.findElement(By.xpath("//*[local-name()='svg' and @class='e-font-icon-svg e-fab-youtube' ]")).click();
driver.findElement(By.xpath("//*[local-name()='svg' and @class='e-font-icon-svg e-fab-facebook' ]")).click();

		Set<String> handles = driver.getWindowHandles();// 5 windows

		Iterator<String> ref = handles.iterator();

		while (ref.hasNext()) {
			String windowId = ref.next();
			driver.switchTo().window(windowId);
			System.out.println(driver.getCurrentUrl());

			if (!windowId.equals(parentWindowId)) {
				driver.close();
			}
			Thread.sleep(6000);
		}

		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());

		// driver.quit();

	}

}
