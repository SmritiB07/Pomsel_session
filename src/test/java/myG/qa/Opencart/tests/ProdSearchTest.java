package myG.qa.Opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ExcelUtil;

import myG.qa.Opencart.Base.BaseTest;

public class ProdSearchTest extends BaseTest {
	
	@BeforeClass
	public void ProdSearchSetUp() {
		accPg=lp.doLogin(prop.getProperty("emaill"), prop.getProperty("pwd"));
	}
	 @DataProvider
	 public Object[][] getProductInfoData() {
	    	return new Object[][] {
	    		{"Macbook","MacBook",5},
	    		{"Macbook","MacBook Air",4},
	    		{"samsung","Samsung SyncMaster 941BW",1},
	    		{"imac","iMac",3}
	    	};
	    }
    
	@Test(dataProvider="getProductInfoData")
	public void ProdImageCountTest(String proSrc,String prodReq,int count) {
		srchResPg=accPg.doSearch(proSrc);
		prodInfoPg=srchResPg.selectProduct(prodReq);
		int actcount=prodInfoPg.getProdImgCount();
		Assert.assertEquals(actcount, count);	
	}
	
//	 @DataProvider
//	    public Object[][] getProductData() {
//	    	return new Object[][] {
//	    		{"Macbook","MacBook"},
//	    		{"Macbook","MacBook Air"},{"samsung","Samsung SyncMaster 941BW"}
//	    	};
//	    }
	 @DataProvider
     public Object[][] getProductExcelData(){
    	return ExcelUtil.getTestData(Appconstants.PRODUCT_SHEET_NAME);
    	
     }
	
	@Test(dataProvider="getProductExcelData")
	public void ProdSearchHeaderTest(String searchkey,String productname) {
		srchResPg=accPg.doSearch(searchkey);
		prodInfoPg=srchResPg.selectProduct(productname);
		String header=prodInfoPg.getProdHeader();
		Assert.assertEquals(header, productname);
	}

//	@DataProvider
//	public Object[][] getProductExcelData(){
//		return ExcelUtil.getTestData(AppConstants.PRODUCT_SHEET_NAME);
//	}

	
	@Test
	public void prodDataTest() {
		srchResPg=accPg.doSearch("Macbook");
		prodInfoPg=srchResPg.selectProduct("MacBook Pro");
		Map<String,String> actProdInfo=prodInfoPg.getProdMetaInfo();
		
		softassert.assertEquals(actProdInfo.get("Brand"),"Apple" );
		softassert.assertEquals(actProdInfo.get("Product Code"),"Product 18" );
		softassert.assertEquals(actProdInfo.get("Reward Points"),"800" );
		softassert.assertEquals(actProdInfo.get("Availability"),"In Stock" );
		softassert.assertEquals(actProdInfo.get("productname"),"MacBook Pro" );
		softassert.assertEquals(actProdInfo.get("productprice"),"$2,000.00" );
		softassert.assertEquals(actProdInfo.get("extprice"),"Ex Tax: $2,000.00" );
		softassert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
