package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoInvalidoVerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEnderecoInvalidoVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEnderecoInvalido() throws InterruptedException {
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("TesteCT30");
		Report.log(Status.INFO, "O Endereço TesteCT30 Foi Preenchido");
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
