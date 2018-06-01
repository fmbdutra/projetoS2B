package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciaPorServicoCertificadoDigitalTask;
import br.pucrs.tasks.BuscarAgenciaPorServicoDomingoBancoPostalTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoCertificadoDigitalVerificationPoint {
	private WebDriver driver;
	
	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorServicoCertificadoDigitalTask buscarAgenciaPorServicoCertificadoDigitalTask;
	
	public BuscarAgenciaPorServicoCertificadoDigitalVerificationPoint (WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorServicoCertificadoDigitalTask = new BuscarAgenciaPorServicoCertificadoDigitalTask(driver);
	}
	
	public void checarBuscaDeAgenciaCertificadoDigital() {
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");
		
		this.buscarAgenciaPorServicoCertificadoDigitalTask.selecionarServicoRadioButton();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");
		
		//PASSAR XPATH POR PARAMETRO
		this.buscarAgenciaPorServicoCertificadoDigitalTask.selecionarEstadoComboBox("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");
		
		this.buscarAgenciaPorServicoCertificadoDigitalTask.selecionarMunicipioComboBox("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");
		
		this.buscarAgenciaPorServicoCertificadoDigitalTask.seleionarBairroComboBox("//*[@id=\"bairroAgencia\"]/option[8]");
		Report.log(Status.INFO, "O Bairro Centro Histórico Foi Selecionado");
		
		this.buscarAgenciaPorServicoCertificadoDigitalTask.selecionarHorarioComboBox("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");
		
		this.buscarAgenciaPorServicoCertificadoDigitalTask.selecionarAtendimentoCheckBox();
		Report.log(Status.INFO, "A Opção Certificado Digital Foi Selecionada");
		
		int size = driver.findElements(By.id("tableNomeAgencia") ).size();
		if(size != 0) {
			Report.log(Status.FAIL, "O Teste Não Deve Retornar Nenhum Resultado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "O Teste Foi Executado e Nenhum Resultado Foi Retornado", Screenshot.capture(driver));
		}
		assertEquals(0, size);
	}
}
