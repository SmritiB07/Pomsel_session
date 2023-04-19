package myG.qa.Opencart.Pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.OpenCart.constants.Appconstants;
import com.qa.OpenCart.utils.ElementUtil;

public class ProdInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By mainProd=By.cssSelector("div#content h1");
	private By imgCountLoc=By.cssSelector("ul.thumbnails img");
	private By prodMetaInfo=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By prodMetaPrice=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private Map<String, String> prodMap;//on global level ,it is getting filled from wherever it is called

	
	public ProdInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}
	
	public String  getProdHeader() {
		String ProdHeaderValue=eleUtil.doElementGetText(mainProd);
		System.out.println("Product Header text:"+" "+ProdHeaderValue);
		return ProdHeaderValue;
	} 
	
	public int  getProdImgCount() {
	List<WebElement> ImagList=eleUtil.waitForElementsToBeVisible(imgCountLoc, Appconstants.LONG_DEFAULT_TIME_OUT);
	int count=ImagList.size();
		System.out.println("Count of Images available at produt search page:"+" "+count);
		return count;
	}
	
	public Map<String,String> getProdMetaInfo() {
		
	    prodMap=new TreeMap<String,String>();//initialize map
	    
	    //add prod header in Map:
	    prodMap.put("productname", getProdHeader());
	    getProdMetadataInfo();
	    getProdMetaPriceInfo();
	    System.out.println("===========act pro Header========");
	    prodMap.forEach((k,v)->System.out.println(k+":"+v));
	    
	    return prodMap;
	}

	private void getProdMetadataInfo() {
//		Brand: Apple
//		Product Code: Product 18
//		Reward Points: 800
//		Availability: In Stock
	    List<WebElement> metaDataList=eleUtil.getElements(prodMetaInfo);
		for(WebElement e:metaDataList) {
		String text=e.getText();
		String meta[]=text.split(":");
		String key=meta[0].trim();
		String value=meta[1].trim();
		prodMap.put(key, value);
		}
		
	}	
	
	private void getProdMetaPriceInfo(){

//		$2,000.00
//		Ex Tax: $2,000.00
	    List<WebElement> metaPriceList=eleUtil.getElements(prodMetaPrice);	
		String prodPrice=metaPriceList.get(0).getText().trim();
		String prodExtPrice=metaPriceList.get(1).getText().trim();
		//create custom key
		prodMap.put("productprice",prodPrice);
		prodMap.put("extprice", prodExtPrice);//key is used in small letters
       
		}
	}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


