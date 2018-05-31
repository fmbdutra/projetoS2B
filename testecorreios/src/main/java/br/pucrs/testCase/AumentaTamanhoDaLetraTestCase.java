package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.AumentaTamanhoDaLetraVerificationPoint;

public class AumentaTamanhoDaLetraTestCase {
	private WebDriver driver;
	private AumentaTamanhoDaLetraVerificationPoint aumentaTamanhoDaLetraVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Teste de Acessibilidade(Aumento da Fonte)");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();
		
		this.aumentaTamanhoDaLetraVerificationPoint = new AumentaTamanhoDaLetraVerificationPoint(driver);

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() {
		this.aumentaTamanhoDaLetraVerificationPoint.checarAumentoDaFonte();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
