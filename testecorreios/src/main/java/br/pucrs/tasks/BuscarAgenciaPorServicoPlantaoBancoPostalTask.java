package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorServicoPlantaoBancoPostalTask {
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private BuscarAgenciasTask buscarAgenciasTask;
	
	public BuscarAgenciaPorServicoPlantaoBancoPostalTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}
	
	public void selecionarServicoRadioButton() {
		this.buscarAgenciasAppObject.getServicoRadialButton().click();
	}
	
	public void selecionarEstadoComboBox(String estado) {
		this.buscarAgenciasTask.selecionarEstadoComboBox(estado);;
	}
	
	public void selecionarMunicipioComboBox(String municipio) {
		this.buscarAgenciasTask.selecionarMunicipioComboBox(municipio);
	}
	
	public void seleionarBairroComboBox(String bairro) {
		this.buscarAgenciasTask.selecionarBairroComboBox(bairro);
	}
	
	public void selecionarHorarioComboBox(String horario) {
		this.buscarAgenciasTask.selecionarHorario(horario);
	}
	
	public void selecionarAtendimentoCheckBox() {
		this.buscarAgenciasTask.selecionarAtendimentoPlantao();
		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
	}

}
