package myG.qa.Opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenCart.constants.Appconstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import myG.qa.Opencart.Base.BaseTest;


@Epic("Epic- 100: Design the login page features for open cart application")
@Story("US - 101: design loginn page features with login, forgot pwd, title, url")
public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	@Description("TC_01: login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void logInPageTitleTest() {
		String actTitle=lp.getPageLoginTitle();
		Assert.assertEquals(actTitle,Appconstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	@Description("TC_02: login Page url Test")
	@Severity(SeverityLevel.NORMAL)
	public void logInPageUrlTest() {
		String actUrl=lp.getPageLoginUrl();
		Assert.assertEquals(actUrl.contains(Appconstants.LOGIN_PAGE_URL_FRACTION), true);
		}
	
	
	@Test(priority=3)
	@Description("TC_03: verify forgot pwd link exist on the login page")
	@Severity(SeverityLevel.CRITICAL)
	public void ForgotPwdLinkTest() {
		Assert.assertEquals(lp.forgotPwdlinkExist(), true);
	}
	
	
	@Test(priority=4)
	@Description("TC_04: verify user is able to login with correct username and password")
	@Severity(SeverityLevel.BLOCKER)
	public void LoginTest() {
		accPg=lp.doLogin(prop.getProperty("emaill"),prop.getProperty("pwd"));
		Assert.assertEquals(accPg.getAccPageTitle(),Appconstants.ACCOUNTS_PAGE_TITLE);
	
}
	@Test(enabled=false)
	public void loginPageFooterTest() {
		System.out.println("loginpage footer tst");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
