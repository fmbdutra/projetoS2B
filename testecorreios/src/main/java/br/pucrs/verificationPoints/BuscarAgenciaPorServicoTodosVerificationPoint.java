package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoTodosVerificationPoint {
	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;

	public BuscarAgenciaPorServicoTodosVerificationPoint(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void checarBuscaDeAgenciaTodos() throws InterruptedException {
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");

		this.buscarAgenciasAppObject.getServicoRadialButton().click();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");

		// PASSAR XPATH POR PARAMETRO
		this.buscarAgenciasTask.selecionarEstadoComboBox("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");

		this.buscarAgenciasTask.selecionarMunicipioComboBox("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");

		this.buscarAgenciasTask.selecionarBairroComboBox("//*[@id=\"bairroAgencia\"]/option[8]");
		Report.log(Status.INFO, "O Bairro Centro Histórico Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarAtendimentoSabado();
		Report.log(Status.INFO, "O Atendimento Sábado Foi Selecionado");
		this.buscarAgenciasTask.selecionarAtendimentoDomingo();
		Report.log(Status.INFO, "O Atendimento Domingo Foi Selecionado");
		this.buscarAgenciasTask.selecionarAtendimentoPlantao();
		Report.log(Status.INFO, "O Atendimento Plantão Foi Selecionado");
		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
		Report.log(Status.INFO, "O Atendimento Banco Postal Foi Selecionado");
		this.buscarAgenciasTask.selecionarAtendimentoCertificadoDigital();
		Report.log(Status.INFO, "O Atendimento Certificado Digital Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");
				
		this.buscarAgenciasTask.clicarNoBody();
		
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		
		Thread.sleep(1000);		
		
		int size = driver.findElements(By.id("tableNomeAgencia")).size();
		if (size > 0) {
			Report.log(Status.FAIL, "O Teste Não Devia Retorna Agências", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "O Teste Não Apresentou Agências pois Não Há Existe Uma O Qual Possuem com Todos os Serviços",
					Screenshot.capture(driver));
		}
		assertEquals(0, size);
	}
}
