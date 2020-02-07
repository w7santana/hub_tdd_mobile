package br.com.rsinet.hub_tdd_mobile.pages;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.SingleTapAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	private TouchAction action;
	protected WebDriverWait wait = new WebDriverWait(getDriver(), 10);


	public void tap(int x, int y) {
		action = new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
	}
	
	public void interageSeekBar(By by, double posicao) {
		MobileElement seekBar = getDriver().findElement(by);
		
		int y = seekBar.getLocation().y + (seekBar.getSize().height / 2); //Y inicial
		int x = (int) (seekBar.getLocation().x + (seekBar.getSize().height * posicao));

		System.out.println("Clicou na coordenada Y:" + y + "* X:" + x);
		tap(x, y);
	}
	
	public void cliqueLongo(By by) {
//		action = new TouchAction(getDriver()).longPress(getDriver().findElement(by)).perform();
	}
	
	public void scrollDown(double inicio, double fim) {
		
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width / 2;
		
		int yInicial = (int) (size.height * inicio);
		int yFinal = (int) (size.height * fim);
		
		new TouchAction(getDriver())
		.press(PointOption.point(x, yInicial))
		.waitAction()
		.moveTo(PointOption.point(x, yFinal))
		.release().perform();
	}
	
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public MobileElement retornarElemento(By by) {
		return getDriver().findElement(by);
	}
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public MobileElement obterElementoPorTexto(String texto) {
		return getDriver().findElement(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}
	
	
}