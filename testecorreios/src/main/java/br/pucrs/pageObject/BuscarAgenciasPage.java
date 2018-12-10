package br.pucrs.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarAgenciasPage {
	private WebDriver driver;

	public BuscarAgenciasPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHorarioComboBox() {
		return this.driver.findElement(By.id("selHorario"));
	}

	public WebElement getSabadoCheckBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"divServico\"]/div/fieldset[1]/label[1]"));
	}

	public WebElement getDomingoCheckBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"divServico\"]/div/fieldset[1]/label[2]"));
	}

	public WebElement getPlantaoCheckBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"divServico\"]/div/fieldset[1]/label[3]"));
	}

	public WebElement getBancoPostalCheckBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"divServico\"]/div/fieldset[1]/label[4]"));
	}

	public WebElement getCertificadoDigitalCheckBox() {
		return this.driver.findElement(By.xpath("//*[@id=\"divServico\"]/div/fieldset[1]/label[5]"));
	}

	public WebElement getProximidadeRadialButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[1]"));
	}

	public WebElement getServicoRadialButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[3]/label"));
	}

	public WebElement getEstadoComboBox() {
		return this.driver.findElement(By.id("estadoAgencia"));
	}

	public WebElement getMunicipioComboBox() {
		return this.driver.findElement(By.id("municipioAgencia"));
	}

	public WebElement getBairroComboBox() {
		return this.driver.findElement(By.id("bairroAgencia"));
	}

	public WebElement getPesquisarButton() {
		return this.driver.findElement(By.id("submit"));
	}

	public WebElement getEnderecoTextField() {
		return this.driver.findElement(By.id("cepEndereco"));
	}

	public WebElement getLocalizacaoAgenciaMap() {
		return this.driver.findElement(By.cssSelector("map > div > div > div:nth-child(2) > a > div > img"));
	}

	public WebElement getCarregamentoImg() {
		return this.driver.findElement(By.id("imgPesquisaMap"));
	}

	public WebElement getLocalidadeRadialButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[2]"));
	}

	public WebElement getPrimeiroAgenciaDaBuscaLink() {
		return this.driver.findElement(By.xpath("//*[@id=\"tableNomeAgencia\"]/tbody/tr/td[1]/a"));
	}

	public WebElement getTagBodyClick() {
		return this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div"));
	}
	
	public List<WebElement> getTabelaDeBusca() {
		return this.driver.findElements(By.xpath("//*[@id=\"tableNomeAgencia\"]/tbody/tr/td[1]/a"));
	}

}