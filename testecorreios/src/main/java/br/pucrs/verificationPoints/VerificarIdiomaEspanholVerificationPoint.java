package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.VerificaIdiomaEspanholTask;

public class VerificarIdiomaEspanholVerificationPoint {
	private WebDriver driver;

	private VerificaIdiomaEspanholTask verificaIdiomaEspanholTask;

	public VerificarIdiomaEspanholVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.verificaIdiomaEspanholTask = new VerificaIdiomaEspanholTask(driver);
	}

	public void verificarIdiomaDoTexto() {
		String atual = this.verificaIdiomaEspanholTask.apertarBotaoEspanhol();
		String naoEsperado = "Acompanhe seu objeto";
		String esperado = "Rastreo de Objetos";

		Report.log(Status.INFO, "O Botão Espanhol Foi Pressionado");
		if (atual == naoEsperado) {
			Report.log(Status.ERROR, "A Página Não Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "A Página Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		}
		assertEquals(atual, esperado);
	}
}
