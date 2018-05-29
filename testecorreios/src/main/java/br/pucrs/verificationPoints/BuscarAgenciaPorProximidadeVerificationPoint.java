package br.pucrs.verificationPoints;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.tasks.BuscarAgenciaPorProximidadeTask;
import br.pucrs.tasks.BuscarAgenciasTask;

public class BuscarAgenciaPorProximidadeVerificationPoint {

	private WebDriver driver;

	private BuscarAgenciasTask buscarAgenciasTask;
	private BuscarAgenciaPorProximidadeTask buscarAgenciaPorProximidadeTask;

	public BuscarAgenciaPorProximidadeVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.buscarAgenciasTask = new BuscarAgenciasTask(driver);
		this.buscarAgenciaPorProximidadeTask = new BuscarAgenciaPorProximidadeTask(driver);
	}

	public void checarEnderecoDaAgenciaNoMapa() throws InterruptedException {
		this.buscarAgenciasTask.apertarBotaoBuscarAgencia();

		this.buscarAgenciaPorProximidadeTask.selecionarBuscarAgenciaPorProximidade();

		Report.log(Status.INFO, "Buscar Agências Por Proximidade Foi Selecionado");
		String enderecoBuscado = "Rodovia RS 118, 11800 - Maria Regina, Alvorada - RS, 94834-670";

		this.buscarAgenciaPorProximidadeTask.digitarLocalizacao(enderecoBuscado);
		Report.log(Status.INFO, "Buscou Endereço " + enderecoBuscado);

		this.buscarAgenciaPorProximidadeTask.pesquisarLocalizacao();
		Report.log(Status.INFO, "O Botão 'Pesquisar' foi Pressionado");

		Report.log(Status.INFO, "A marcação deve exibir a agência mais próxima do endereço pesquisado");

		while (this.buscarAgenciaPorProximidadeTask.verificaCarregamentodoMapa()==true) {

			Thread.sleep(1000);

		}

		Screenshot.capture(driver);

		Report.log(Status.WARNING, "Verificar no captura de tela");

	}

}
