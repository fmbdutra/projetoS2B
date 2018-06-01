package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.VerificaIdiomaInglesTask;

public class VerificaIdiomaInglesVerificationPoint {
	private WebDriver driver;

	private VerificaIdiomaInglesTask verificaIdiomaInglesTask;

	public VerificaIdiomaInglesVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.verificaIdiomaInglesTask = new VerificaIdiomaInglesTask(driver);
	}

	public void verificarIdiomaDoTexto() {
		String atual = this.verificaIdiomaInglesTask.apertarBotaoEnglish();
		String naoEsperado = "Acompanhe seu objeto";
		String esperado = "Track and Trace";

		Report.log(Status.INFO, "O Botão English Foi Pressionado");
		if (atual == naoEsperado) {
			Report.log(Status.ERROR, "A Página Não Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "A Página Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		}
		assertEquals(atual, esperado);
	}
}
