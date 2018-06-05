package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.verificationPoints.BuscaCEPEnderecoCSVVerificationPoint;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)

public class BuscaCEPEnderecoCSVTestCase {
	
	private WebDriver driver;
	private BuscaCEPEnderecoCSVVerificationPoint buscaCEPEnderecoCSVVerificationPoint;
	
	

	@Before
	public void setUp() {
		Report.startTest("Teste: Busca Endereço a Partir de Arquivo CSV");

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		Report.log(Status.INFO, "A Página Foi Carregada", Screenshot.capture(driver));

		this.buscaCEPEnderecoCSVVerificationPoint = new BuscaCEPEnderecoCSVVerificationPoint(
				driver);
	}
	
	@Test
	@FileParameters(".testecorreios/src/main/resources/TestCSV.csv")
	public void main(String input, String expected) throws InterruptedException {
		
		this.buscaCEPEnderecoCSVVerificationPoint.checarBuscaPorArquivoCSV(input, expected);				
	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}


}
