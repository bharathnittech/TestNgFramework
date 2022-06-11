package com.framework.listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.framework.reports.ExtentReportsClass;
import com.relevantcodes.extentreports.LogStatus;

public class TestListners extends ExtentReportsClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		print = extentreport.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		print.log(LogStatus.PASS, "Test Case Successfully Executed :"+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		print.log(LogStatus.FAIL, "Test Case is Failed :"+result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		print.log(LogStatus.SKIP, "Test Case is Skipped :"+result.getMethod().getMethodName());
	}

}
