package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class VerificaIdiomaTask {

	private HomePage home;

	public VerificaIdiomaTask(WebDriver driver) {
		this.home = new HomePage(driver);
	}

	public void apertarBotaoEnglish() {
		this.home.getEnglishButton().click();
	}
	
	public void apertarBotaoEspanhol() {
		this.home.getEspanholButton().click();
	}
}
