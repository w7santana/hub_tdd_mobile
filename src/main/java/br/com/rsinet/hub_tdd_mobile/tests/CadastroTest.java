package br.com.rsinet.hub_tdd_mobile.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd_mobile.pages.CadastroPage;
import br.com.rsinet.hub_tdd_mobile.pages.HomePage;
import br.com.rsinet.hub_tdd_mobile.pages.LoginPage;
import br.com.rsinet.hub_tdd_mobile.utility.ExcelUtils;
import br.com.rsinet.hub_tdd_mobile.utility.Report;

public class CadastroTest extends BaseTest {
	private HomePage homePage = new HomePage();
	private CadastroPage cadastroPage = new CadastroPage();
	private LoginPage loginPage = new LoginPage();
	
	@Test
	public void deveCadastrarUsuario() throws Exception {
		test = Report.setUp("deveCadastrarUsuario");
		ExcelUtils.setupMassa("Planilha1");
		
		homePage.menuLateral().click();
		homePage.btnLogin().click();
		loginPage.btnCriarConta().click();
		cadastroPage.campoApelido().click();
		cadastroPage.campoApelido().sendKeys(geraUsuario(10));
		cadastroPage.campoEmail().click();
		cadastroPage.campoEmail().sendKeys(ExcelUtils.email());
		cadastroPage.campoSenha().click();
		cadastroPage.campoSenha().sendKeys(ExcelUtils.senha());
		cadastroPage.campoConfirmaSenha().click();
		cadastroPage.campoConfirmaSenha().sendKeys(ExcelUtils.confirmSenha());
		cadastroPage.scrollDown(0.8, 0.2);
		cadastroPage.campoNome().click();
		cadastroPage.campoNome().sendKeys(ExcelUtils.primeiroNome());
		cadastroPage.campoUltimoNome().click();
		cadastroPage.campoUltimoNome().sendKeys(ExcelUtils.ultimoNome());
		cadastroPage.campoTelefone().click();
		cadastroPage.campoTelefone().sendKeys(ExcelUtils.phone());
		cadastroPage.campoPais().click();
		cadastroPage.selecionaPais(ExcelUtils.pais());
		cadastroPage.scrollDown(0.8, 0.2);
		cadastroPage.campoEstado().click();
		cadastroPage.campoEstado().sendKeys(ExcelUtils.estado());
		cadastroPage.campoEndereco().click();
		cadastroPage.campoEndereco().sendKeys(ExcelUtils.endereco());
		cadastroPage.campoCidade().click();
		cadastroPage.campoCidade().sendKeys(ExcelUtils.cidade());
		cadastroPage.campoCep().click();
		cadastroPage.campoCep().sendKeys(ExcelUtils.cep());
		cadastroPage.botaoParaRegistrar().click();
		homePage.menuLateral().click();
		
		Assert.assertNotNull(homePage.usuarioLogado().getText());
	}
	
	@Test
	public void deveNegarCadastro() throws Exception {
		test = Report.setUp("deveNegarCadastro");
		homePage.menuLateral().click();
		homePage.btnLogin().click();
		loginPage.btnCriarConta().click();
		cadastroPage.campoApelido().click();
		cadastroPage.campoApelido().sendKeys("joao");
		
		Assert.assertTrue(cadastroPage.lblMinimoCaracteresInvalido().isDisplayed());
	}
	
	
}
