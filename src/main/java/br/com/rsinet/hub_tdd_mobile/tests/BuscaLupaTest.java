package br.com.rsinet.hub_tdd_mobile.tests;

import org.junit.Assert;
import org.junit.Test;

import br.com.rsinet.hub_tdd_mobile.pages.HomePage;
import br.com.rsinet.hub_tdd_mobile.utility.Constant;
import br.com.rsinet.hub_tdd_mobile.utility.ExcelUtils;

public class BuscaLupaTest extends BaseTest{
	HomePage homePage = new HomePage();
	
	@Test
	public void deveBuscarProdutoPelaLupa() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String produtoExistente = ExcelUtils.getCellData(1,0);
		homePage.buscarNaLupa(produtoExistente);
				
		Assert.assertTrue(homePage.existeElementoPorTexto(produtoExistente));
	}
	
	@Test
	public void deveInformarSemResultados() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");
		String produtoInexistente = ExcelUtils.getCellData(1,1);
		homePage.buscarNaLupa(produtoInexistente);
		
		Assert.assertTrue(homePage.lblNoResults().isDisplayed());
		System.out.println(homePage.lblNoResults().getText());
		
	}
	
	
}
