package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEnderecoInvalidoVerificationPoint;

public class BuscaCepEnderecoInvalidoTestCase {
	private WebDriver driver;
	private BuscaCepEnderecoInvalidoVerificationPoint buscaCepEnderecoInvalidoVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca Endereco Inválido");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEnderecoInvalidoVerificationPoint = new BuscaCepEnderecoInvalidoVerificationPoint(driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEnderecoInvalidoVerificationPoint.checarBuscaCepEnderecoInvalido();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
