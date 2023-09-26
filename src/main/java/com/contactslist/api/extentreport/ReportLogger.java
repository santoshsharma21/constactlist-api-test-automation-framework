/**
 * 
 */
package com.contactslist.api.extentreport;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

/**
 * @author Santosh Sharma
 *
 */
public class ReportLogger {
	
	// will log text in report
	public static void logText(String txt) {
		ReportManager.test.info(MarkupHelper.createLabel(txt, ExtentColor.TRANSPARENT));
	}
	
	// will log JSON in report
	public static void logJson(String jsonAsString) {
		ReportManager.test.info(MarkupHelper.createCodeBlock(jsonAsString, CodeLanguage.JSON));
	}
}
