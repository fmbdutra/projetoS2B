package br.pucrs.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.appObject.HomeAppObject;

public class BuscarAgenciasTask {

	private HomeAppObject homeAppObject;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private WebDriver driver;
	
	public BuscarAgenciasTask(WebDriver driver) {
		this.driver = driver;
		this.homeAppObject = new HomeAppObject(driver);
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}

	public void apertarBotaoBuscarAgencia() {
		this.homeAppObject.getBuscarAgencia().click();
	}	
	
	public void selecionarProximidadeRadialButton () {
		this.buscarAgenciasAppObject.getProximidadeRadialButton().click();
	}

	public void digitarLocalizacao(String endereco) {
		this.buscarAgenciasAppObject.getEnderecoTextField().sendKeys(endereco);		
	}
	
	public void pesquisarLocalizacao() {
		this.buscarAgenciasAppObject.getPesquisarButton().click();
	}
	
	public boolean verificaCarregamentodoMapa() {
		return this.buscarAgenciasAppObject.getCarregamentoImg().isDisplayed();			
	}
	
	public void rolarPaginaParaVerificarResultado() {
		
	/*				
		for(int x=1;x<=10;x++)
		{
			this.buscarAgenciasAppObject.getPesquisarButton().sendKeys(Keys.ARROW_DOWN);
		} 
	*/
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,200)");
	}

	public void selecionarEstadoComboBox(String estado) {
		this.buscarAgenciasAppObject.getEstadoComboBox().click();
		this.driver.findElement(By.xpath(estado)).click();
	}

	public void selecionarMunicipioComboBox(String municipio) {
		this.buscarAgenciasAppObject.getMunicipioComboBox().click();
		;
		this.driver.findElement(By.xpath(municipio)).click();
	}

	public void selecionarBairroComboBox(String bairro) {
		this.buscarAgenciasAppObject.getBairroComboBox().click();
		this.driver.findElement(By.xpath(bairro)).click();
	}

	public void selecionarHorario(String horario) {
		this.buscarAgenciasAppObject.getHorarioComboBox().click();
		this.driver.findElement(By.xpath(horario)).click();
	}
	
	public void selecionarAtendimentoSabado() {
		this.buscarAgenciasAppObject.getSabadoCheckBox().click();
	}

	public void selecionarAtendimentoDomingo() {
		this.buscarAgenciasAppObject.getDomingoCheckBox().click();
	}

	public void selecionarAtendimentoBancoPostal() {
		this.buscarAgenciasAppObject.getBancoPostalCheckBox().click();
	}

	public void selecionarAtendimentoPlantao() {
		this.buscarAgenciasAppObject.getPlantaoCheckBox().click();
	}

	public void selecionarAtendimentoCertificadoDigital() {
		this.buscarAgenciasAppObject.getCertificadoDigitalCheckBox().click();
	}
	
	public void clicarNoBody() {
		this.buscarAgenciasAppObject.getTagBodyClick().click();
	}
}