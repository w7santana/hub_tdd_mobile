package br.com.rsinet.hub_tdd_mobile.test;


import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import br.com.rsinet.hub_tdd_mobile.utility.DriverFactory;
import io.appium.java_client.MobileElement;

public class EncontraProdutoTest {

	@Test
	public void deveEncontrarProduto() throws MalformedURLException, Exception {
		DriverFactory.getDriver();
		//buscando elementos visiveis da pagina inicial
		List<MobileElement> categorias = DriverFactory.getDriver().findElements(By.id("com.Advantage.aShopping:id/textViewCategory"));
		for (MobileElement categoria:categorias) {
			System.out.println(categoria.getText());
		}
		System.out.println();
		categorias.get(1).click();

		List<MobileElement> headPhones = DriverFactory.getDriver().findElements(By.id("com.Advantage.aShopping:id/textViewProductName"));
		for (MobileElement headPhone:headPhones) {
			System.out.println(headPhone.getText());
		}
		System.out.println();
		
		MobileElement produtoEscolhido = headPhones.get(0);
		produtoEscolhido.click();
		String lblProduto = DriverFactory.getDriver().findElement(By.className("android.widget.TextView")).getText();
		System.out.println(lblProduto);
		
		assertTrue(lblProduto.startsWith("BEATS STUDIO 2"));
		DriverFactory.killDriver();
	}
	
	public void deveInformarProdutoInexistente() {
	}
	
	
}
