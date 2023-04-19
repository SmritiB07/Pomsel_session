package myG.qa.Opencart.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ElementUtil;

public class AccountsPagemyG {
  
	private WebDriver driver;
	private ElementUtil eleUtil;
	 
	//1.By locators:
	//private By signInLoc=By.xpath("//div[@id='sw_dropdown_268']//i[@class='material-icons md-36']");
	private By logOutlink= By.linkText("Logout");
	private By srchField=By.name("search");
	private By srchIcon=By.cssSelector("div#search button");
	private By accpgHeader=By.cssSelector("div#content h2");
	
	
	//2.constructor
	public AccountsPagemyG(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	//3.page Actions
	
	public String getAccPageTitle() {  
				
		String title=eleUtil.waitForTitleToBe(Appconstants.ACCOUNTS_PAGE_TITLE,Appconstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Account page Title:"+" "+title);
		return title;
	}
	
	public String getAccPageUrl() {
		
		String Url=eleUtil.waitForUrl(Appconstants.ACCOUNT_PAGE_URL_FRACTION, Appconstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Account page Url:"+" "+Url);
		return Url;
	}
	
	public boolean doesLogOutLinkExist() {

	return eleUtil.waitForElementVisible(logOutlink,Appconstants.MEDIUM_DEFAULT_TIME_OUT ).isDisplayed();
	}
	
	public boolean doesSearchFieldExist() {
		return eleUtil.waitForElementVisible(srchField, Appconstants.MEDIUM_DEFAULT_TIME_OUT).isDisplayed();
		}
	
     	public List<String> getAccountSectionHeadersList() {
	    return eleUtil.getAllElementsTextList(accpgHeader,Appconstants.SMALL_DEFAULT_TIME_OUT);
		
		
		}
        // common page actions
     	public SearchResPage doSearch(String ProductName) {
     		
     		System.out.println("Searching for product:"+" "+ProductName);
     		eleUtil.doSendKeysWithWaitModified(srchField, Appconstants.MEDIUM_DEFAULT_TIME_OUT, ProductName);
     		eleUtil.doclick(srchIcon);
     		return new SearchResPage(driver);  //Tdd (test driven development approach)
     		
     	}
	
	
	
	

	
	
	
	
	
	
}
