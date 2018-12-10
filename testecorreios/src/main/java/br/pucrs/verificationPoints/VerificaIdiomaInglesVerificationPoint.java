package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.HomeAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.VerificaIdiomaInglesTask;

public class VerificaIdiomaInglesVerificationPoint {
	private WebDriver driver;
	private HomeAppObject homeAppObject;

	public VerificaIdiomaInglesVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void verificarIdiomaDoTexto() {
		
		String naoEsperado = "Acompanhe seu objeto";
		String esperado = "Track and Trace";
		
		String atual = this.homeAppObject.getTrackAndTrace().getText();
		
		if (atual == naoEsperado) {
			Report.log(Status.ERROR, "A Página Não Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		} else {
			Report.log(Status.PASS, "A Página Foi Traduzida Conforme o Esperado", Screenshot.capture(driver));
		}
		assertEquals(atual, esperado);
	}
}
