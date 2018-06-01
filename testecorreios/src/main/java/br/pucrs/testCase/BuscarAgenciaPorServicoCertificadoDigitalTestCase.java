package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscarAgenciaPorServicoCertificadoDigitalVerificationPoint;

public class BuscarAgenciaPorServicoCertificadoDigitalTestCase {
	private WebDriver driver;
	private BuscarAgenciaPorServicoCertificadoDigitalVerificationPoint buscarAgenciaPorServicoCertificadoDigitalVerificationPoint;

	@Before
	public void setUp() {
		Report.startTest("Buscar Agência Por Serviço - Certificado Digital");
		
		driver = Driver.getFirefoxDriver();
		
		driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();
		
		this.buscarAgenciaPorServicoCertificadoDigitalVerificationPoint = new BuscarAgenciaPorServicoCertificadoDigitalVerificationPoint(driver);
		
		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));
	}
	
	@Test
	public void main() {
		this.buscarAgenciaPorServicoCertificadoDigitalVerificationPoint.checarBuscaDeAgenciaCertificadoDigital();
	}
	
	@After
	public void tearDown() {
		driver.close();
		
		Report.close();
	}
}
