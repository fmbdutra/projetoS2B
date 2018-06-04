package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEndereco01000000VerificationPoint;

public class BuscaCepEndereco01000000TestCase {
	private WebDriver driver;
	private BuscaCepEndereco01000000VerificationPoint buscaCepEndereco01000000VerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Busca de Cep 01000000");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEndereco01000000VerificationPoint = new BuscaCepEndereco01000000VerificationPoint(driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEndereco01000000VerificationPoint.checarBuscaCepEndereco01000000();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
