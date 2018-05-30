package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorServicoTask {
	private BuscarAgenciasAppObject buscarAgenciasAppObject;

	public BuscarAgenciaPorServicoTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}
	
	public void selecionarServicoRadioButton() {
		this.buscarAgenciasAppObject.getServicoRadialButton().click();
	}

}
