package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class BuscaCepEnderecoTask {
	private HomeAppObject homeAppObject;
	
	public BuscaCepEnderecoTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}
	
	public void clicarInputBuscaCepEndereco() {
		this.homeAppObject.getBuscaCepEndereco().click();
	}
	
	public void preencherCepEnderecoInputText(String cepEndereco) {
		this.homeAppObject.getBuscaCepEndereco().sendKeys(cepEndereco);
	}
	
	public void clicarPesquisarCepEndercoButton() {
		this.homeAppObject.getPesquisarCepEnderecoBusca().click();
	}
}
