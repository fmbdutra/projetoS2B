package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.AumentaTamanhoDaLetraTask;
import br.pucrs.verificationPoints.AumentaTamanhoDaLetraVerificationPoint;

public class AumentaTamanhoDaLetraTestCase {
	private WebDriver driver;
	private AumentaTamanhoDaLetraVerificationPoint aumentaTamanhoDaLetraVerificationPoint;
	private AumentaTamanhoDaLetraTask aumentaTamanhoDaLetraTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Acessibliidade - Aumento do Tamanho da Letra");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() {
		
		this.aumentaTamanhoDaLetraVerificationPoint = new AumentaTamanhoDaLetraVerificationPoint(driver);
		this.aumentaTamanhoDaLetraTask = new AumentaTamanhoDaLetraTask(driver);
		
		this.aumentaTamanhoDaLetraTask.apertarBotaoAumentar();
		Report.log(Status.INFO, "O Botão A+ Foi Pressionado");
		
		this.aumentaTamanhoDaLetraVerificationPoint.checarAumentoDaFonte();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
