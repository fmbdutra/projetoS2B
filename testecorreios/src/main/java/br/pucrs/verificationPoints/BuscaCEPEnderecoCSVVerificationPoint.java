package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCEPEnderecoCSVVerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCEPEnderecoCSVVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public boolean isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			Report.log(Status.WARNING, "O Alerta foi exibido");
			alert.accept();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public void checarBuscaPorArquivoCSV(String endereco, String expectedEndereco) throws InterruptedException {

		this.buscaCepEnderecoTask.preencherCepEnderecoInputText(endereco);
		Report.log(Status.INFO, "O Endereço Foi Preenchido como: " + endereco);
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		Boolean pass = false;
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			Report.log(Status.PASS, "Alerta foi exibido conforme esperado");
			pass = true;
		}

		else if (this.driver.getPageSource().contains(expectedEndereco)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada: " + expectedEndereco,
					Screenshot.capture(driver));
			pass = true;
		} 
		
		else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada: " + expectedEndereco,
					Screenshot.capture(driver));
		}

		assertEquals(true, pass);
	}
}
