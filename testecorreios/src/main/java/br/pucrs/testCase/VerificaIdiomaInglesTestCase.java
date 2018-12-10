package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.VerificaIdiomaTask;
import br.pucrs.verificationPoints.VerificaIdiomaInglesVerificationPoint;

public class VerificaIdiomaInglesTestCase {
	private WebDriver driver;
	private VerificaIdiomaInglesVerificationPoint verificaIdiomaInglesVerificationPoint;
	private VerificaIdiomaTask idiomaTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Idioma - Tradução da Página para Inglês");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
		
		this.idiomaTask = new VerificaIdiomaTask(driver);
		this.verificaIdiomaInglesVerificationPoint = new VerificaIdiomaInglesVerificationPoint(driver);
	}

	@Test
	public void main() {
				
		this.idiomaTask.apertarBotaoEnglish();
		Report.log(Status.INFO, "O Botão English Foi Pressionado");		
		
		this.verificaIdiomaInglesVerificationPoint.verificarIdiomaDoTexto();
	}

	@After
	public void tearDown() {

		this.driver.close();

		Report.close();
	}
}
