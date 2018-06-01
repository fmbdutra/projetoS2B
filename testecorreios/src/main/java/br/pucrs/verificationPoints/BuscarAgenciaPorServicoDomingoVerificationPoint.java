package br.pucrs.verificationPoints;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoDomingoVerificationPoint {

	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private WebDriver driver;
	private BuscarAgenciasTask buscarAgenciasTask;

	public BuscarAgenciaPorServicoDomingoVerificationPoint(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void checarBuscaDeAgenciaDomingo() throws InterruptedException {
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

		this.buscarAgenciasTask.selecionarAtendimentoDomingo();
		Report.log(Status.INFO, "O Atendimento Domingo Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		Thread.sleep(1300);

		int size = driver.findElements(By.id("tableNomeAgencia")).size();
		if (size > 0) {
			Report.log(Status.FAIL, "O Teste Foi Executado e Foi Apresentada Agências", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "O Teste Não Retornou Resultados Pois Não Abrem Agências Domingo no Bairro Centro Histórico", Screenshot.capture(driver));
		}
		assertEquals(0, size); // Pois não abrem agências domingo no Bairro Centro Histórico
	}

}
