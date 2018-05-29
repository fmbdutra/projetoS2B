package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class BuscarAgenciasTask {

	private HomeAppObject homeAppObject;

	public BuscarAgenciasTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
		
	}

	public void apertarBotaoBuscarAgencia() {
		this.homeAppObject.getBuscarAgencia().click();
	}

}
