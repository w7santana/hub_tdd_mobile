package br.com.rsinet.hub_tdd_mobile.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd_mobile.pages.HomePage;
import br.com.rsinet.hub_tdd_mobile.utility.Constant;
import br.com.rsinet.hub_tdd_mobile.utility.ExcelUtils;
import br.com.rsinet.hub_tdd_mobile.utility.Report;

public class BuscaHomeTest extends BaseTest {
	HomePage homePage = new HomePage();

	@Test
	public void deveEncontrarProduto() throws Exception {
		test = Report.setUp("deveEncontrarProduto");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String categoria = ExcelUtils.getCellData(1,3);
		String produto = ExcelUtils.getCellData(1,4);

		homePage.clicaNaCategoria(categoria).click();;
		homePage.escolheProdutoDaCategoria(produto).click();
		Assert.assertTrue(homePage.lblProdutoEscolhido(produto).isDisplayed());
	}
	
	@Test
	public void deveInformarProdutoNaoEncontrado() throws Exception {
		test = Report.setUp("deveInformarProdutoNaoEncontrado");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String categoria = ExcelUtils.getCellData(1,3);
		homePage.clicaNaCategoria(categoria).click();
		
		Thread.sleep(2000);
		
		homePage.btnFiltro().click();
		homePage.filtroCustomization().click();		
		homePage.filtro2_in_1().click();
		homePage.filtroCustomization().click();		
		homePage.filtroMemory().click();
		homePage.mem16Gb().click();
		homePage.btnApplyFiltro().click();
		Assert.assertTrue(homePage.lblNoResults().isDisplayed());
	}
	
	
}
