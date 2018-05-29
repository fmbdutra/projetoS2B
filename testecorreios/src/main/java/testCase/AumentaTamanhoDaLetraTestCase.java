package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import verificationPoints.AumentaTamanhoDaLetraVerificationPoint;

public class AumentaTamanhoDaLetraTestCase {
	private WebDriver driver;
	private AumentaTamanhoDaLetraVerificationPoint aumentaTamanhoDaLetraVerificationPoint;
	
	@Before
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		
		this.driver.get("http://www.correios.com.br/?set_language=pt-br");
		driver.manage().window().maximize(); //Maximizada para prints de tela inteira
		this.aumentaTamanhoDaLetraVerificationPoint = new AumentaTamanhoDaLetraVerificationPoint(driver);
	}
	
	@Test
	public void main() {
		this.aumentaTamanhoDaLetraVerificationPoint.verificarTamanhoFonte();
	}
	
	@After
	public void tearDown() {
		this.driver.close();
	
	}
	
}
