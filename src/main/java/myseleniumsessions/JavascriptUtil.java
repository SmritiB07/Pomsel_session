package myseleniumsessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {
 private WebDriver driver;
 //constructor
 public JavascriptUtil(WebDriver driver) {
	 this.driver=driver;
 }

 public void flash(WebElement element) {
	 String bgcolor= element.getCssValue("background");
	 for(int i=0;i<3;i++) {
		 changeColor("rgb(0,200,0)",element);
		 changeColor(bgcolor,element);
	 }
 } 
private void changeColor(String color,WebElement element) {
	JavascriptExecutor js=((JavascriptExecutor)driver);
	js.executeScript("arguments[0].style.backgroundColor='"+ color +"'",element);
	try {
		Thread.sleep(20);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}	
	
	public String getTitleByJS() {//wrapper function
		JavascriptExecutor js=((JavascriptExecutor)driver);
		return js.executeScript("return document.title;").toString();
	}
	public void gobackByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("history.go(-1)");
	}
	public void goforwardByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("history.go(1)");
	}
	public void refreshBrowserByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("history.go(0)");
	}
	public void generateAlert(String message) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("alert('"+message+"')");
	}
	public String getPageInnerText() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
    return js.executeScript("return document.documentElement.innerText;").toString();
	}
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript(" arguments[0].click();",element );
	}
	public void sendKeyswithId(String id,String value) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("document.getElementById('"+id+"').value='"+value+"'" );
	}
	public void drawBorder(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public void scroolPageDown() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scroolPageUp() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	public void scroolPageDown(String height) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("window.scrollTo(0,'"+height+"')");
	}
	public void scroolPageintoView(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
         js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
