package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import br.pucrs.tasks.BuscarAgenciaPorLocalidadeTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorLocalidadeVerificationPoint {
	
	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorLocalidadeTask buscarAgenciaPorLocalidadeTask;
	
	
	public BuscarAgenciaPorLocalidadeVerificationPoint(WebDriver driver) {
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorLocalidadeTask = new BuscarAgenciaPorLocalidadeTask(driver);
	}
	
	public void checarBuscaporLocalidade() throws InterruptedException {
		
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		
		this.buscarAgenciaPorLocalidadeTask.selecionarBuscarAgenciaPorLocalidade();
		
		this.buscarAgenciaPorLocalidadeTask.selecionarEstado(22);
				
		this.buscarAgenciaPorLocalidadeTask.selecionarMunicipio(327);
		
		this.buscarAgenciaPorLocalidadeTask.selecionarBairro(11);
		
		Thread.sleep(4000);
	}
	
	

	
}
