package br.pucrs.verificationPoints;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.appObject.BuscarAgenciasAppObject;
import br.pucrs.appObject.HomeAppObject;
import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciaPorLocalidadeTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorLocalidadeVerificationPoint {

	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	//private BuscarAgenciaPorLocalidadeTask buscarAgenciaPorLocalidadeTask;
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
	private HomeAppObject homeAppObject;

	public BuscarAgenciaPorLocalidadeVerificationPoint(WebDriver driver) {
		this.driver=driver;
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		//this.buscarAgenciaPorLocalidadeTask = new BuscarAgenciaPorLocalidadeTask(driver);
		this.homeAppObject = new HomeAppObject(driver);
	}

	public void checarBuscaporLocalidade() throws InterruptedException {

		//String 	estado    = "RIO GRANDE DO SUL", 
		//		municipio = "PORTO ALEGRE", 
		//		bairro    = "CRISTO REDENTOR                         ";
		
		this.homeAppObject.getBuscarAgencia().click();
		Report.log(Status.INFO, "Entrou Na Página Inicial dos Correios");

		this.buscarAgenciasAppObject.getLocalidadeRadialButton().click();
		Report.log(Status.INFO, "Entrou na Página De 'Busca de Agências'");
		Report.log(Status.INFO, "Buscar Agências Por Localização Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarEstadoComboBox("//*[@id=\"estadoAgencia\"]/option[24]");
		Report.log(Status.INFO, "O Estado Rio Grande do Sul Foi Selecionado");
		
		this.buscarAgenciasTask.selecionarMunicipioComboBox("//*[@id=\"municipioAgencia\"]/option[327]");
		Report.log(Status.INFO, "O Município Porto Alegre Foi Selecionado");

		this.buscarAgenciasTask.selecionarBairroComboBox("//*[@id=\"bairroAgencia\"]/option[10]");
		Report.log(Status.INFO, "O Bairro Cristo Redentor Foi Selecionado");
		
		Thread.sleep(4000);
	
		this.buscarAgenciasAppObject.getPrimeiroAgenciaDaBuscaLink().click();
		
		int size = driver.findElements(By.xpath("//*[@id=\"tableNomeAgencia\"]/tbody/tr/td[1]/a")).size();
		Boolean teste = false; 
		
		if(size != 0) {
			Report.log(Status.PASS, "A Busca Retornou Resultado", Screenshot.capture(driver));
			teste = true;
		} else {
			Report.log(Status.FAIL, "A Busca Não Retornou Nenhum Resultado", Screenshot.capture(driver));
		}
		
		assertEquals((size > 0), teste);

	}

}
