package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;


import com.Base.BaseTest;

import pages.loginPage;
import pages.myAccountPage;

public class verifyMyAccount extends BaseTest {
	
	myAccountPage objAccountPage;
	loginPage objLoginIn;
	@BeforeClass
	public void setup() throws Exception{
		try {
		startReport("Sale Page");
		openBrowser("BrowserName");
		
		//logINFO("Launching browser");
			navigate("AppURL");
			maximize();
			//CaptureScreen();
			implicitWait("IWait");
		}catch(Exception e){
			reportFailException(e);
			//CaptureScreen();
			reportClose();
			
			
		}
					
	}
	@Test
	public void verifyTitleOfMyAccount() throws Exception{
		
		
			objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));  
		//logINFO("Entered Email and Password for Login");
		objAccountPage= new myAccountPage(driver);
		implicitWait("IWait");
		wait(5);
		objAccountPage.accountPage();
		String title=getElement("MyAccount_header_text_xpath").getText();
		//CaptureScreen();
		//logINFO("User navigated to My Acocunt Page");
		AssertJUnit.assertTrue(title.contains("My Account"));
		logPASS("User is on My Acocunt Page");
		System.out.println("User is on My Account Page");
		//CaptureScreen();
		reportClose();
	
		
	
}
	@AfterClass
	public void endTest()
	{
		closeBrowser();
	}
}
