package br.com.rsinet.hub_tdd_mobile.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd_mobile.pages.HomePage;
import br.com.rsinet.hub_tdd_mobile.utility.ExcelUtils;
import br.com.rsinet.hub_tdd_mobile.utility.Report;

public class BuscaLupaTest extends BaseTest{
	HomePage homePage = new HomePage();
	
	@Test
	public void deveBuscarProdutoPelaLupa() throws Exception {
		test = Report.setUp("deveBuscarProdutoPelaLupa");
		ExcelUtils.setupMassa("Planilha2");
		String produtoExistente = ExcelUtils.getCellData(1,0);
		homePage.buscarNaLupa(produtoExistente);
				
		Assert.assertTrue(homePage.existeElementoPorTexto(produtoExistente));
	}
	
	@Test
	public void deveInformarSemResultados() throws Exception {
		test = Report.setUp("deveInformarSemResultados");
		ExcelUtils.setupMassa("Planilha2");

		String produtoInexistente = ExcelUtils.getCellData(1,1);
		homePage.buscarNaLupa(produtoInexistente);
		
		Assert.assertTrue(homePage.lblNoResults().isDisplayed());
		System.out.println(homePage.lblNoResults().getText());
		
	}
	
	
}
