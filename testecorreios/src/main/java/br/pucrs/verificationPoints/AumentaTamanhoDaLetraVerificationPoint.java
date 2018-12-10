package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.HomePage;

public class AumentaTamanhoDaLetraVerificationPoint {
	private WebDriver driver;

	private HomePage home;	

	public AumentaTamanhoDaLetraVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.home = new HomePage(driver);
	}

	public void checarAumentoDaFonte() {
				
		String atual = this.home.getFonteDoTextoHtml().getCssValue("font-size");			
						
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