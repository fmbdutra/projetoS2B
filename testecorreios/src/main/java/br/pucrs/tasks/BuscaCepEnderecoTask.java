package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.BuscaCepEnderecoPage;


public class BuscaCepEnderecoTask {

	private BuscaCepEnderecoPage buscaCepEndereco;

	public BuscaCepEnderecoTask(WebDriver driver) {

		this.buscaCepEndereco = new BuscaCepEnderecoPage(driver);

	}

	public void preencherCepEnderecoInputText(String cepEndereco) {
		this.buscaCepEndereco.getCepEnderecoInput().sendKeys(cepEndereco, Keys.ENTER);
	}
}
