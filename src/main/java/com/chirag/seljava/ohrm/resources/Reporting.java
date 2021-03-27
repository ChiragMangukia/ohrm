package com.chirag.seljava.ohrm.resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	

	@Override
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Test-Report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter("C:\\Automation\\Utility\\ExtentReports\\" + repName);// specify location
																									// of
																									// the report

		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Chirag Mangukia");

		htmlReporter.config().setDocumentTitle("Automation Demo Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD); // theme type of the report
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
		// information to the report with GREEN color highlighted
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
		// to the report with GREEN color highlighted

		String screenshotPath = "C:\\Automation\\Utility\\Screenshots\\" + tr.getName() +
				new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

		try {
			Base base = new Base();
			base.getScreenshot(screenshotPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		File file = new File(screenshotPath + ".png");

		if (file.exists()) {
			try {
				logger.fail(tr.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath + ".png").build());
				//logger.fail("Screenshot:" + logger.addScreenCaptureFromPath(screenshotPath + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}