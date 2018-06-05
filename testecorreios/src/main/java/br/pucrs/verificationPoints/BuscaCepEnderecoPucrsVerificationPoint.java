package br.pucrs.verificationPoints;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscaCepEnderecoTask;

public class BuscaCepEnderecoPucrsVerificationPoint {
	private WebDriver driver;

	private BuscaCepEnderecoTask buscaCepEnderecoTask;

	public BuscaCepEnderecoPucrsVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscaCepEnderecoTask = new BuscaCepEnderecoTask(driver);
	}

	public void checarBuscaCepEnderecoPracaEdsonMiranda106() throws InterruptedException {
		
		String endereco = "pucrs";
		
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText(endereco);
		Report.log(Status.INFO, "O Endereço Foi Preenchido como: "+endereco);
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(endereco)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada: "+endereco,Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada: "+endereco,Screenshot.capture(driver));
		}
		assertTrue("O Teste Não Retornou A Mensagem Esperada: "+endereco, pass);
	}
}
