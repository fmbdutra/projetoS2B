package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.tasks.BuscarAgenciaPorServicoTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoVerificationPoint {
	private WebDriver driver;
	
	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorServicoTask buscarAgenciaPorServicoTask;
	
	public BuscarAgenciaPorServicoVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorServicoTask = new BuscarAgenciaPorServicoTask(driver);
	}
	
	public void checarEnderecoDaAgencia () {
		this.buscarAgenciaPorServicoTask.selecionarServicoRadioButton();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");
		
		this.buscarAgenciaPorServicoTask.selecionarEstado("Rio Grande do Sul");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");
		
		this.buscarAgenciaPorServicoTask.selecionarMunicipio("Porto Alegre");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");
		
		this.buscarAgenciaPorServicoTask.seleionarBairro("Centro Histórico");
		Report.log(Status.INFO, "O Bairro Centro Histórico Foi Selecionado");
		
		this.buscarAgenciaPorServicoTask.selecionarHorario("10:00");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");
	}
}
