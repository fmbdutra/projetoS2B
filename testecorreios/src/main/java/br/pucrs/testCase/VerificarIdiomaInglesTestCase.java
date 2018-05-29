package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.VerificaIdiomaInglesVerificationPoint;

public class VerificarIdiomaInglesTestCase {
	private WebDriver driver;
	private VerificaIdiomaInglesVerificationPoint verificaIdiomaInglesVerificationPoint;
	
	@Before
	public void setUp() {
		Report.startTest("Teste de Alteração de Idioma Para o Inglês");
		
		driver = Driver.getFirefoxDriver();
		
		this.driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();
		this.verificaIdiomaInglesVerificationPoint = new VerificaIdiomaInglesVerificationPoint(driver);
		
		Report.log(Status.INFO, "A página foi carregada", Screenshot.capture(driver));
	}
	
	@Test
	public void main() {
		this.verificaIdiomaInglesVerificationPoint.verificarIdiomaDoTexto();
	}
	
	@After
	public void tearDown() {
		
		this.driver.close();
		
		Report.close();
	}
}
