package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class VerificaIdiomaInglesTask {

	private HomePage home;

	public VerificaIdiomaInglesTask(WebDriver driver) {
		this.home = new HomePage(driver);
	}

	public void apertarBotaoEnglish() {
		this.home.getEnglishButton().click();
	}
}
