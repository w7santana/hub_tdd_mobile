package br.com.rsinet.hub_tdd_mobile.tests;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;
import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.killDriver;

import java.io.IOException;
import java.util.Random;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd_mobile.utility.Report;


public class BaseTest {
	 protected static ExtentTest test;
	 protected ExtentReports extent;
	 
	@BeforeSuite
	public void beforeSuite() {
		extent = Report.setExtent();
	}
	
	@BeforeMethod
	public void setup() {
		getDriver();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException { 
		Report.tearDown(result, test);
		getDriver().resetApp();
	}

	@AfterClass
	public static void finalizaClasse() throws IOException {
		killDriver();
	}
	
	@AfterSuite
	public void afterSuite() {
		Report.flushReport(extent);
	}
	
	
	

	public String geraUsuario(int qtdCaracteres) {
		Random quantidadedeletras = new Random();
		int index;

		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";

		for (int i = 0; i <= qtdCaracteres - 1; i++) {
			index = quantidadedeletras.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}
}