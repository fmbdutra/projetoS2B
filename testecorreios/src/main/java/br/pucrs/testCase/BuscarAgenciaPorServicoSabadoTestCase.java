package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoSabadoVerificationPoint;

public class BuscarAgenciaPorServicoSabadoTestCase {
	
	private WebDriver driver;
	private BuscarAgenciaPorServicoSabadoVerificationPoint buscarAgenciaPorServicoSabadoVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Buscar Agência Por Serviço - Sábado");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoSabadoVerificationPoint = new BuscarAgenciaPorServicoSabadoVerificationPoint(driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.buscarAgenciaPorServicoSabadoVerificationPoint.checarBuscaDeAgenciaSabado();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}


}
