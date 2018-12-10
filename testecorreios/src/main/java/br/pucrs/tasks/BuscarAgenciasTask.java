package br.pucrs.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import br.pucrs.pageObject.BuscarAgenciasPage;
import br.pucrs.pageObject.HomePage;

public class BuscarAgenciasTask {

	private HomePage home;
	private BuscarAgenciasPage buscarAgencias;
	private WebDriver driver;

	public BuscarAgenciasTask(WebDriver driver) {
		this.driver = driver;
		this.home = new HomePage(driver);
		this.buscarAgencias = new BuscarAgenciasPage(driver);
	}

	public void apertarBotaoBuscarAgencia() {
		this.home.getBuscarAgenciaButton().click();
	}
	
	public void selecionarLocalidade() {
		this.buscarAgencias.getLocalidadeRadialButton().click();
	}

	public void selecionarProximidade() {
		this.buscarAgencias.getProximidadeRadialButton().click();
	}

	public void digitarLocalizacao(String endereco) {
		this.buscarAgencias.getEnderecoTextField().sendKeys(endereco);
	}

	public void pesquisarLocalizacao() {
		this.buscarAgencias.getPesquisarButton().click();
	}

	public boolean verificaCarregamentodoMapa() {
		return this.buscarAgencias.getCarregamentoImg().isDisplayed();
	}

	public void rolarPaginaParaVerificarResultado() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,200)");
	}

	public void selecionarEstado(String estado) {
		this.buscarAgencias.getEstadoComboBox().click();
		this.driver.findElement(By.xpath(estado)).click();
	}

	public void selecionarMunicipio(String municipio) {
		this.buscarAgencias.getMunicipioComboBox().click();
		;
		this.driver.findElement(By.xpath(municipio)).click();
	}

	public void selecionarBairro(String bairro) {
		this.buscarAgencias.getBairroComboBox().click();
		this.driver.findElement(By.xpath(bairro)).click();
	}

	public void selecionarHorario(String horario) {
		this.buscarAgencias.getHorarioComboBox().click();
		this.driver.findElement(By.xpath(horario)).click();
	}

	public void selecionarAtendimentoSabado() {
		this.buscarAgencias.getSabadoCheckBox().click();
	}

	public void selecionarAtendimentoDomingo() {
		this.buscarAgencias.getDomingoCheckBox().click();
	}

	public void selecionarAtendimentoBancoPostal() {
		this.buscarAgencias.getBancoPostalCheckBox().click();
	}

	public void selecionarAtendimentoPlantao() {
		this.buscarAgencias.getPlantaoCheckBox().click();
	}

	public void selecionarAtendimentoCertificadoDigital() {
		this.buscarAgencias.getCertificadoDigitalCheckBox().click();
	}

	public void clicarNoBody() {
		this.buscarAgencias.getTagBodyClick().click();
	}
	
	public void primeiroResultadoDaBusca() {
		this.buscarAgencias.getPrimeiroAgenciaDaBuscaLink().click();
	}
}