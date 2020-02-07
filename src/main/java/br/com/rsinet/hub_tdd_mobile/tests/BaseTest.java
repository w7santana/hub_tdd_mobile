package br.com.rsinet.hub_tdd_mobile.tests;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;
import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.killDriver;

import java.io.IOException;
import java.util.Random;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd_mobile.utility.Report;


public class BaseTest {
	 static ExtentTest test;
	 static ExtentReports extent;
	
	@BeforeMethod
	public void setup() {
		getDriver();
		extent = Report.setExtent();
	}
	
	@AfterMethod
	public void tearDown() { 
		getDriver().resetApp();
	}

	@AfterClass
	public static void finalizaClasse(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		killDriver();
		
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