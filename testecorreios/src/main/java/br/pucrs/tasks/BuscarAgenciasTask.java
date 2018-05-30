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

	public void selecionarEstadoComboBox(String estado) {
		this.buscarAgenciasAppObject.getEstadoComboBox().sendKeys(estado);
	}

	public void selecionarMunicipioComboBox(String municipio) {
		this.buscarAgenciasAppObject.getMunicipioComboBox().sendKeys(municipio);
	}

	public void selecionarBairroComboBox(String bairro) {
		this.buscarAgenciasAppObject.getBairroComboBox().sendKeys(bairro);
	}
	
	public void selecionarHorario(String horario) {
		this.buscarAgenciasAppObject.getHorarioComboBox().sendKeys(horario);
	}
}
