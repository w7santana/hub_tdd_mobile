package br.com.rsinet.hub_tdd_mobile.pages;

import static br.com.rsinet.hub_tdd_mobile.utility.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroPage extends BasePage {
	
	public  MobileElement campoApelido() throws Exception {
		return getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
	}
	
	public  MobileElement campoEmail() {
		return getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
	}
	
	public  MobileElement campoSenha() {
		return getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText\r\n");
	}
	
	public  MobileElement campoConfirmaSenha() {
		return getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText\r\n");
	}
	
	public  MobileElement campoNome() {
		return getDriver().findElementByXPath
		("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/android.widget.EditText");
	}
	
	public  MobileElement campoUltimoNome() {
		return getDriver().findElementByXPath
		("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/android.widget.EditText");
	}
	
	public  TouchAction scrollNoForm() {
		TouchAction scroll = new TouchAction(getDriver());
		return scroll.press(PointOption.point(1059, 1698)).moveTo(PointOption.point(1059, 300)).perform();
	}
	
	public  MobileElement campoTelefone() {
		return getDriver().findElementByXPath
		("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/android.widget.EditText");
	}
	
	public  MobileElement campoPais() {
		return getDriver().findElementById("com.Advantage.aShopping:id/linearLayoutCountry");
	}
	
	public void selecionaPais(String pais) {
		getDriver().findElementByAndroidUIAutomator
		("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ pais + "\").instance(0))").click();
	}
	
	public  MobileElement campoEstado() {
		return getDriver().findElementByXPath
				("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/android.widget.EditText");
	}
	
	public  MobileElement campoEndereco() {
		return getDriver().findElementByXPath
				("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/android.widget.EditText");
	}
	
	public  MobileElement campoCidade() {
		return getDriver().findElementByXPath
				("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/android.widget.EditText");
	}
	
	public  MobileElement campoCep() {
		return getDriver().findElementByXPath
				("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/android.widget.EditText");
	}
	
	public  MobileElement botaoParaRegistrar() {
		return getDriver().findElementById("com.Advantage.aShopping:id/buttonRegister");
	}

	public MobileElement lblMinimoCaracteresInvalido() {
		return retornarElemento(By.id("com.Advantage.aShopping:id/AosEditTextUserName"));
	}
	
}
