package br.pucrs.verificationPoints;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Driver;
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
	
	public void checarBuscaPorArquivoCSV(String endereco, String expectedEndereco) throws InterruptedException {
		
		this.buscaCepEnderecoTask.preencherCepEnderecoInputText(endereco);
		Report.log(Status.INFO, "O Endereço Foi Preenchido como: "+endereco);
		Report.log(Status.INFO, "O Botão Enter Foi Pressionado");

		Boolean pass = false;
		Thread.sleep(3000);

		if (this.driver.getPageSource().contains(expectedEndereco)) {
			Report.log(Status.PASS, "O Teste Retornou A Mensagem Esperada: "+expectedEndereco,Screenshot.capture(driver));
			pass = true;
		} else {
			Report.log(Status.FAIL, "O Teste Não Retornou A Mensagem Esperada: "+expectedEndereco,Screenshot.capture(driver));
		}
		assertTrue("O Teste Não Retornou A Mensagem Esperada: "+expectedEndereco, pass);
	}
}
