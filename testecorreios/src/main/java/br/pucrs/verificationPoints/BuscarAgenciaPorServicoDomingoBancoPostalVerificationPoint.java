package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.BuscarAgenciasPage;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoDomingoBancoPostalVerificationPoint {
	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciasPage buscarAgenciasAppObject;

	public BuscarAgenciaPorServicoDomingoBancoPostalVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciasAppObject = new BuscarAgenciasPage(driver);
	}

	public void checarBuscaDeAgenciaDomingoBancoPostal() throws InterruptedException {
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

		this.buscarAgenciasTask.selecionarAtendimentoDomingo();
		Report.log(Status.INFO, "O Atendimento Domingo Foi Selecionado");

		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
		Report.log(Status.INFO, "As Opções de Banco Postal Foi Selecionadas");

		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();

		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();

		Thread.sleep(1000);

		Report.log(Status.INFO, "As Opções de Domingo e Banco Postal Foram Selecionadas");

		int size = driver.findElements(By.id("tableNomeAgencia")).size();
		if (size != 0) {
			Report.log(Status.FAIL, "O Teste Não Deve Retornar Nenhum Resultado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "O Teste Foi Executado e Nenhum Resultado Foi Retornado",
					Screenshot.capture(driver));
		}
		assertEquals(0, size);
	}
}
