package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.appObject.HomeAppObject;

public class BuscarAgenciasTask {

	private HomeAppObject homeAppObject;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;

	public BuscarAgenciasTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}
	
	public void apertarBotaoBuscarAgencia() {
		this.homeAppObject.getBuscarAgencia().click();
	}

	public void selecionarEstadoComboBox(int estado) {
		int x = 0;
		do {
			this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ARROW_DOWN);
			x++;
		} while (x == estado); //23
		this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarMunicipioComboBox(int municipio) {
		int y = 0;
		do {
			this.buscarAgenciasAppObject.getMunicipioComboBox();
			y++;
		} while (y == municipio); //400
		this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarBairroComboBox(int bairro) {
		int z = 0;
		do {
			this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ENTER);
			z++;
		} while (z == bairro);
		this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ENTER);
	}
}
