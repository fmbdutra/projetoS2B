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

		driver = Driver.getFirefoxDriver();

		driver.get("http://www.buscacep.correios.com.br/sistemas/buscacep/BuscaCepEndereco.cfm");
		driver.manage().window().maximize();

		this.buscaCEPEnderecoCSVVerificationPoint = new BuscaCEPEnderecoCSVVerificationPoint(driver);
	}

	@Test
	@FileParameters("./src/main/resources/teste.csv")
	public void main(String nome, String input, String expected) throws InterruptedException {
		Report.startTest(nome);
		
		this.buscaCEPEnderecoCSVVerificationPoint.checarBuscaPorArquivoCSV(input, expected);
		
		

	}

	@After
	public void tearDown() {
		driver.close();

		Report.close();
	}

}
