package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import br.pucrs.tasks.BuscarAgenciasTask;
import br.pucrs.tasks.BuscarAgenciaPorLocalidadeTask;

public class BuscarAgenciaPorLocalidadeVerificationPoint {
	
	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorLocalidadeTask buscarAgenciaPorLocalidadeTask;

	public BuscarAgenciaPorLocalidadeVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorLocalidadeTask = new BuscarAgenciaPorLocalidadeTask(driver);
	}

	
}
