package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.verificationPoints.BuscarAgenciaPorProximidadeVerificationPoint;

public class BuscarAgenciaPorProximidadeTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorProximidadeVerificationPoint buscarAgenciaPorProximidadeVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Busca de Agência(Por Proximidade)");

		driver = Driver.getFirefoxDriver();
		
		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.buscarAgenciaPorProximidadeVerificationPoint = new BuscarAgenciaPorProximidadeVerificationPoint(driver);

	}

	@Test
	public void main() throws InterruptedException {
				
		this.buscarAgenciaPorProximidadeVerificationPoint.checarEnderecoDaAgenciaNoMapa();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
