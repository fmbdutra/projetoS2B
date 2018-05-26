package verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import br.pucrs.tasks.AumentaTamanhoDaLetraTask;

public class AumentaTamanhoDaLetraVerificationPoint {
	
	private AumentaTamanhoDaLetraTask aumentaTamanhoDaLetraTask;
	public AumentaTamanhoDaLetraVerificationPoint(WebDriver driver) {
		this.aumentaTamanhoDaLetraTask = new AumentaTamanhoDaLetraTask(driver);
	}

	public void verificarTamanhoFonte() {
		String atual = this.aumentaTamanhoDaLetraTask.apertarBotaoAumentar();
		assertEquals("17px", atual);
	}
}
