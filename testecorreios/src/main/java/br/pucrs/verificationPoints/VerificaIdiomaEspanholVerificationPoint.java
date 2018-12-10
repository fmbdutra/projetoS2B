package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.HomePage;

public class VerificaIdiomaEspanholVerificationPoint {
	private WebDriver driver;
	private HomePage home;

	public VerificaIdiomaEspanholVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.home = new HomePage(driver);
	}

	public void verificarIdiomaDoTexto() {
		String atual = this.home.getTrackAndTrace().getText();
		String naoEsperado = "Acompanhe seu objeto";
		String esperado = "Rastreo de Objetos";

		if (atual == naoEsperado) {
			Report.log(Status.ERROR, "A Página Não Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "A Página Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		}
		assertEquals(atual, esperado);
	}
}
