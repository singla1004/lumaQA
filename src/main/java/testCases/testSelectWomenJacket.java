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
import pages.womenJacketPage;

public class testSelectWomenJacket extends BaseTest {
	
	
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
			closeBrowser();
		}
	}
	@Test(priority=3)
	public void selectWomenJacket() throws Exception
	{
		try {
		objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password")); 
		logINFO("Entered Email and Password for Login");
		womenJacketPage jacket= new womenJacketPage(driver);
		logINFO("Hover to women menu");
		jacket.clickTop();
		logINFO("Click on Jackets");
		CaptureScreen();
		String heading=getElement("Heading_of_olivia_jacket_xpath").getText();
		logINFO("Name of Jacket is "+heading);
		click("Olivia_women_jacket_xpath");
		String oliviaHeading=getElement("Olivia_women_jacket_heading_xpath").getText();
		CaptureScreen();
		logINFO("Name of Jacket after opening jacket is "+oliviaHeading);
		AssertJUnit.assertEquals(heading, oliviaHeading);
		logPASS("Opened jacket is same as selected.");
		}catch(Exception e)
		{
			reportFailException(e);
			CaptureScreen();
			reportClose();
			
		}
		
	}
	@Test(priority=4)
	public void verifyJacketAddToCart() throws Exception
	{
		try {
			
			click("Women_Jacket_size_xpath");
			click("Women_Jacket_color_xpath");
			click("Add_to_cart_xpath");
			String success=getElement("Added_to_cart_success_msg_xpath").getText();
			AssertJUnit.assertTrue(success.contains("You added Olivia 1/4 Zip Light Jacket to your shopping cart."));
			CaptureScreen();
			logPASS("Olivia jacket added into cart successfully");
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

