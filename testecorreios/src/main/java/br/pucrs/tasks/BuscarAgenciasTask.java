package br.pucrs.tasks;

import javax.xml.soap.SOAPElement;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
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
	
	public void selecionarMunicipioComboBoxJAVA() {
		
		Select municipio = new Select(this.buscarAgenciasAppObject.getMunicipioComboBox());
		municipio.selectByVisibleText("PORTO ALEGRE");
	}
	
	public void selecionarEstadoComboBox(int estado) throws InterruptedException {
		int x = 0;
		
		do {

			this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(300);
			x++;
			
		} while (x <= estado); // 23

		this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarMunicipioComboBox(int municipio) throws InterruptedException {
		int y = 0;
		
		do {
			this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ARROW_DOWN);
			y++;
			Thread.sleep(300);
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
