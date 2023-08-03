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
import pages.salePage;


public class testSalePage extends BaseTest{

	salePage objsalePage;
	loginPage objLoginIn;
	
	@BeforeClass
	public void setup() throws Exception{
		try {
		startReport("Sale Page");
		openBrowser("BrowserName");
		
		logINFO("Launching browser");
			navigate("AppURL");
			maximize();
			//CaptureScreen();
			implicitWait("IWait");
		}catch(Exception e){
			reportFailException(e);
			closeBrowser();
			
		}
					
	}
	@Test(priority=1)
	public void verifyTitleofSalePage() throws Exception
	{
		try
		{
			objLoginIn= new loginPage(driver);
		objLoginIn.LogIn(getPropValue("Email"), getPropValue("Password"));  
		logINFO("Entered Email and Password for Login");
		objsalePage= new salePage(driver);
		objsalePage.clickSaleLink();
		//CaptureScreen();
		String title=getElement("Heading_sale_page_xpath").getText();
		AssertJUnit.assertTrue(title.contains("Sale"));
		logPASS("User is on Sales Page");
		//CaptureScreen();
		reportClose();
		}catch(Exception e)
		{
			reportFailException(e);
			//CaptureScreen();
			reportClose();
			closeBrowser();
			
			
		}
		
	}
	@Test(priority=2)
	public void verifyWomenDeals() throws Exception
	{
		try {
	   if(getElement("Women_deals_button_xpath").isSelected())
	   {
		   String buttonText=getElement("Women_deals_button_xpath").getText();
		   logINFO("Button text is "+buttonText);
		   AssertJUnit.assertTrue(buttonText.contains("Shop Women’s Deals"));
		   //CaptureScreen();
		   getElement("Women_deals_button_xpath").click();
		   logPASS("Butotn is clickable");
		   reportClose();
		   closeBrowser();
	   }else
	   {
		   logFAIL("Button is not clickable");
		   //CaptureScreen();
		   reportClose();
	   }
		}catch(Exception e)
		{
			reportFailException(e);
			//CaptureScreen();
			reportClose();
		}
	}
	@AfterClass
	public void endTest()
	{
		closeBrowser();
	}
	}
	

