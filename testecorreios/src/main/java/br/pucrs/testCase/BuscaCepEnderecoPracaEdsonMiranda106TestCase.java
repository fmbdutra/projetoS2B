package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEnderecoPucrsVerificationPoint;

public class BuscaCepEnderecoPracaEdsonMiranda106TestCase {
	private WebDriver driver;
	private BuscaCepEnderecoPucrsVerificationPoint buscaCepEnderecoPucrsVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca endereço válido");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEnderecoPucrsVerificationPoint = new BuscaCepEnderecoPucrsVerificationPoint(
				driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEnderecoPucrsVerificationPoint.checarBuscaCepEnderecoPracaEdsonMiranda106();
		
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
