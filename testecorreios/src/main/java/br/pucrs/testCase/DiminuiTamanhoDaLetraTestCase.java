package br.pucrs.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.pucrs.verificationPoints.DiminuiTamanhoDaLetraVerificationPoint;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DiminuiTamanhoDaLetraTestCase {
	private WebDriver driver;
	private DiminuiTamanhoDaLetraVerificationPoint diminuiTamanhoDaLetraVerificationPoint;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		
		this.driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize();
		this.diminuiTamanhoDaLetraVerificationPoint = new DiminuiTamanhoDaLetraVerificationPoint(driver);
	}
	
	@Test
	public void main() {
		this.diminuiTamanhoDaLetraVerificationPoint.verificarReducaoDaFonte();
	}
	
	@After
	public void tearDown() {
		this.driver.close();
	}
}
