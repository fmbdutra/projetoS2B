package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class AumentaTamanhoDaLetraTask {

	private HomeAppObject homeAppObject;

	public AumentaTamanhoDaLetraTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);

	}

	public String apertarBotaoAumentar() {
		this.homeAppObject.getAumentaTextoButton().click();
		return this.homeAppObject.getFonteDoTexto().getCssValue("font-size");
	}
}
