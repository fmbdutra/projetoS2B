package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoDomingoBancoPostalVerificationPoint;

public class BuscarAgenciaPorServicoDomingoBancoPostalTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorServicoDomingoBancoPostalVerificationPoint buscarAgenciaPorServicoVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Buscar Agência Por Serviço - Domingo e Banco Postal");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoVerificationPoint = new BuscarAgenciaPorServicoDomingoBancoPostalVerificationPoint(
				driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() {
		this.buscarAgenciaPorServicoVerificationPoint.checarBuscaDeAgenciaDomingoBancoPostal();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
