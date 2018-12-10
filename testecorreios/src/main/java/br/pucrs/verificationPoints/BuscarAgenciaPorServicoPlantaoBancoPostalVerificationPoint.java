package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.BuscarAgenciasPage;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint {
	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciasPage buscarAgenciasAppObject;

	public BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciasAppObject = new BuscarAgenciasPage(driver);
	}

	public void checarBusacaAgenciaPlantaoBancoPostal() throws InterruptedException {
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

		this.buscarAgenciasTask.selecionarAtendimentoPlantao();
		Report.log(Status.INFO, "As Opções de Plantao Foi Selecionadas");

		this.buscarAgenciasTask.selecionarAtendimentoBancoPostal();
		Report.log(Status.INFO, "As Opções de Banco Postal Foi Selecionadas");

		this.buscarAgenciasTask.selecionarHorario("//*[@id=\"selHorario\"]/option[12]");
		Report.log(Status.INFO, "O Horário de 10:00 Foi Selecionado");

		this.buscarAgenciasTask.clicarNoBody();

		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();

		Thread.sleep(1000);

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
