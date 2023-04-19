package myG.qa.Opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPagemyG {
	
        private WebDriver driver;
        private ElementUtil eleUtil;
        
// By locator (Object Repository)        
    private By forgotPwdLink=By.linkText("Forgotten Password"); 
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By signInBtn=By.xpath("//input[@type='submit']");
	private By registerLink=By.linkText("Register");
	
	//Page Constructor
	
	public LoginPagemyG( WebDriver driver) { //to get the value of this particular driver
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	//PageActions
	@Step("getting lgin page title")
	public String getPageLoginTitle() {  //public page actions to access private By locators
		                                                          //1.String title= driver.getTitle();now we have eleUtil
		String title=eleUtil.waitForTitleToBe(Appconstants.LOGIN_PAGE_TITLE,Appconstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Login page Title:"+" "+title);
		return title;
	}
	@Step("is forgot password link exist")
	public boolean forgotPwdlinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	@Step("getting login page url")
	public String getPageLoginUrl() {
		//1.String Url= driver.getCurrentUrl();
		String Url=eleUtil.waitForUrl(Appconstants.LOGIN_PAGE_URL_FRACTION, Appconstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Login page Title:"+" "+Url);
		return Url;
	}
	@Step("login with username: {0} and password: {1}")
	public AccountsPagemyG doLogin(String UserName, String Pwd) {
		
		System.out.println("app credentials:"+" "+UserName+" "+Pwd);
        eleUtil.doSendKeysWithWaitModified(emailId, Appconstants.MEDIUM_DEFAULT_TIME_OUT, UserName);
	    eleUtil.doSendKeys(password, Pwd);
	    eleUtil.doclick(signInBtn);
	    return new AccountsPagemyG(driver);
	    
		//2.return eleUtil.waitForTitleToBe(Appconstants.ACCOUNTS_PAGE_TITLE, Appconstants.LONG_DEFAULT_TIME_OUT);
//		driver.findElement(signInLoc).click();
//		driver.findElement(signInEnter).click();
		//driver.findElement(emailId).sendKeys(UserName);
		//driver.findElement(password).sendKeys(Pwd);
		//driver.findElement(signInBtn).click();
	    //1.return driver.getTitle() ;
	//Now we are not using driver anywhere as framework will start using only utilities
	}
	
	@Step("perform search for the product: {0}")
	public SearchResPage performSearch(String name) {
		AccountsPagemyG accPage = new AccountsPagemyG(driver);
		return accPage.doSearch(name);

	}
	@Step("navigate to reg page")
	public RegisterPage gotoRegisterPage() {
		eleUtil.doclick(registerLink);
		return new RegisterPage(driver);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
