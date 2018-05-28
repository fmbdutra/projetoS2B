package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.pucrs.tasks.DiminuiTamanhoDaLetraTask;

public class DiminuiTamanhoDaLetraVerificationPoint {
	
	private DiminuiTamanhoDaLetraTask diminuiTamanhoDaLetraTask;
	public DiminuiTamanhoDaLetraVerificationPoint(WebDriver driver) {
		this.diminuiTamanhoDaLetraTask = new DiminuiTamanhoDaLetraTask(driver);
	}
	
	public void verificarReducaoDaFonte() {
		String atual = this.diminuiTamanhoDaLetraTask.apertarBotaoDiminuir();
		assertEquals("12px", atual);
	}
}
