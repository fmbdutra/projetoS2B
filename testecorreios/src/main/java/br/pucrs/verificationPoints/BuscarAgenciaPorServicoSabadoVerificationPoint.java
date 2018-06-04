package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoSabadoVerificationPoint {

	private WebDriver driver;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private BuscarAgenciasTask buscarAgenciasTask;

	public BuscarAgenciaPorServicoSabadoVerificationPoint(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void checarBuscaDeAgenciaSabado() throws InterruptedException {
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

		this.buscarAgenciasTask.clicarNoBody();
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		Thread.sleep(1300);
		Report.log(Status.INFO, "Exibido Agências Localizadas no Bairro Centro Histórico", Screenshot.capture(driver));

		this.buscarAgenciasTask.selecionarAtendimentoSabado();
		Report.log(Status.INFO, "O Atendimento Sábado Foi Selecionado");

		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		Thread.sleep(1300);

		int size = driver.findElements(By.id("tableNomeAgencia")).size();
		if (size < 2) {
			Report.log(Status.FAIL,
					"O Teste Não Retornou Resultados Das Agências que Abrem Aos Sábados No Bairro Centro Histórico",
					Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS,
					"O Teste Foi Executado e Foi Apresentada As Duas Agências Que Abrem Sábado No Centro Histórico",
					Screenshot.capture(driver));
		}
		assertEquals(2, size); // Pois abrem apenas 2 agências ao sábado no Bairro Centro Histórico

	}

}
