package myG.qa.Opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ExcelUtil;

import myG.qa.Opencart.Base.BaseTest;

public class RegisterPageTest extends BaseTest{

	@BeforeClass
	public void regSetUp() {
	regPage=lp.gotoRegisterPage();
	}
	

//	 @DataProvider
//	    public Object[][] getResData() {
//	    	return new Object[][] {
//	    		{"Rayaa", "Arya", "ray1073@gmail.com", "2222523344", "RayaA@123", "no"},
//	    		{"ayaa", "Arya", "ay1073@gmail.com", "2282523344", "RayaA@123", "no"},
//	    		{"Royaa", "Arya", "raoy1073@gmail.com", "2262523344", "RayaA@123", "yes"},
//	    		{"Rayia", "Arya", "rayia1073@gmail.com", "2222533344", "RayaA@123", "yes"}
//	    	};
//	    }
	
     public String randomEmail() {
	Random random=new Random();
      String email="automation"+ random.nextInt(1000)+"@gmail.com";
      System.out.println(email);
      return email;
     }

	
	@DataProvider
	public Object[][]  getExcelData() {
		Object[][] regData=ExcelUtil.getTestData(Appconstants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	@Test(dataProvider="getExcelData")
	public void userRegTest(String fstName,String lastName,String phone,String pwd,String subscribe) throws InterruptedException {
	boolean successFlag= regPage.UserRegtn(fstName,lastName,randomEmail(), phone, pwd, subscribe);
	Thread.sleep(3000);
	regPage.goToRegisterPage();
	Assert.assertEquals(successFlag,true);
	}
	
	

	
}
