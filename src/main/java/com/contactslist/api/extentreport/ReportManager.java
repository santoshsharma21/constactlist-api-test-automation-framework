/**
 * 
 */
package com.contactslist.api.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

/**
 * @author Santosh Sharma
 *
 */
public class ReportManager {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	
	
	public static void initReporter() {
		
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String fName = "Test-Report_" + dt + "_.html";
		String destPath = System.getProperty("user.dir") + "/reports/" + fName;
		
		sparkReporter = new ExtentSparkReporter(destPath);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Test Execution Report");
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.TEST, ViewName.DASHBOARD ,
				ViewName.CATEGORY, ViewName.DEVICE, ViewName.LOG, ViewName.EXCEPTION, ViewName.AUTHOR}).apply();
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Project", "Contacts List Api Automation Testing");
		extentReports.setSystemInfo("Java", System.getProperty("java.version"));
	}
	
	public static void endReporter() {
		extentReports.flush();
	}
}
