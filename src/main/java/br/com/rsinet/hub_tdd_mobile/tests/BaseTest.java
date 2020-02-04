package br.com.rsinet.hub_tdd_mobile.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import br.com.rsinet.hub_tdd_mobile.utility.DriverFactory;

public class BaseTest {
	@Before
	public void setup() {
		DriverFactory.getDriver();
	}
	
	@AfterClass
	public static void finalizaClasse() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() { 
		DriverFactory.getDriver().resetApp();
	}
	
}