package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.ContrasteDaPaginaVerificationPoint;

public class ContrasteDaPáginaTestCase {
	private WebDriver driver;
	private ContrasteDaPaginaVerificationPoint contrasteDaPáginaVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Acessibilidade(Página em Contraste)");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();

		this.contrasteDaPáginaVerificationPoint = new ContrasteDaPaginaVerificationPoint(driver);

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() throws InterruptedException {
		this.contrasteDaPáginaVerificationPoint.checarFuncaoContraste();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}


}
