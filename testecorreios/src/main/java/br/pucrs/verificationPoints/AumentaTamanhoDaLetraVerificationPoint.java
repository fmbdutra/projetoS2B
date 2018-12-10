package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.HomePage;
import br.pucrs.tasks.AumentaTamanhoDaLetraTask;

public class AumentaTamanhoDaLetraVerificationPoint {
	private WebDriver driver;

	private AumentaTamanhoDaLetraTask aumentaTamanhoDaLetraTask;

	private HomePage homeAppObject;

	public AumentaTamanhoDaLetraVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.homeAppObject = new HomePage(driver);
	}

	public void checarAumentoDaFonte() {
				
		String atual = this.homeAppObject.getFonteDoTextoHtml().getCssValue("font-size");			
						
		if (atual == "17px") {
			Report.log(Status.PASS, "O Tamanho Da Fonte Do Texto Foi Alterado Conforme O Esperado.",
					Screenshot.capture(driver));
		} else {
			Report.log(Status.FAIL, "O Tamanho Da Fonte Do Texto Não Foi Alterado Conforme O Esperado.",
					Screenshot.capture(driver));
		}
		
		assertEquals("17px", atual);
	}

}