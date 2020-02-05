package br.com.rsinet.hub_tdd_mobile.pages;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;

import io.appium.java_client.MobileElement;

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
		System.out.println(produto);
		clicarPorTexto(produto);
	}

	public MobileElement lblProdutoEscolhido(String produto) {
		return getDriver().findElement(By.xpath("//*[@text='" + produto + "']"));
	}
	
	public MobileElement btnFiltro() {
		return getDriver().findElementById("com.Advantage.aShopping:id/imageViewFilter");
//		return getDriver().findElement(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Laptops\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
	}
	
	public void filtrarPor() {
		List<MobileElement> filtros = getDriver().findElementsByClassName("android.widget.TextView");
		for (MobileElement filtro:filtros) {
			System.out.println(filtro.getText());
		}
		filtros.get(4).click();
		
		clicar(By.xpath("//android.widget.LinearLayout//*[@text='BY COLOR']"));
	}

	public void filtroCustomization() {
		clicarPorTexto("BY CUSTOMIZATION");
	}
	
	public MobileElement filtro2_in_1() {
		return getDriver().findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout"));
	}
	
	public void filtroMemory() {
		clicarPorTexto("BY MEMORY");
	}
	
	public void mem16Gb() {
		clicarPorTexto("16GB DDR3 - 2 DIMM");
	}
	
	public MobileElement btnApplyFiltro() {
		return getDriver().findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
	}

}
