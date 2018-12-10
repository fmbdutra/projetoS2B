package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class VerificaIdiomaInglesTask {

	private HomeAppObject homeAppObject;

	public VerificaIdiomaInglesTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void apertarBotaoEnglish() {
		this.homeAppObject.getEnglishButton().click();
	}
}
