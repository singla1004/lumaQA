package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.IOException;




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
	public void verifySearch() throws Exception
	{
		try {
			objLoginIn= new loginPage(driver);
			objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));  
			//logINFO("Entered Email and Password for Login");
			objSearchItem= new searchItem(driver);
			objSearchItem.search(getPropValue("SearchItem"));
			//logINFO("Item searched");
			//CaptureScreen();
			String result=getElement("Search_result_header_text_xpath").getText();
			AssertJUnit.assertTrue(result.contains("Search results for"));
			logPASS("Test case is passed. User is able to search.");
			System.out.println("Search functionality passed");
			//CaptureScreen();
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
	
