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
	
/*
	public void selecionarEstadoComboBox() {
		this.buscarAgenciasAppObject.getEstadoComboBox();
	}

	public void selecionarMunicipioComboBox() {
		this.buscarAgenciasAppObject.getMunicipioComboBox();
	}

	public void selecionarBairroComboBox() {
		this.buscarAgenciasAppObject.getBairroComboBox();
	}
	*/
		

	public void selecionarEstadoComboBox(int estado) throws InterruptedException {
		int x = 0;
		
		//this.buscarAgenciasAppObject.getEstadoComboBox().click();
		
		do {

			this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(100);
			x++;
			
		} while (x <= estado); // 23

		this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarMunicipioComboBox(int municipio) {
		int y = 0;
		
		//this.buscarAgenciasAppObject.getMunicipioComboBox().click();
		
		do {
			this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ARROW_DOWN);
			y++;		
		} while (y < municipio); // 400
		
		this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarBairroComboBox(int bairro) {
		int z = 0;
		
		//this.buscarAgenciasAppObject.getBairroComboBox().click();
		
		do {

			this.buscarAgenciasAppObject.getBairroComboBox().sendKeys(Keys.ARROW_DOWN);
			z++;
		} while (z == bairro);

		this.buscarAgenciasAppObject.getBairroComboBox().sendKeys(Keys.ENTER);
	}

}
