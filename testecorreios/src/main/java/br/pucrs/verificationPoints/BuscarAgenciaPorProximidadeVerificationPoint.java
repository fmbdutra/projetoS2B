package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorProximidadeVerificationPoint {

	private WebDriver driver;

	public BuscarAgenciaPorProximidadeVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}

	public void checarEnderecoDaAgenciaNoMapa() throws InterruptedException {

		Report.log(Status.INFO,
				"O Mapa Deve Ter Marcação Exibindo Localização Da Agência Mais Próxima do Endereço Pesquisado",
				Screenshot.capture(driver));
	}

}
