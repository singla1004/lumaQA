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

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.BaseTest;

import pages.loginPage;
import pages.womenJacketPage;


public class verifyCountOfJacket extends BaseTest {
	
	
	//WebDriver driver;
	womenJacketPage objWomenpage;
	loginPage objLoginIn;
	
	
	@BeforeClass

	public void setup() throws IOException, Exception{
		try {
		startReport("Verify number of Jackets on page");
		openBrowser("BrowserName");
		
		logINFO("Launching browser");
			navigate("AppURL");
			maximize();
			CaptureScreen();
			implicitWait("IWait");
		}catch(Exception e)
		{
			reportFailException(e);
			CaptureScreen();
			reportClose();
			
		}
					
	}
	
	@Test(priority=6)
	
	public void verifyNumberofJacket() throws Exception
	{
		try {
		objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));   
		logINFO("Entered Email and Password for Login");
		womenJacketPage jacket= new womenJacketPage(driver);
		logINFO("Hover to women menu");
		jacket.clickTop();
		CaptureScreen();
		logINFO("Click on Jackets");
		String number=getElement("number_of_jacket_xpath").getText();
		AssertJUnit.assertTrue(number.contains("12"));
		logPASS("Number of Jacket on page is 12");
		CaptureScreen();
		reportClose();
		closeBrowser();	
		
		}
	catch(Exception e)
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
	
