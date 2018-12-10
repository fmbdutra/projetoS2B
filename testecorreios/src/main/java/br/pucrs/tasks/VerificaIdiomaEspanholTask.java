package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class VerificaIdiomaEspanholTask {
	private HomePage home;

	public VerificaIdiomaEspanholTask(WebDriver driver) {
		this.home = new HomePage(driver);
	}

	public void apertarBotaoEspanhol() {
		this.home.getEspanholButton().click();
	}
}
