package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class DiminuiTamanhoDaLetraTask {

	private HomeAppObject homeAppObject;
	public DiminuiTamanhoDaLetraTask (WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}
	
	public String apertarBotaoDiminuir() {
		this.homeAppObject.getDiminuiTextoButton().click();
		return this.homeAppObject.getFonteDoTexto().getCssValue("font-size");
	}
}
