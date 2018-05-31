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

		String 	estado    = "RIO GRANDE DO SUL", 
				municipio = "PORTO ALEGRE", 
				bairro    = "CRISTO REDENTOR                         ";
		
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Entrou Na Página Inicial dos Correios");

		this.buscarAgenciaPorLocalidadeTask.selecionarBuscarAgenciaPorLocalidade();
		Report.log(Status.INFO, "Entrou na Página De 'Busca de Agências'");

		Report.log(Status.INFO, "Buscar Agências Por Localização Foi Selecionado");
		this.buscarAgenciaPorLocalidadeTask.selecionarEstado(estado);
		
		Thread.sleep(1000);
		
		Report.log(Status.INFO, "Selecionado Estado "+estado);

		
		this.buscarAgenciaPorLocalidadeTask.selecionarMunicipio(municipio);
			
		
		Report.log(Status.INFO, "Selecionado Município de "+municipio);

		Thread.sleep(1000);
		this.buscarAgenciaPorLocalidadeTask.selecionarBairro(9);
		Report.log(Status.INFO, "Selecionado Bairro "+bairro);

		
		Thread.sleep(3000);
		
		this.buscarAgenciaPorLocalidadeTask.verificaExibiuAgencias();
		
		Thread.sleep(2600);
		
		
		assertTrue(this.driver.getPageSource().contains("Bairro: Cristo Redentor"));

		Thread.sleep(4000);
	}

}
