package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.appObject.HomeAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorLocalidadeVerificationPoint {

	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private HomeAppObject homeAppObject;

	public BuscarAgenciaPorLocalidadeVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void checarBuscaporLocalidade() throws InterruptedException {

		int size = buscarAgenciasAppObject.getTabelaDeBusca().size();
		Boolean teste = false;

		if (size != 0) {
			Report.log(Status.PASS, "A Busca Retornou Resultado", Screenshot.capture(driver));
			teste = true;
		} else {
			Report.log(Status.FAIL, "A Busca Não Retornou Nenhum Resultado", Screenshot.capture(driver));
		}

		assertEquals((size > 0), teste);

	}

}
