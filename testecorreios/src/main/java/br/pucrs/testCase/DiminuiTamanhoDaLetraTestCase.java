package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.TamanhoDaLetraTask;
import br.pucrs.verificationPoints.DiminuiTamanhoDaLetraVerificationPoint;

public class DiminuiTamanhoDaLetraTestCase {
	private WebDriver driver;
	private DiminuiTamanhoDaLetraVerificationPoint diminuiTamanhoDaLetraVerificationPoint;
	private TamanhoDaLetraTask tamanhoLetraTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Acessibilidade - Diminuição do Tamanho da Letra");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/");
		driver.manage().window().maximize();

		this.diminuiTamanhoDaLetraVerificationPoint = new DiminuiTamanhoDaLetraVerificationPoint(driver);
		this.tamanhoLetraTask = new TamanhoDaLetraTask(driver);

		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}

	@Test
	public void main() {
		
		tamanhoLetraTask.apertarBotaoDiminuir();		
		Report.log(Status.INFO, "O Botão A- Foi Pressionado");
		
		this.diminuiTamanhoDaLetraVerificationPoint.verificarReducaoDaFonte();
	}

	@After
	public void tearDown() {

		this.driver.close();

		Report.close();
	}
}
