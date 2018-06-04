package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoPracaEdsonMiranda106VerificationPoint {
	private WebDriver driver;
	
	private BuscaCepEnderecoTask buscaCepEnderecoTask;
	
	public BuscaCepEnderecoPracaEdsonMiranda106VerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}
	
	public void checarBuscaCepEnderecoPracaEdsonMiranda106() throws InterruptedException{
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("Praça Edson Miranda 106");
		Report.log(Status.INFO, "O Endereço Praça Edson Miranda 106 Foi Preenchido");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");
		
		String expectedMessage = "Praça Edson Miranda 106";
		Boolean pass = false;
		Thread.sleep(3000);
		
		if(this.driver.getPageSource().contains(expectedMessage)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada \"Praça Edson Miranda 106\"",  Screenshot.capture(driver));
			pass = true;
		}	
		else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada \"Praça Edson Miranda 106\"",  Screenshot.capture(driver));
		}
		assertEquals(true, pass);
	}
}
