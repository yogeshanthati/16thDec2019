package com.pa.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.pa.qa.base.TestBase;
import com.pa.qa.reportlistener.Log;
import com.relevantcodes.extentreports.LogStatus;

public class MyAccountPageRegisterAndLogin extends TestBase  {
	protected static  String LOGIN_PAGE_TITLE="Automation Practice Site";
	MyAccountPageRegisterAndLogin MyAccountPageRegisterAndLogin;
public MyAccountPageRegisterAndLogin (){
	super();
		}	
@FindBy(xpath="//a[contains(text(),'Shop')]")
private WebElement Shop;	
@FindBy(xpath="//a[contains(text(),'Home')]")
private WebElement Home;
@FindBy(xpath="//a[contains(text(),'Shop')]//following::a[1]")
private WebElement MyAccount;
@FindBy(xpath="//input[@id='username']")
private WebElement username;
@FindBy(xpath="//input[@id='password']")
private WebElement pwd;
@FindBy(xpath="//input[@name='login']")
private WebElement login;

public  MyAccountPageRegisterAndLogin  LogIn(String uname,String Pwd,String uname1,String Pwd1){	
		//verification of data
	Log.info(uname +" "+Pwd+""+uname1 +" "+Pwd1);
	test.log(LogStatus.PASS,uname +" "+Pwd+""+uname1 +" "+Pwd1 );
	MyAccount.click();
	//username.sendKeys(uname);
	test.log(LogStatus.INFO, "Entered The Username As"+uname);
//.sendKeys(Pwd);
	test.log(LogStatus.INFO, "Entered The Password As"+Pwd);
  //  login.click();
	test.log(LogStatus.INFO, "Clicked on the Login Button ");
	return new  MyAccountPageRegisterAndLogin();
}

@Override
protected void VerifyValidPage() {
	
		if (driver.getTitle().trim().contains(LOGIN_PAGE_TITLE)) { 
			test.log(LogStatus.PASS, "Sucessfully validated the Page ");
		}
		else
		{
			test.log(LogStatus.FAIL, "Failed To Validate The page");
			Assert.assertTrue(false);
		}	
}

protected void WaitForPageLoad() {
	/*try{
		new WebDriverWait(driver,30).
		until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));				
	}catch(Exception e){
	 	
	}	*/
	
	Log.info("This is log in page");
}

}
