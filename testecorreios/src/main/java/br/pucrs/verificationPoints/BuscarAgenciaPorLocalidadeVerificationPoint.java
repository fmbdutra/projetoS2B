package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.tasks.BuscarAgenciaPorLocalidadeTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorLocalidadeVerificationPoint {

	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorLocalidadeTask buscarAgenciaPorLocalidadeTask;

	public BuscarAgenciaPorLocalidadeVerificationPoint(WebDriver driver) {
		this.driver=driver;
		
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorLocalidadeTask = new BuscarAgenciaPorLocalidadeTask(driver);
	}

	public void checarBuscaporLocalidade() throws InterruptedException {

		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Entrou Na Página Inicial dos Correios");

		this.buscarAgenciaPorLocalidadeTask.selecionarBuscarAgenciaPorLocalidade();
		Report.log(Status.INFO, "Entrou na Página De 'Busca de Agências'");

		Report.log(Status.INFO, "Buscar Agências Por Localização Foi Selecionado");
		this.buscarAgenciaPorLocalidadeTask.selecionarEstado(22);

		Report.log(Status.INFO, "Selecionado Estado do Rio Grande do Sul");

		//this.buscarAgenciaPorLocalidadeTask.selecionarMunicipio(327);
		this.buscarAgenciasTask.selecionarMunicipioComboBoxJAVA();
		
		
		Report.log(Status.INFO, "Selecionado Municipio de Porto Alegre");

		this.buscarAgenciaPorLocalidadeTask.selecionarBairro(11);
		Report.log(Status.INFO, "Selecionado Bairro Cristo Redentor");

		this.buscarAgenciaPorLocalidadeTask.verificaExibiuAgencias();

		
		assertTrue(this.driver.getPageSource().contains("Bairro: Cristo Redentor"));

		Thread.sleep(4000);
	}

}
