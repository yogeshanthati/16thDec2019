package com.pa.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pa.qa.base.TestBase;
import com.pa.qa.pages.*;
import com.pa.qa.reportlistener.CaptureScreenShot;
import com.pa.qa.reportlistener.Log;
import com.pa.qa.util.Constants;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends Constants {
	
	//written  all the pages class references
	HomePage homepage; 
	ProductPage productPage;
	ShopPage shopPage;
   
    @BeforeTest
    public void ConfigureReport(){
    	TestBase.Cofigurereport();
    }
    @BeforeMethod
    public void setUp() throws MalformedURLException
    {
        TestBase.intialization();
        Log.startTestCase(this.getClass().getSimpleName());
		test =  extent.startTest(this.getClass().getSimpleName());
    }
 
  @Test(priority=0)
    public void HomePageSlidesTest()
   {
	  homepage= new HomePage(); 
	  shopPage =homepage.clickOnShopLink();
	  homepage  =homepage.clickOnHomeLink();
   	int slides=homepage.getSizeofHomePageSlides();
   	if(slides==3) {
   	test.log(LogStatus.PASS,"Sucessfully validated the three slides ");
   	Reporter.log("Sucessfully validated the three slides ");
   	               }
   	else {
   		 test.log(LogStatus.FAIL, "Failed To Validate three slides");
		 Assert.assertTrue(false);
     	 }
   	}
   	
   	
  @Test(priority=2)
  public void HomePageArrivalsTest()
 {
	  homepage= new HomePage(); 
	  shopPage  =homepage.clickOnShopLink();
	  homepage= homepage.clickOnHomeLink();
 	int arrivals=homepage.getSizeofNewArrivals();
 	if(arrivals==3) {
 	test.log(LogStatus.PASS,"Sucessfully validated the three arrivals ");
 	Reporter.log("Sucessfully validated the three slides ");
 	               }
 	else {
 		 test.log(LogStatus.FAIL, "Failed To Validate three arrivals");
		 Assert.assertTrue(false);
   	 }
 	}
   	
  @Test(priority=3)
  public void HomePageNewArrivalsNavigateTest()
 {   homepage= new HomePage(); 
 
 shopPage  =homepage.clickOnShopLink();
 homepage= homepage.clickOnHomeLink();
	  
 	int arrivals=homepage.getSizeofNewArrivals();
 	if(arrivals==3) {
 	test.log(LogStatus.PASS,"Sucessfully validated the three arrivals ");
 	Reporter.log("Sucessfully validated the three slides ");
 	               }
 	else {
 		 test.log(LogStatus.FAIL, "Failed To Validate three arrivals");
		 Assert.assertTrue(false);
   	 }
 	
 	
 String HomePageArrivalImageName=homepage.getArrivalName(0);	
 boolean imgClick  =homepage.clickOnArrivalImgLink(0);
 productPage=new ProductPage();
 String ProductPageArrivalImageName=productPage.getProductTitle();
 if(imgClick &&(HomePageArrivalImageName.contentEquals(ProductPageArrivalImageName))) {
	 test.log(LogStatus.PASS,"Sucessfully clicked the the arrival image ");
 }
 
 else { 
		 test.log(LogStatus.FAIL, "Failed To click the arrival Imge");
	 Assert.assertTrue(false);
	 }
 	}
   
  
    @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {	
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = CaptureScreenShot.captureScreen( driver, this.getClass().getSimpleName());
            test.log(LogStatus.FAIL, result.getThrowable());
            test.log(LogStatus.FAIL, "Snapshot below: " +  test.addScreenCapture(screenShotPath));
        }
        
      extent.endTest(test);
      Log.endTestCase(this.getClass().getSimpleName());
      driver.quit();
 
    } 
    @AfterTest
    public void tearDown()
    
    {
    	extent.flush();
        extent.close();
     
    }
    

}
