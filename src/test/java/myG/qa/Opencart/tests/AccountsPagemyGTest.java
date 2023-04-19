package myG.qa.Opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenCart.constants.Appconstants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import myG.qa.Opencart.Base.BaseTest;

@Epic("Epic - 200:Design the accounts page feature for myG application")
@Story("US - 201:design account page features")
public class AccountsPagemyGTest extends BaseTest {
	
	@BeforeClass
	public void accSetUp() {
		accPg=lp.doLogin(prop.getProperty("emaill"), prop.getProperty("pwd"));
	}
	
	@Test
	public void LogOutLinkExistTest() {
	Assert.assertEquals(accPg.doesLogOutLinkExist(),true);
	}
	
	@Test
	public void AccPgTitleTest() {
		Assert.assertEquals(accPg.getAccPageTitle(), Appconstants.ACCOUNTS_PAGE_TITLE);
	}
	@Test
	public void SearchFieldExistTest() {
	Assert.assertEquals(accPg.doesSearchFieldExist(),true);
	}
	
	@Test
	public void AccPgUrlTest() {
		Assert.assertEquals(accPg.getAccPageUrl(), Appconstants.ACCOUNT_PAGE_URL_FRACTION);
	}
	
	@Test
	public void accPageHeaderTest() {
		List<String> accHeader=accPg.getAccountSectionHeadersList();
		System.out.println("======actual account header======="+accHeader);
		Assert.assertEquals(accHeader,Appconstants.EXPECTED_ACCOUNTS_HEADER_LIST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
