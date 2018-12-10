package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class TamanhoDaLetraTask {

	private HomePage home;

	public TamanhoDaLetraTask(WebDriver driver) {
		this.home = new HomePage(driver);

	}

	public void apertarBotaoAumentar() {
		this.home.getAumentaTextoButton().click();
	}
	
	public void apertarBotaoDiminuir() {
		this.home.getDiminuiTextoButton().click();
	}
}
