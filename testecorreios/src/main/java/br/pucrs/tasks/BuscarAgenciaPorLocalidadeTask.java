package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorLocalidadeTask {

	private BuscarAgenciasAppObject buscarAgenciasAppObject;

	public BuscarAgenciaPorLocalidadeTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}

	public void selecionarBuscarAgenciaPorLocalidade() {
		this.buscarAgenciasAppObject.getLocalidadeRadialButton().click();
	}
}
