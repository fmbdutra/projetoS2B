package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
	//---- Selecionando por Java
	public void selecionarEstadoComboBoxJs(String estado) {

		Select uf = new Select(this.buscarAgenciasAppObject.getEstadoComboBox());
		uf.selectByVisibleText(estado);
	}
	
	public void selecionarMunicipioComboBoxJs(String municipio) {
		
		Select munic = new Select(this.buscarAgenciasAppObject.getMunicipioComboBox());
		munic.selectByVisibleText(municipio);
	}
	
	public void selecionarBairroComboBoxJs(String bairro) {
		
		Select bair = new Select(this.buscarAgenciasAppObject.getMunicipioComboBox());
		bair.selectByVisibleText(bairro);
	}
	
	//---Selecionando por teclas
	public void selecionarEstadoComboBox(int estado) throws InterruptedException {
		int x = 0;
		
		do {

			this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(300);
			x++;
			
		} while (x == estado); // RS=23

		this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarMunicipioComboBox(int municipio) throws InterruptedException {
		int y = 0;
		
		do {
			this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ARROW_DOWN);
			y++;
			Thread.sleep(300);
		} while (y == municipio); // 400
		
		this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(Keys.ENTER);
	}

	public void selecionarBairroComboBox(int bairro) throws InterruptedException {
		int z = 0;
		
		do {

			this.buscarAgenciasAppObject.getBairroComboBox().sendKeys(Keys.ARROW_DOWN);
			
			z++;			
			
		} while (z == bairro); //cristo = 9, centro histórico = 7

		this.buscarAgenciasAppObject.getBairroComboBox().sendKeys(Keys.ENTER);
	}

}
