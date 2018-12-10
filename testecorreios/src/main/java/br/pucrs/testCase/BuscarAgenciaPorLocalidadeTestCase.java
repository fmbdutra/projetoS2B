package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.tasks.BuscarAgenciasTask;
import br.pucrs.verificationPoints.BuscarAgenciaPorLocalidadeVerificationPoint;

public class BuscarAgenciaPorLocalidadeTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorLocalidadeVerificationPoint buscarAgenciaPorLocalidadeVerificationPoint;
	private BuscarAgenciasTask buscarAgenciasTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca de Agência por Localidade");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorLocalidadeVerificationPoint = new BuscarAgenciaPorLocalidadeVerificationPoint(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);

	}

	@Test
	public void main() throws InterruptedException {
		
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Entrou Na Página Inicial dos Correios");

		this.buscarAgenciasTask.selecionarLocalidade();
		Report.log(Status.INFO, "Entrou na Página De 'Busca de Agências'");
		Report.log(Status.INFO, "Buscar Agências Por Localização Foi Selecionado");

		this.buscarAgenciasTask.selecionarEstado("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");

		this.buscarAgenciasTask.selecionarMunicipio("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");

		this.buscarAgenciasTask.selecionarBairro("//*[@id=\"bairroAgencia\"]/option[10]");
		Report.log(Status.INFO, "O Bairro Cristo Redentor Foi Selecionado");

		Thread.sleep(4000);

		this.buscarAgenciasTask.primeiroResultadoDaBusca();
		Report.log(Status.INFO, "Clicado na primera agência encontrada na busca");	
		

		this.buscarAgenciaPorLocalidadeVerificationPoint.checarBuscaporLocalidade();

	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
