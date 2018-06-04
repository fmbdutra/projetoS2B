package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscaCepEnderecoAppObject;


public class BuscaCepEnderecoTask {

	private BuscaCepEnderecoAppObject buscaCepEnderecoAppObject;

	public BuscaCepEnderecoTask(WebDriver driver) {

		this.buscaCepEnderecoAppObject = new BuscaCepEnderecoAppObject(driver);

	}

	public void preencherCepEnderecoInputText(String cepEndereco) {
		this.buscaCepEnderecoAppObject.getCepEnderecoInput().sendKeys(cepEndereco, Keys.ENTER);
	}
}
