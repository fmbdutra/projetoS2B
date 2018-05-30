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
	
	public void selecionarEstado(String estado) {
		this.buscarAgenciasTask.selecionarEstadoComboBox(estado);
	}
	
	public void selecionarCidade(String cidade) {
		this.buscarAgenciasTask.selecionarMunicipioComboBox(cidade);
	}
	
	public void selecionarBairro(String bairro) {
		this.buscarAgenciasTask.selecionarBairroComboBox(bairro);
	}
	
	
	
	
}
