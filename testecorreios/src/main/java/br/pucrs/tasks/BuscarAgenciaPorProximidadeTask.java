package br.pucrs.tasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.BuscarAgenciasAppObject;

public class BuscarAgenciaPorProximidadeTask {
	private BuscarAgenciasAppObject buscarAgenciasAppObject;
			
	public BuscarAgenciaPorProximidadeTask(WebDriver driver) {
		this.buscarAgenciasAppObject = new BuscarAgenciasAppObject(driver);
	}
	
	public void selecionarBuscarAgenciaPorProximidade () {
		this.buscarAgenciasAppObject.getBuscarAgenciasPorProximidadeRadialButton().click();
	}
	
	public void digitarLocalizacao(String endereco) {
		this.buscarAgenciasAppObject.getBuscarAgenciaPorProximidadeDigiteEnderecoTextField().sendKeys(endereco);		
	}
	
	public void pesquisarLocalizacao() {
		this.buscarAgenciasAppObject.getBuscarAgenciaPorProximidadePesquisarButton().click();
	}
	
	public boolean verificaCarregamentodoMapa() {
		return this.buscarAgenciasAppObject.getImagemCarregamentoImg().isDisplayed();			
	}
	
	public void rolarPaginaParaVerificarMapa() {
		
					
		for(int x=1;x<=10;x++)
		{
			this.buscarAgenciasAppObject.getBuscarAgenciaPorProximidadePesquisarButton().sendKeys(Keys.ARROW_DOWN);
		} 
	
	}
	
	


}
