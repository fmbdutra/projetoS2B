package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEndereco94820010VerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEndereco94820010VerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEndereco94820010() throws InterruptedException {
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("94820010");
		Report.log(Status.INFO, "O CEP 94820010 Foi Preenchido");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		String expectedMessage = "Travessa Ana Neri";
		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(expectedMessage)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada \"Travessa Ana Neri\"",
					Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada \"Travessa Ana Neri\"",
					Screenshot.capture(driver));
		}
		assertEquals(true, pass);
	}
}
