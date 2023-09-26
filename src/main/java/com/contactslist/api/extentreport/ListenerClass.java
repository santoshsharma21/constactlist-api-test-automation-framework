/**
 * 
 */
package com.contactslist.api.extentreport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportManager implements ITestListener {
	
	@Override
	public void onStart(ITestContext context) {
		ReportManager.initReporter();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extentReports.createTest(result.getName());
		test.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String throwableMsg = result.getThrowable().getMessage().replaceAll(",", "<br>");
			String formatedMsg = "<details> <summary> Show Throwable </summary>" + throwableMsg + "</details>";
			
			try {
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
				test.fail(MarkupHelper.createLabel(formatedMsg, ExtentColor.RED));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		ReportManager.endReporter();
	}	
}
