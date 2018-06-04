package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoCampoVazioVerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEnderecoCampoVazioVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEnderecoCampoVazio() throws InterruptedException {
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText("");

		Report.log(Status.INFO, "O CEP Foi Deixado Em Branco");
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		Boolean pass = false;
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();
		Boolean expectedMessage = alert.getText().toString().replaceAll("\\W", "").contains("InformeoEndereo");
		Report.log(Status.WARNING, "O Alerta Foi Exibido");
		alert.accept();

		if (expectedMessage) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada \"Informe o Endereço !\"",
					Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada \"Informe o Endereço !\"",
					Screenshot.capture(driver));
		}
		assertEquals(true, pass);
	}
}
