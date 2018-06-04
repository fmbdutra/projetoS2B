package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCepEnderecoPracaEdsonMiranda106VerificationPoint;

public class BuscaCepEnderecoPracaEdsonMiranda106TestCase {
	private WebDriver driver;
	private BuscaCepEnderecoPracaEdsonMiranda106VerificationPoint buscaCepEnderecoPracaEdsonMiranda106VerificationPoint;
	
	@Before
	public void setUp() {
		Report.startTest("Teste de Busca Endereço Praça Edson Miranda 106");
		
		driver = Driver.getFirefoxDriver();
		
		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();
		
		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
		
		this.buscaCepEnderecoPracaEdsonMiranda106VerificationPoint = new BuscaCepEnderecoPracaEdsonMiranda106VerificationPoint(driver);
	}
	
	@Test
	public void main() throws InterruptedException {
		this.buscaCepEnderecoPracaEdsonMiranda106VerificationPoint.checarBuscaCepEnderecoPracaEdsonMiranda106();;
	}
	
	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}
}
