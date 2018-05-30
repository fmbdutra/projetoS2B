package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorLocalidadeTask {

	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private BuscarAgenciasTask buscarAgenciasTask;

	public BuscarAgenciaPorLocalidadeTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void selecionarBuscarAgenciaPorLocalidade() {
		this.buscarAgenciasAppObject.getLocalidadeRadialButton().click();
	}
	
	public void selecionarEstado() {
		this.buscarAgenciasTask.selecionarEstadoComboBox(23);
	}
	
	public void selecionarCidade() {
		this.buscarAgenciasTask.selecionarMunicipioComboBox(400);
	}
	
	public void selecionarBairro() {
		this.buscarAgenciasTask.selecionarBairroComboBox(3);
	}
	
	
}
