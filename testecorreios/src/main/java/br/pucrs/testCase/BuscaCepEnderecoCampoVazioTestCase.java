package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEnderecoCampoVazioVerificationPoint;

public class BuscaCepEnderecoCampoVazioTestCase {
	private WebDriver driver;
	private BuscaCepEnderecoCampoVazioVerificationPoint buscaCepEnderecoCampoVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Busca de Cep Mantendo O Campo Vazio");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEnderecoCampoVerificationPoint = new BuscaCepEnderecoCampoVazioVerificationPoint(driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEnderecoCampoVerificationPoint.checarBuscaCepEnderecoCampoVazio();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
