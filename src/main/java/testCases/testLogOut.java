package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseTest;

import pages.loginPage;

public class testLogOut extends BaseTest {
	
	loginPage objLoginIn;
	
	@BeforeClass
	public void setup() throws IOException, Exception{
		try {
		startReport("Test Log out Page");
		openBrowser("BrowserName");
		
		logINFO("Launching browser");
			navigate("AppURL");
			maximize();
			CaptureScreen();
			implicitWait("IWait");
		}catch(Exception e)
		{
			reportFailException(e);
		}
					
	}
	
	
	@Test(priority=0, testName="VerifyLogout")
	public void test_Log_Out() throws Exception
	{

		try {
		objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));   
		logINFO("Entered Email and Password for Login");
		implicitWait("IWait");
		wait(5);
	    getElement("login_logout_arrow_xpath").click();
	    getElement("logout_xpath").click();
	    logINFO("Clicked on Sign Out");
	    String signOut=getElement("signout_text_xpath").getText();
	    System.out.println(signOut);
	    AssertJUnit.assertTrue(signOut.contains("You are signed out"));
	    logPASS("User Logged out successfully");
	    CaptureScreen();
	    reportClose();
	    
	}catch(Exception e)
	{
		reportFailException(e);
		CaptureScreen();
		reportClose();
		closeBrowser();
	}
	}
		@AfterClass
		public void endTest()
		{
			closeBrowser();
		}

}
