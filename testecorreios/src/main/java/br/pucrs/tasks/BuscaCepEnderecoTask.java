package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class BuscaCepEnderecoTask {
	private HomeAppObject homeAppObject;
	
	public BuscaCepEnderecoTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}
	
	public void clicarInputBuscaCepEndereco() {
		this.homeAppObject.getBuscaCepEnderecoTextField().click();
	}
	
	public void preencherCepEnderecoInputText(String cepEndereco) {
		this.homeAppObject.getBuscaCepEnderecoTextField().sendKeys(cepEndereco);
	}
	
	public void clicarPesquisarCepEndercoButton() {
		this.homeAppObject.getPesquisarCepEnderecoBuscaButton().click();
	}
}
