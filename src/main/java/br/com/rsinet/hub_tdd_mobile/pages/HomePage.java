package br.com.rsinet.hub_tdd_mobile.pages;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd_mobile.utility.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

public class HomePage extends BasePage {
	
	public void buscarNaLupa(String texto) {
		escrever(By.id("com.Advantage.aShopping:id/editTextSearch"), texto);
		clicar(By.id("com.Advantage.aShopping:id/imageViewSearch"));
	}
	
	public MobileElement lblNoResults() {
//		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")));
		return getDriver().findElement(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow"));
	}
	
	public void listaCategoriasVisiveisNaTela() {
//		List<MobileElement> categorias = getDriver().findElements(By.id("com.Advantage.aShopping:id/textViewCategory"));
//		for (MobileElement categoria:categorias) {
//			System.out.println(categoria.getText());
//		}
//		System.out.println();
	}

	public void clicaNaCategoria(String categoria) {
		clicarPorTexto(categoria);
		System.out.println(categoria);
	}
	
	public void escolheProdutoDaCategoria(String produto) {
		clicarPorTexto(produto);
		System.out.println(produto);
	}
	
	public boolean lblProdutoEscolhido(String produto) {
		return existeElementoPorTexto(produto);
	}
	
	
}
