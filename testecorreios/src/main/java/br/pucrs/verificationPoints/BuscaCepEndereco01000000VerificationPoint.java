package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEndereco01000000VerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEndereco01000000VerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEndereco01000000() throws InterruptedException {
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("01000000");
		Report.log(Status.INFO, "O CEP 01000000 Foi Preenchido");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		String expectedMessage = "DADOS NAO ENCONTRADOS";
		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(expectedMessage)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada \"DADOS NAO ENCONTRADOS\"",
					Screenshot.capture(driver));
			pass = true;
		}

		else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada \"DADOS NAO ENCONTRADOS\"",
					Screenshot.capture(driver));
		}

		assertEquals(true, pass);
	}
}
