package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class VerificaIdiomaEspanholTask {
	private HomeAppObject homeAppObject;

	public VerificaIdiomaEspanholTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void apertarBotaoEspanhol() {
		this.homeAppObject.getEspanholButton().click();
	}
}
