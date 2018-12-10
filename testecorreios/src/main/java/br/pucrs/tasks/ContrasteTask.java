package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.HomePage;

public class ContrasteTask {

	private HomePage home;
	private BuscarAgenciasTask buscarAgenciasTask;

	public ContrasteTask(WebDriver driver) {
		this.home = new HomePage(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void apertaBotãoContraste() {
		this.home.getContrasteButton().click();
	}

	public void irParaOpcoes() {
		this.home.getOpcoesHomeHtml().click();
		this.home.getOpcoesHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaSolucoesQueAproximam() {
		this.home.getSolucoesQueAproximamHtml().click();
		this.home.getSolucoesQueAproximamHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaFinalPagina() {
		this.home.getParteFinalHomeHtml().click();
		this.home.getParteFinalHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaRodape() {
		this.home.getRodapeHomeHtml().click();
		this.home.getRodapeHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void percorrePagina() {
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
	}

}
