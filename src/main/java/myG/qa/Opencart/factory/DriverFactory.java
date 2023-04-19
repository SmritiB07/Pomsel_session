package myG.qa.Opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static final String FileUtil = null;
	public WebDriver driver;
	public Properties prop;//class level ref
	public OptionsManager optionsManag;
    
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	/**
	 * This method is used to initialize driver on the basis of given browser name
	 * @param browserName
	 * @return driver
	 */
	
	public WebDriver initiDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		System.out.println("browser name is:" + browserName);
		OptionsManager optionsManag=new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManag.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManag.getChromeOptions()));//initi thread local driver
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManag.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManag.getFireFoxOptions()));
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver(optionsManag.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManag.getEdgeOptions()));
		} else {
			System.out.println("please pass the ryt browser" + browserName);
		}
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 *this  method give all config properties
	 * @return properties reference 
	 */
	public Properties initiProp() {
		
		 prop=new Properties();
		 FileInputStream ip=null;
		 //command line args-->maven
		 //mvn clean install-Denv="qa"// -Dbrowser="chrome":-here we are passing two environment
		 
		String envName= System.getProperty("env");  //automatically reads env variables
		System.out.println("Running test Cases in env:"+envName);
		if(envName==null) {
			System.out.println("No env is given ....hence running test cases in default env:QA");
			 try {
				ip=new  FileInputStream("./src/test/resorses/config/qa.config.properties");
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		else {
			try {
			switch(envName.toLowerCase()) {
			case "qa":
				ip=new  FileInputStream("./src/test/resorses/config/qa.config.properties");
            break;
			case "dev":
				ip=new  FileInputStream("./src/test/resorses/config/dev.config.properties");
            break;
			case "stage":
				ip=new  FileInputStream("./src/test/resorses/config/stage.config.properties");
            break;
			case "prod":
				ip=new  FileInputStream("./src/test/resorses/config/config.properties");
            break;
			case "uat":
				ip=new  FileInputStream("./src/test/resorses/config/uat.config.properties");
            break;
            
            default :
            	System.out.println("Please pass the right env"+envName);
            	break;	
				
			} 
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
		
		/**
		 * take screenshot
		 */

		public static String getScreenshot(String methodName) {
			File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);//will automatically take the screenshot
			//Users/naveenautomationlabs/Documents/workspace1/
			String path = System.getProperty("user.dir")+"./screenshot/" + methodName + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(srcFile, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
				
		

	
//		try {
//			 ip=new  FileInputStream("./src/test/resorses/config/config.properties");// './'- current project directory
//			prop.load(ip);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	//now we will use this prop everywhere to read properties
	
	
	
	
	
	
	
	

}
