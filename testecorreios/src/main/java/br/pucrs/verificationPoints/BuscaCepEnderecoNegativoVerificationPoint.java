package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoNegativoVerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEnderecoNegativoVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEnderecoNegativo04824080() throws InterruptedException {
		String endereco = "-13481293";
		
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText(endereco);
		Report.log(Status.INFO, "O CEP "+endereco+" Foi Preenchido");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		String expectedMessage = "Alameda Raphael Gullo";
		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(expectedMessage)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada "+expectedMessage,
					Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada "+expectedMessage,
					Screenshot.capture(driver));
		}
		assertEquals(true, pass);
	}
}
