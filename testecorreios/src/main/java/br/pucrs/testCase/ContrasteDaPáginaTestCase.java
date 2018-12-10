package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.ContrasteTask;
import br.pucrs.verificationPoints.ContrasteDaPaginaVerificationPoint;

public class ContrasteDaPáginaTestCase {
	private WebDriver driver;
	private ContrasteDaPaginaVerificationPoint contrasteDaPáginaVerificationPoint;
	private ContrasteTask contrasteTask;

	@Before
	public void setUp() {
		Report.startTest("Teste: Acessibilidade - Contraste da Página");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();		
	}

	@Test
	public void main() throws InterruptedException {
		
		this.contrasteDaPáginaVerificationPoint = new ContrasteDaPaginaVerificationPoint(driver);
		this.contrasteTask = new ContrasteTask(driver);
		
		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
		
		this.contrasteTask.apertaBotãoContraste();
		Report.log(Status.INFO, "O Botão Contraste Foi Clicado na Página Inicial");
		
		
		this.contrasteDaPáginaVerificationPoint.checarFuncaoContraste();
	}

	@After
	public void tearDown() {

		driver.close();

		Report.close();
	}

}
