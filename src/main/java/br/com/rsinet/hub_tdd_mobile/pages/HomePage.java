package br.com.rsinet.hub_tdd_mobile.pages;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class HomePage extends BasePage {

	public void buscarNaLupa(String texto) {
		escrever(By.id("com.Advantage.aShopping:id/editTextSearch"), texto);
		clicar(By.id("com.Advantage.aShopping:id/imageViewSearch"));
	}

	public MobileElement lblNoResults() {
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

	public MobileElement clicaNaCategoria(String categoria) {
		System.out.println(categoria);
		return obterElementoPorTexto(categoria);
	}

	public MobileElement escolheProdutoDaCategoria(String produto) {
		System.out.println(produto);
		return obterElementoPorTexto(produto);
	}

	public MobileElement lblProdutoEscolhido(String produto) {
		return getDriver().findElement(By.xpath("//*[@text='" + produto + "']"));
	}
	
	public MobileElement btnFiltro() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.Advantage.aShopping:id/gridViewProducts")));
		return getDriver().findElementById("com.Advantage.aShopping:id/imageViewFilter");
	}
	
	public void filtrarPor() {
		List<MobileElement> filtros = getDriver().findElementsByClassName("android.widget.TextView");
		for (MobileElement filtro:filtros) {
			System.out.println(filtro.getText());
		}
		filtros.get(4).click();
		
		clicar(By.xpath("//android.widget.LinearLayout//*[@text='BY COLOR']"));
	}
	
	
	public MobileElement filtroCustomization() {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(obterElementoPorTexto("BY CUSTOMIZATION")));
//		return obterElementoPorTexto("BY CUSTOMIZATION");
	}
	
	public MobileElement filtro2_in_1() {
		return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout"));
	}
	
	public MobileElement filtroMemory() {
		return obterElementoPorTexto("BY MEMORY");
	}
	
	public MobileElement mem16Gb() {
		return obterElementoPorTexto("16GB DDR3 - 2 DIMM");
	}
	
	public MobileElement btnApplyFiltro() {
		return getDriver().findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
	}

	public MobileElement menuLateral() {
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
	}

	public RemoteWebElement btnLogin() {
		return getDriver().findElementById("com.Advantage.aShopping:id/textViewMenuUser");
	}
	
	public MobileElement usuarioLogado() {
		return getDriver().findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
	}

}
