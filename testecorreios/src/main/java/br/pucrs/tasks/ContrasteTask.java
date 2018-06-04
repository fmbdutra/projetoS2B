package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class ContrasteTask {

	private HomeAppObject homeAppObject;

	public ContrasteTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void apertaBotãoContraste() {
		this.homeAppObject.getContrasteButton().click();
	}

	public String verificaFundoCabecalho() {
		return this.homeAppObject.getCorCabecalhoHtml().getCssValue("background-color");
	}

	public String verificaTextoCabecalho() {
		return this.homeAppObject.getCorCabecalhoHtml().getCssValue("color");
	}

	/*
	 * public String verificaFundoBanner() { return
	 * this.homeAppObject.getCorBannerHtml().getCssValue("backgroud-color"); }
	 */
	/*
	 * public String verificaTextoBanner() { return
	 * this.homeAppObject.getCorBannerHtml().getCssValue("color"); }
	 */

	public String verificaFundoOpcoes() {
		return this.homeAppObject.getCorOpcoesHtml().getCssValue("backgroud-color");
	}

	public String verificaTextoOpcoes() {
		return this.homeAppObject.getCorOpcoesHtml().getCssValue("color");
	}

	public String verificaFundoSolucoes() {
		return this.homeAppObject.getCorSolucoesHtml().getCssValue("backgroud-color");
	}

	public String verificaTextoSolucoes() {
		return this.homeAppObject.getCorOpcoesHtml().getCssValue("color");
	}
	
	public String verificaFundoFim() {
		return this.homeAppObject.getCorFimHtml().getCssValue("backgroud-color");
	}
	
	public String verificaTextoFim() {
		return this.homeAppObject.getCorFimHtml().getCssValue("color");
	}

	public String verificaFundoRodape() {
		return this.homeAppObject.getCorRodapeHtml().getCssValue("background-color");
	}

	public String verificaTextoRodape() {
		return this.homeAppObject.getCorRodapeHtml().getCssValue("color");
	}

}
