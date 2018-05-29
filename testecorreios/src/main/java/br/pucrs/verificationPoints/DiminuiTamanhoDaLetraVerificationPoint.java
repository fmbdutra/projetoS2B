package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.DiminuiTamanhoDaLetraTask;

public class DiminuiTamanhoDaLetraVerificationPoint {
	private WebDriver driver;
	
	private DiminuiTamanhoDaLetraTask diminuiTamanhoDaLetraTask;
	
	public DiminuiTamanhoDaLetraVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.diminuiTamanhoDaLetraTask = new DiminuiTamanhoDaLetraTask(driver);
	}
	
	public void verificarReducaoDaFonte() {
		String atual = this.diminuiTamanhoDaLetraTask.apertarBotaoDiminuir();
		Report.log(Status.INFO, "O Botão A- Foi Pressionado");
		if (atual == "12px") {
			Report.log(Status.PASS, "O Tamanho Da Fonte Do Texto Foi Alterado Conforme O Esperado.",
					Screenshot.capture(driver));
		} else {
			Report.log(Status.FAIL, "O Tamanho Da Fonte Do Texto Não Foi Alterado Conforme O Esperado.",
					Screenshot.capture(driver));
		}
		
		assertEquals("12px", atual);
	}
}
