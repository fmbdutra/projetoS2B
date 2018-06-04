package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoNegativo04824080VerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEnderecoNegativo04824080VerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEnderecoNegativo04824080() throws InterruptedException {
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("-04824080");
		Report.log(Status.INFO, "O CEP -04824080 Foi Preenchido");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		String expectedMessage = "Rua Raiz de Guiné";
		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(expectedMessage)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada \"Rua Raiz de Guiné\"",
					Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada \"Rua Raiz de Guiné\"",
					Screenshot.capture(driver));
		}
		assertEquals(true, pass);
	}
}
