package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorServicoTask {
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private BuscarAgenciasTask buscarAgenciasTask;

	public BuscarAgenciaPorServicoTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}
	
	public void selecionarServicoRadioButton() {
		this.buscarAgenciasAppObject.getServicoRadialButton().click();
	}
	
	public void selecionarEstado(String estado) {
		this.buscarAgenciasTask.selecionarEstadoComboBox(estado);
	}
	
	public void selecionarMunicipio(String municipio) {
		this.buscarAgenciasTask.selecionarMunicipioComboBox(municipio);
	}
	
	public void seleionarBairro(String bairro) {
		this.buscarAgenciasTask.selecionarBairroComboBox(bairro);
	}
	
	public void selecionarHorario(String horario) {
		this.buscarAgenciasTask.selecionarHorario(horario);
	}

}
