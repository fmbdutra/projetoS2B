package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.tasks.BuscarAgenciasTask;
import br.pucrs.verificationPoints.BuscarAgenciaPorProximidadeVerificationPoint;

public class BuscarAgenciaPorProximidadeTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorProximidadeVerificationPoint buscarAgenciaPorProximidadeVerificationPoint;
	private BuscarAgenciasTask buscarAgenciasTask;
	 

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca de Agência por Proximidade");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorProximidadeVerificationPoint = new BuscarAgenciaPorProximidadeVerificationPoint(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
	}

	@Test
	public void main() throws InterruptedException {
		
		String enderecoBuscado = "Rodovia RS 118, 11800 - Maria Regina, Alvorada - RS, 94834-670";

		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();
		Report.log(Status.INFO, "Entrou Na Página Inicial dos Correios");

		this.buscarAgenciasTask.selecionarProximidade();
		Report.log(Status.INFO, "Entrou na Página De 'Busca de Agências'");

		Report.log(Status.INFO, "Buscar Agências Por Proximidade Foi Selecionado");

		this.buscarAgenciasTask.digitarLocalizacao(enderecoBuscado);
		Report.log(Status.INFO, "Buscou Endereço " + enderecoBuscado);

		this.buscarAgenciasTask.pesquisarLocalizacao();
		Report.log(Status.INFO, "O Botão 'Pesquisar' foi Pressionado");

		while (this.buscarAgenciasTask.verificaCarregamentodoMapa() == false) {
			Thread.sleep(2000);
		}

		Thread.sleep(2000);

		this.buscarAgenciasTask.rolarPaginaParaVerificarResultado();

		this.buscarAgenciaPorProximidadeVerificationPoint.checarEnderecoDaAgenciaNoMapa();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
