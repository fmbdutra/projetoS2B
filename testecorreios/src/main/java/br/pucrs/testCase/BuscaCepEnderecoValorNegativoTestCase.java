package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEnderecoNegativo04824080VerificationPoint;

public class BuscaCepEnderecoValorNegativoTestCase {
	private WebDriver driver;
	private BuscaCepEnderecoNegativo04824080VerificationPoint buscaCepEnderecoNegativo04824080VerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca CEP - Valor Negativo");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCepEnderecoNegativo04824080VerificationPoint = new BuscaCepEnderecoNegativo04824080VerificationPoint(
				driver);
	}

	@Test
	public void main() throws InterruptedException {
		this.buscaCepEnderecoNegativo04824080VerificationPoint.checarBuscaCepEnderecoNegativo04824080();
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
