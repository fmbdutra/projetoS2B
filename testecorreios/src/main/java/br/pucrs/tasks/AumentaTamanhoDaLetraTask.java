package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class AumentaTamanhoDaLetraTask {

	private HomePage home;

	public AumentaTamanhoDaLetraTask(WebDriver driver) {
		this.home = new HomePage(driver);

	}

	public void apertarBotaoAumentar() {
		this.home.getAumentaTextoButton().click();
	}
}
