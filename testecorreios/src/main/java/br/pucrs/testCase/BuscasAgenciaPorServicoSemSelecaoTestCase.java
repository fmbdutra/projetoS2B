package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoNenhumVerificationPoint;

public class BuscasAgenciaPorServicoSemSelecaoTestCase {

	private WebDriver driver;
	private BuscarAgenciaPorServicoNenhumVerificationPoint buscarAgenciaPorServicoNenhumVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca de Agência por Serviços - Não Selecionando Serviços");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoNenhumVerificationPoint = new BuscarAgenciaPorServicoNenhumVerificationPoint(
				driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.buscarAgenciaPorServicoNenhumVerificationPoint.checarBuscaDeAgenciaNenhum();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}