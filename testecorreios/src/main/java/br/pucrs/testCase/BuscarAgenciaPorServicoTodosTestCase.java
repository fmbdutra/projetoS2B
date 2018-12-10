package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoTodosVerificationPoint;

public class BuscarAgenciaPorServicoTodosTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorServicoTodosVerificationPoint buscarAgenciaPorServicoTodosVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca de Agência por Serviços - Selecionando Todas Opções");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoTodosVerificationPoint = new BuscarAgenciaPorServicoTodosVerificationPoint(driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.buscarAgenciaPorServicoTodosVerificationPoint.checarBuscaDeAgenciaTodos();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
