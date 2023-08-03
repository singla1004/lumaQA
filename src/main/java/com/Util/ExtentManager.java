package com.Util;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	//private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		Date d=new Date();

		String filename=d.toString().replace(":", "_").replace(" ", "_")+".html";
	String Path=System.getProperty("user.dir")+"//ExtentReports//"+filename;
		ExtentReports extent=new ExtentReports(Path,false);
		extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			return extent;
		
		
		
	}
	

}
