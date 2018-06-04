package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoDomingoVerificationPoint;

public class BuscarAgenciaPorServicoDomingoTestCase {

	private WebDriver driver;
	private BuscarAgenciaPorServicoDomingoVerificationPoint buscarAgenciaPorServicoDomingoVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Buscar Agência Por Serviço - Domingo");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoDomingoVerificationPoint = new BuscarAgenciaPorServicoDomingoVerificationPoint(
				driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.buscarAgenciaPorServicoDomingoVerificationPoint.checarBuscaDeAgenciaDomingo();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
