package myG.qa.Opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ElementUtil;

public class SearchResPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public SearchResPage(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	private By prodCount=By.cssSelector("div.product-thumb");

	
	
	public int getSearchProdCount() {
		return eleUtil.waitForElementsToBeVisible(prodCount, Appconstants.MEDIUM_DEFAULT_TIME_OUT).size();
	}
	
	public ProdInfoPage selectProduct(String SearchProdName) {
		 By SrchProlink=By.linkText(SearchProdName); //Dynamic Locator
		  eleUtil.doclick(SrchProlink);
		 return new ProdInfoPage(driver); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
