package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.BuscarAgenciasPage;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoSabadoBancoPostalVerificationPoint {

	private BuscarAgenciasPage buscarAgenciasAppObject;
	private WebDriver driver;
	private BuscarAgenciasTask buscarAgenciasTask;

	public BuscarAgenciaPorServicoSabadoBancoPostalVerificationPoint(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasPage(driver);
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	public void checarBuscaDeAgenciaSabadoPostal() throws InterruptedException {
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");

		this.buscarAgenciasAppObject.getServicoRadialButton().click();
		Report.log(Status.INFO, "Buscar Agências Por Servico Foi Selecionado");

		// PASSAR XPATH POR PARAMETRO
		this.buscarAgenciasTask.selecionarEstado("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");

		this.buscarAgenciasTask.selecionarMunicipio("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");

		this.buscarAgenciasTask.selecionarBairro("//*[@id=\"bairroAgencia\"]/option[8]");
		Report.log(Status.INFO, "O Bairro Centro Histórico Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		Thread.sleep(1300);
		Report.log(Status.INFO, "Exibido Agências Localizadas no Bairro Centro Histórico", Screenshot.capture(driver));

		this.buscarAgenciasTask.selecionarAtendimentoSabado();
		Report.log(Status.INFO, "O Atendimento Sábado Foi Selecionado");
		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
		Report.log(Status.INFO, "O Atendimento Banco Postal Foi Selecionado");

		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();
		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();
		Thread.sleep(1300);

		int size = driver.findElements(By.id("tableNomeAgencia")).size();
		if (size > 0) {
			Report.log(Status.FAIL,
					"O Teste Não Devia Retornar Resultados Pois Não Abrem Agências Sábado com Banco Postal No Bairro Centro Histórico",
					Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS,
					"O Teste Foi Executado e Não Retornou Resultado Pois Não Abrem Agências Sábado com Banco Postal No Bairro Centro Histórico",
					Screenshot.capture(driver));
		}
		assertEquals(0, size); // Pois não abrem agências ao sábado com banco postal no Bairro Centro Histórico
	}

}
