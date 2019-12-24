package com.pa.qa.pages;


import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.pa.qa.base.TestBase;

import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends TestBase {
		
	protected static  String HOME_PAGE_TITLE="Automation Practice Site";
	
public HomePage(){
	super();
		}	
@FindBy(xpath="//a[contains(text(),'Shop')]")
private WebElement Shop;
@FindBy(xpath="//div[@id='n2-ss-6-arrow-next']")
private WebElement next;
@FindBy(xpath="//div[@id='n2-ss-6-arrow-previous']")
private WebElement previous;	
@FindBy(xpath="//a[text()='Home']")
private WebElement Home;
@FindBy(xpath="//img[@title='Selenium Ruby']")
private WebElement ArrivalImgLink;
@FindBys(@FindBy(xpath="//img[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']"))
private List<WebElement> slides;
@FindBys(@FindBy(xpath="//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']"))
private List<WebElement> Arrivals;
@FindBys(@FindBy(xpath="//a[@class='woocommerce-LoopProduct-link']/h3"))
private List<WebElement> ArrivalNames;


//public HomePage
public ShopPage clickOnShopLink() {
	Shop.click();
	return new ShopPage();
}

public HomePage clickOnHomeLink() {
	Home.click();
	return new HomePage();
}

public  int getSizeofHomePageSlides(){
	int Numslides=slides.size();
	return Numslides;
}
		
public int getSizeofNewArrivals(){
	int NumArrivals=Arrivals.size();
	return NumArrivals;
}

public String getArrivalName(int num) {
	WebElement  arrName=ArrivalNames.get(num);
	return arrName.getText();
}


public boolean clickOnArrivalImgLink(int num) {
	
if(Arrivals.get(num).isEnabled()){
	Arrivals.get(num).click();
	return true;
	}
else {
	return false;
     }
}




@Override
protected void VerifyValidPage() {
	
		if (driver.getTitle().contentEquals(HOME_PAGE_TITLE)) {
			test.log(LogStatus.PASS, "Sucessfully validated the Page ");
		}
		else
		{
			test.log(LogStatus.FAIL, "Failed To Validate The page");
			Assert.assertTrue(false);	
		}
	
}
@Override
protected void WaitForPageLoad() {
	try{
		new WebDriverWait(driver,30).
		until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='new arrivals']")));				
	}catch(Exception e){
			test.log(LogStatus.FAIL, e.getMessage());
	}	
}


}
