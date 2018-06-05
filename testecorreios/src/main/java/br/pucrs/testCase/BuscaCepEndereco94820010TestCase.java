package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEndereco94820010VerificationPoint;

public class BuscaCepEndereco94820010TestCase {
	private WebDriver driver;
	private BuscaCepEndereco94820010VerificationPoint buscaCepEndereco94820010VerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca CEP 94820010");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEndereco94820010VerificationPoint = new BuscaCepEndereco94820010VerificationPoint(driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEndereco94820010VerificationPoint.checarBuscaCepEndereco94820010();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
