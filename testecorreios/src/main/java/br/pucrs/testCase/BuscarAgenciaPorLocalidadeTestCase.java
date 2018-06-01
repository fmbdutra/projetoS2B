package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.verificationPoints.BuscarAgenciaPorLocalidadeVerificationPoint;

public class BuscarAgenciaPorLocalidadeTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorLocalidadeVerificationPoint buscarAgenciaPorLocalidadeVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Busca de Agência(Por Localidade)");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorLocalidadeVerificationPoint = new BuscarAgenciaPorLocalidadeVerificationPoint(driver);

	}

	@Test
	public void main() throws InterruptedException {

		this.buscarAgenciaPorLocalidadeVerificationPoint.checarBuscaporLocalidade();

	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
