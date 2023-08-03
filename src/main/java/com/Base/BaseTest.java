package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;



import com.Util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;



public class BaseTest {
	
	/************ Common Variable**************/
	public static  WebDriver driver;
	
	
	 /*-------------------Extent Report--------*/
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	
	
	/*-------------------Generic Function-------------------*/
	public static String getPropValue(String PName) throws IOException
	{
		
		Properties Prop=new Properties();
		String dir=System.getProperty("user.dir");
		FileInputStream pi=new FileInputStream(dir+"\\src\\main\\java\\resources\\config.properties");
		Prop.load(pi);
		//System.out.println(Prop.getProperty(BName));
		String PValue=Prop.getProperty(PName);
		return PValue;

}
	
	public static String getObjPath(String PName) throws IOException
	{
		
		Properties Prop=new Properties();
		String dir=System.getProperty("user.dir");
		FileInputStream pi=new FileInputStream(dir+"\\src\\main\\java\\resources\\ObjPath.properties");
		Prop.load(pi);
		//System.out.println(Prop.getProperty(BName));
		String PValue=Prop.getProperty(PName);
		return PValue;

}
		public static void openBrowser(String BName) throws IOException
		{
			String Browser_Name= getPropValue(BName);
			String dir=System.getProperty("user.dir");
			if(Browser_Name.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", dir+"\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if(Browser_Name.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", dir+"\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				
			}else if(Browser_Name.equals("Edge")){
				System.setProperty("webdriver.edge.driver", dir+"\\Driver\\msedgedriver.exe");
				driver = new InternetExplorerDriver();
				
				
			}
		}
		public static void closeBrowser(){
			driver.close();
		}
		
		
		public static void navigate(String URL) throws IOException
		{
			String AppURL=getPropValue(URL);
			
			driver.get(AppURL);
		}
		public static void type(String LocatorName, String Value) throws IOException{
			
			/*String LocatorKey=getObjPath(LocatorName);
			
			
			driver.findElement(By.xpath(LocatorKey)).sendKeys(Value);*/
			getElement(LocatorName).sendKeys(Value);
			
			
		}
		public static void click(String LocatorName) throws IOException
		{
			/*String LocatorKey= getObjPath(LocatorName);
			
			driver.findElement(By.xpath(LocatorKey)).click();*/
			getElement(LocatorName).click();
			
			
		}
		public static void wait(int i) throws InterruptedException
		{
			Thread.sleep(i*1000);
			
		}
		public static  void implicitWait(String iTIME) throws IOException
		
		{
			String imTime=getPropValue(iTIME);
			long l=Long.parseLong(imTime);  
			driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);

			
		}
		public static WebElement getElement(String LocatorName){
	        WebElement e=null;
	    	try{
	    		if(LocatorName.endsWith("_id"))
	    		    e=	driver.findElement(By.id(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_name"))
	        		e=	driver.findElement(By.name(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_xpath"))
	        		e=	driver.findElement(By.xpath(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_css"))
	        		e=	driver.findElement(By.cssSelector(getObjPath(LocatorName)));
	    		else{
	    			//reportFail("Locator not Correct -"+LocatorKey);
	    		}
	    			
	    	}catch(Exception ex){
	    		//reportFail(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	        return e;
	     }
		public static List getElements(String LocatorName){
	       List<WebElement> e=null;
	    	try{
	    		if(LocatorName.endsWith("_id"))
	    		    e=	driver.findElements(By.id(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_name"))
	        		e=	driver.findElements(By.name(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_xpath"))
	        		e=	driver.findElements(By.xpath(getObjPath(LocatorName)));
	    		else if(LocatorName.endsWith("_css"))
	        		e=	driver.findElements(By.cssSelector(getObjPath(LocatorName)));
	    		else{
	    			//reportFail("Locator not Correct -"+LocatorKey);
	    		}
	    			
	    	}catch(Exception ex){
	    		//reportFail(ex.getMessage());
	    		ex.printStackTrace();
	    	}
	        return e;
	     }
		
		public static void CaptureScreen()
	    {
	     Date d=new Date();
	     //String filename=d.toString().replace(":","_").replace(" ","_")+".png";
			String filename= d.toString().replace(":","_").replace(" ","_")+".png";
	     
	     String Path = System.getProperty("user.dir")+"\\ScreenShots\\"+filename;
	     //System.out.println(Path);
	    
	     TakesScreenshot oScn = (TakesScreenshot) driver;
	     File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
	     File oDest = new File(Path);
	     try {
	         FileUtils.copyFile(oScnShot, oDest);
	         } catch (IOException e) {System.out.println(e.getMessage());}
	      
	      test.log(LogStatus.INFO, "ScreenShot->"+ test.addScreenCapture(Path));
			
	    }
		/*-------------------Start Report.................*/
		public static void startReport(String tname)
		{
			test=rep.startTest(tname);
			test.log(LogStatus.INFO, "Starting the testcases : "+tname);
		}
		public static void reportClose()
		{
			rep.endTest(test);
			rep.flush();
			
		}
		public static void browserClose()
		{
			
			if(driver!=null)
			{
				driver.quit();
				
			}
		}
		public static void logINFO(String msg){
			test.log(LogStatus.INFO, msg);
			
			}
		public void logSKIP(String msg){
			test.log(LogStatus.SKIP, msg);
			}
		public void logPASS(String msg){
				test.log(LogStatus.PASS, msg);
				}
		public void logFAIL(String msg){
					test.log(LogStatus.FAIL, msg);
				}
		 public static void reportFail(String Msg){
				test.log(LogStatus.FAIL, Msg);
				//CaptureScreen();
			}
			
			//Report Fail Exception method
		 
			public void reportFailException(Exception e) throws Exception{
			String	Msg=e.getMessage();
				String Message[]=Msg.split("}");
				String msg=Message[0];
				if(e instanceof SkipException){
				test.log(LogStatus.SKIP, msg);
				throw e;
				
					
				}else{
					test.log(LogStatus.FAIL, msg);
					//CaptureScreen();
					Assert.fail(msg);
				}
		    
		    
		    	}

		
		 
		  

		  public static void mouseTomove(String locatorName) throws IOException{
	        	//String LocatorName=getObjPath(locatorName);
	        	WebElement mobile= getElement(locatorName);
	            Actions act= new Actions(driver);
	            act.moveToElement(mobile).build().perform();
		  }
		
		 public static void maximize()
		 
		 {
			driver.manage().window().maximize();
			 
		 }
		 public static void windowSwitch()
		 {
			 Set<String> wid=driver.getWindowHandles();
			 Iterator<String> itr=wid.iterator();
			 String wid1=itr.next();
			 String wid2=itr.next();
			 
			 driver.switchTo().window(wid2);
			 driver.close();
			 driver.switchTo().window(wid1);			 
			 
			 
			 
		 }
}

