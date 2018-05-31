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

	public void selecionarEstado(int estado) throws InterruptedException {
		this.buscarAgenciasTask.selecionarEstadoComboBox(estado);
	}

	public void selecionarMunicipio(int municipio) throws InterruptedException {
		this.buscarAgenciasTask.selecionarMunicipioComboBox(municipio);
	}
	
	public void verificaExibiuAgencias() {
		this.buscarAgenciasAppObject.getPrimeiroAgenciaDaBuscaLink().click();
	}


	public void selecionarBairro(int bairro) {
		this.buscarAgenciasTask.selecionarBairroComboBox(bairro);
	}
}


