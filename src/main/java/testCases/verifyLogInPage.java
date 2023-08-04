package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.IOException;


import com.Base.BaseTest;

import pages.loginPage;

public class verifyLogInPage extends BaseTest {
	
loginPage objLoginIn;
	
	@BeforeClass
	public void setup() throws IOException, Exception{
		try {
		startReport("Test Log In Page");
		openBrowser("BrowserName");
		
		//logINFO("Launching browser");
			navigate("AppURL");
			maximize();
			//CaptureScreen();
			implicitWait("IWait");
		}catch(Exception e)
		{
			reportFailException(e);
			//CaptureScreen();
			reportClose();
			
		}
					
	}
	
	
	@Test
	public void test_Log_Out() throws Exception
	{

		try {
		objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));   
		//logINFO("Entered Email and Password for Login");
		String title=getElement("login_Welcome_text_xpath").getText();
		AssertJUnit.assertTrue(title.contains("Welcome, Mohit Kumar!"));
		//logINFO("User name matched");
		//CaptureScreen();
		//logINFO("Test case passed. User logged in successfully");
		System.out.println("Test case passed. User logged in successfully");
		reportClose();
		
		}catch(Exception e)
		{
			reportFailException(e);
			//CaptureScreen();
			reportClose();
			//closeBrowser();
		}
		

}
	@AfterClass
	public void endTest()
	{
		closeBrowser();
	}
}
