package br.com.rsinet.hub_tdd_mobile.utility;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		htmlReporter.config().setDocumentTitle("Relatorio de Testes"); // Titulo do report
		htmlReporter.config().setReportName("Relatorio de Testes"); // Nome do report
		htmlReporter.config().setTheme(Theme.DARK); // Seleciona o tema

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Willian Santana");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;
	}

	/* Cria o Report */
	public static ExtentTest setUp(String report) {
		test = extent.createTest(report);
		return test;
	}

	/* Verifica se o teste passou, falhou ou pulou e tira screenshot */
	public static void tearDown(ITestResult result, ExtentTest test) throws IOException {
		String screenshotPath = Screenshot.tirar(result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); 
			test.addScreenCaptureFromPath(screenshotPath); 

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			test.addScreenCaptureFromPath(screenshotPath); 

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}
	
	/* Fecha o relatorio */
	public static void flushReport(ExtentReports extent) {
		extent.flush();
	}
}