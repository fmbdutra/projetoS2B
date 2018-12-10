package br.pucrs.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFonteDoTextoHtml() {
		WebElement tamanhoFonte = this.driver
				.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/ul/li[1]/a"));
		return tamanhoFonte;
	}

	public WebElement getAumentaTextoButton() {
		return this.driver.findElement(By.id("txt-aumenta1"));
	}

	public WebElement getDiminuiTextoButton() {
		return this.driver.findElement(By.id("txt-diminuir1"));
	}

	public WebElement getEnglishButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"list-idiomas\"]/ul/li[1]/a"));
	}

	public WebElement getEspanholButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"list-idiomas\"]/ul/li[2]/a"));
	}

	public WebElement getTrackAndTrace() {
		return this.driver.findElement(By.xpath("//*[@id=\"rastreamento-obj\"]/form/div[1]/label/strong"));
	}

	public WebElement getBuscarAgenciaButton() {
		return this.driver.findElement(By.cssSelector("#content-servicos > ul > li:nth-child(5) > div.acao > a"));
	}

	public WebElement getContrasteButton() {
		return this.driver.findElement(By.id("txt-contraste"));
	}

	public WebElement getCorCabecalhoHtml() {
		return this.driver.findElement(By.id("portal-top"));
	}

	public WebElement getCorOpcoesHtml() {
		return this.driver.findElement(By.id("content-core-mid"));
	}

	public WebElement getCorSolucoesHtml() {
		return this.driver.findElement(By.id("content-core-mid-bot"));
	}

	public WebElement getCorFimHtml() {
		return this.driver.findElement(By.id("content-core-bot"));
	}

	public WebElement getCorRodapeHtml() {
		return this.driver.findElement(By.id("portal-footer-wrapper"));
	}

	public WebElement getBuscaCepEnderecoTextField() {
		return this.driver.findElement(By.id("acesso-busca"));
	}

	public WebElement getPesquisarCepEnderecoBuscaButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"content-servicos\"]/ul/li[2]/form/div[2]/input[2]"));
	}

	public WebElement getOpcoesHomeHtml() {
		return this.driver.findElement(By.xpath("//*[@id=\"rastreamento-obj\"]/form/div[1]"));
	}

	public WebElement getSolucoesQueAproximamHtml() {
		return this.driver.findElement(By.xpath("//*[@id=\"titulo-destaque\"]/span"));
	}

	public WebElement getParteFinalHomeHtml() {
		return this.driver.findElement(By.xpath("//*[@id=\"titulo-destaque\"]/span"));
	}

	public WebElement getRodapeHomeHtml() {
		return this.driver.findElement(By.xpath("//*[@id=\"titulo-destaque\"]/span"));
	}
}