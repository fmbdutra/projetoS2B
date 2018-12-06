package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class ContrasteTask {

	private HomeAppObject homeAppObject;
	private BuscarAgenciasTask buscarAgenciasTask;

	public ContrasteTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void apertaBotãoContraste() {
		this.homeAppObject.getContrasteButton().click();
	}

	public void irParaOpcoes() {
		this.homeAppObject.getOpcoesHomeHtml().click();
		this.homeAppObject.getOpcoesHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaSolucoesQueAproximam() {
		this.homeAppObject.getSolucoesQueAproximamHtml().click();
		this.homeAppObject.getSolucoesQueAproximamHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaFinalPagina() {
		this.homeAppObject.getParteFinalHomeHtml().click();
		this.homeAppObject.getParteFinalHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void irParaRodape() {
		this.homeAppObject.getRodapeHomeHtml().click();
		this.homeAppObject.getRodapeHomeHtml().sendKeys(Keys.ARROW_DOWN);
	}

	public void percorrePagina() {
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
	}

}
