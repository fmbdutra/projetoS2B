package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class DiminuiTamanhoDaLetraTask {

	private HomePage home;

	public DiminuiTamanhoDaLetraTask(WebDriver driver) {
		this.home = new HomePage(driver);
	}

	public void apertarBotaoDiminuir() {
		this.home.getDiminuiTextoButton().click();
	}
}
