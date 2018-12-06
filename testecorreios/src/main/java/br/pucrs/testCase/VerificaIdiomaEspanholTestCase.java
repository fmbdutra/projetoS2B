package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.VerificaIdiomaEspanholTask;
import br.pucrs.verificationPoints.VerificaIdiomaEspanholVerificationPoint;

public class VerificaIdiomaEspanholTestCase {
	private WebDriver driver;
	private VerificaIdiomaEspanholVerificationPoint verificaIdiomaEspanholVerificationPoint;
	private VerificaIdiomaEspanholTask verificaIdiomaEspanholTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Idioma - Tradução da Página para Espanhol");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.verificaIdiomaEspanholVerificationPoint = new VerificaIdiomaEspanholVerificationPoint(driver);
		this.verificaIdiomaEspanholTask = new VerificaIdiomaEspanholTask(driver);

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() {
		
		this.verificaIdiomaEspanholTask.apertarBotaoEspanhol();
		Report.log(Status.INFO, "O Botão Espanhol Foi Pressionado");
		
		this.verificaIdiomaEspanholVerificationPoint.verificarIdiomaDoTexto();
	}

	@After
	public void tearDown() {
		this.driver.close();

		Report.close();
	}
}
