package myG.qa.Opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
  private Properties prop;
  private FirefoxOptions fo;
  private ChromeOptions co;
  private EdgeOptions eo;
	//constructor
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.setHeadless(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		return co;
	}
	
    public FirefoxOptions getFireFoxOptions() {
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.setHeadless(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
		return fo;
	}
	
    public EdgeOptions getEdgeOptions() {
    	eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.setHeadless(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--incognito");
		}
		return eo;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
