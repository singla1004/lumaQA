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
import pages.searchItem;

public class verifySearchItem extends BaseTest {
	
	searchItem objSearchItem;
	loginPage objLoginIn;
	
	@BeforeClass
	public void setup() throws IOException, Exception{
		try {
		startReport("Test Search functionality");
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
	@Test(priority=9)
	public void verifySearch() throws Exception
	{
		try {
			objLoginIn= new loginPage(driver);
			objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));  
			logINFO("Entered Email and Password for Login");
			objSearchItem= new searchItem(driver);
			objSearchItem.search(getPropValue("SearchItem"));
			logINFO("Item searched");
			CaptureScreen();
			String result=getElement("Search_result_header_text_xpath").getText();
			AssertJUnit.assertTrue(result.contains("Search results for"));
			logPASS("Test case is passed. User is able to search.");
			CaptureScreen();
			reportClose();
			closeBrowser();
			
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
	
