package br.com.rsinet.hub_tdd_mobile.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.rsinet.hub_tdd_mobile.pages.HomePage;
import br.com.rsinet.hub_tdd_mobile.utility.Constant;
import br.com.rsinet.hub_tdd_mobile.utility.ExcelUtils;

public class BuscaHomeTest extends BaseTest {
	HomePage homePage = new HomePage();

	@Test
	public void deveEncontrarProduto() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String categoria = ExcelUtils.getCellData(1,3);
		String produto = ExcelUtils.getCellData(1,4);

		homePage.clicaNaCategoria(categoria);
		homePage.escolheProdutoDaCategoria(produto);
		Assert.assertTrue(homePage.lblProdutoEscolhido(produto).isDisplayed());
	}
	
	@Test
	public void deveInformarProdutoNaoEncontrado() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String categoria = ExcelUtils.getCellData(1,3);
		homePage.clicaNaCategoria(categoria);
		Thread.sleep(3000);
		homePage.btnFiltro().click();
		homePage.filtroCustomization();		
		homePage.filtro2_in_1().click();
		homePage.filtroCustomization();		
		homePage.filtroMemory();
		homePage.mem16Gb();
		homePage.btnApplyFiltro().click();
		Assert.assertTrue(homePage.lblNoResults().isDisplayed());
	}
	
	
}
