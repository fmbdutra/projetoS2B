package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint;

public class BuscarAgenciaPorServicoPlantaoBancoPostalTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint buscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca de Agência por serviços - Plantão e Banco Postal");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();

		this.buscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint = new BuscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint(
				driver);

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.buscarAgenciaPorServicoPlantaoBancoPostalVerificationPoint.checarBusacaAgenciaPlantaoBancoPostal();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
