package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint {
	private WebDriver driver;
	
	private BuscarAgenciasTask buscarAgenciasTask;
	//private BuscarAgenciaPorServicoPlantaoBancoPostalTask buscarAgenciaPorServicoPlantaoBancoPostalTask;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	
	public BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		//this.buscarAgenciaPorServicoPlantaoBancoPostalTask = new BuscarAgenciaPorServicoPlantaoBancoPostalTask(driver);
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}
	
	public void checarBusacaAgenciaPlantaoBancoPostal() {
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");
		
		this.buscarAgenciasAppObject.getServicoRadialButton().click();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");
		
		//PASSAR XPATH POR PARAMETRO
		this.buscarAgenciasTask.selecionarEstadoComboBox("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarMunicipioComboBox("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarBairroComboBox("//*[@id=\"bairroAgencia\"]/option[8]");
		Report.log(Status.INFO, "O Bairro Centro Histórico Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarAtendimentoPlantao();
		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
		Report.log(Status.INFO, "As Opções de Plantao e Banco Postal Foram Selecionadas");
		
		int size = driver.findElements(By.id("tableNomeAgencia") ).size();
		if(size != 0) {
			Report.log(Status.FAIL, "O Teste Não Deve Retornar Nenhum Resultado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "O Teste Foi Executado e Nenhum Resultado Foi Retornado", Screenshot.capture(driver));
		}
		assertEquals(0, size);
	}
}