package com.chirag.seljava.ohrm.resources;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.tesults.tesults.Results;

public class TesultListener extends TestListenerAdapter {
	
	List<Map<String, Object>> testCases = new ArrayList<Map<String, Object>>();
	Base base = new Base();
	
	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	public static Object[] getTestParams(ITestResult iTestResult) {
		return iTestResult.getParameters();
	}
	
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("I am in onTestStart method " + getTestMethodName(result) + " start");

	}
	
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "pass");
		testCase.put("params", getTestParams(iTestResult));
		testCases.add(testCase);
	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "fail");
		testCase.put("params", getTestParams(iTestResult));
		List<String> files = new ArrayList<String>();
		String screenshotPath = "C:\\Automation\\Utility\\Screenshots\\" +
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		try {
			files.add(base.getScreenshot1(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		testCase.put("files", files);
		testCases.add(testCase);
	}
	
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "fail");
		testCase.put("params", getTestParams(iTestResult));
		List<String> files = new ArrayList<String>();
		String screenshotPath = "C:\\Automation\\Utility\\Screenshots\\" + "NEW" +
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		try {
			files.add(base.getScreenshot1(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testCase.put("files", files);

		testCases.add(testCase);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onFinish(ITestContext iTestContext) {
		// Map<String, Object> to hold your test results data.
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("target","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjVlMjZkN2U1LTk1MTAtNGY2YS05YWQ5LTMyYmQ0YjI0MzFlNS0xNTk5MDM3NTI0NTg1IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiYWJjNmM0ZTktODQ5Yi00MTk3LWI1ZjctYmU0YThkYjUzMDhlIiwidHlwZSI6InQifQ.ORQWx4Y5tVkN1qgIPeyPNsFCEqtjj9ndoB9FJ4OmzQM");

		Map<String, Object> results = new HashMap<String, Object>();
		results.put("cases", testCases);
		data.put("results", results);

		// Upload
		Map<String, Object> response = Results.upload(data);
		System.out.println("success: " + response.get("success"));
		System.out.println("message: " + response.get("message"));
		System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
		System.out.println("errors: " + ((List<String>) response.get("errors")).size());
	}

}
