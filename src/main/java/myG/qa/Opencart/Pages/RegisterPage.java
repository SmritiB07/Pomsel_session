package myG.qa.Opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName =By.id("input-firstname");
	private By lastname=By.id("input-lastname");
	private By emailField=By.id("input-email");
	private By teleNo=By.id("input-telephone");
	private By passwordField=By.id("input-password");
	private By confirmPwd=By.id("input-confirm");
	private By subscribeYes =By.xpath("(//label[@class='radio-inline'])[1]/input");
	private By subscribeNo =By.xpath("(//label[@class='radio-inline'])[2]/input");
    private By checkBoxBtn=By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By successMsg=By.cssSelector("div#content h1");
	
	
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);//untill this line is not written , eleUtil was pointing to null
	}
	
	//Page Actions:
	public boolean UserRegtn(String fstName,String lastName,String emailId,String phone,String pwd,String subscribe ) {
		
		eleUtil.waitForElementVisible(firstName, Appconstants.MEDIUM_DEFAULT_TIME_OUT).sendKeys(fstName);
		eleUtil.doSendKeys(lastname, lastName);
		eleUtil.doSendKeys(emailField,emailId );
		eleUtil.doSendKeys(teleNo, phone);
		eleUtil.doSendKeys(passwordField, pwd);
		eleUtil.doSendKeys(confirmPwd, pwd);
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doclick(subscribeYes);
		}
		else {
			eleUtil.doclick(subscribeNo);
		}
		eleUtil.doclick(checkBoxBtn);
		eleUtil.doclick(continueButton);
        String actSuccessmsg=eleUtil.waitForElementVisible(successMsg, Appconstants.MEDIUM_DEFAULT_TIME_OUT)
        		.getText();
        System.out.println("user reg success msg============"+ actSuccessmsg);
         if(actSuccessmsg.contains(Appconstants.REGISTER_SUCCESS_MSG)) {
        	 return true;
         }
		return false;
		
		
	}
	
	public void goToRegisterPage() {
		eleUtil.doclick(logoutLink);
		eleUtil.doclick(registerLink);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
