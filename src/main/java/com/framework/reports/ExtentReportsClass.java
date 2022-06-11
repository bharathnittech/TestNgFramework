package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportsClass {
	
	public static ExtentReports extentreport;
	public static ExtentTest print;
	
	@BeforeSuite(alwaysRun=true)
	public static void setupReport() {
		extentreport = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\AutomationReport.html");
		extentreport.addSystemInfo("Project Name", "Parabank Internetbanking System");
	}
	
	@AfterSuite(alwaysRun=true)
	public static void stopReporting() {
		extentreport.flush();
	}

}
