package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarAgenciasAppObject {
		private WebDriver driver;
		
		public BuscarAgenciasAppObject(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement getBuscarAgenciasPorProximidadeRadialButton() {
			return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[1]"));
		
		}
		
<<<<<<< HEAD
		public WebElement getServicoRadialButton() {
			return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[3]/label"));
		}
		
		public WebElement getEstadoComboBox() {
			return this.driver.findElement(By.id("estadoAgencia"));
		}
		
		public WebElement getMunicipioComboBox() {
			return this.driver.findElement(By.id("municipioAgencia"));
		}
		ptubli WebElement getBairroComboBox() {
			return this.driver.findElement(By.id("bairroAgencia"));
		}
		
		public WebElement buscarAgenciaPorProximidadePesquisarButton() {
=======
		public WebElement getBuscarAgenciaPorProximidadePesquisarButton() {
>>>>>>> cf96a988ffd8d18112e92e6fcbc81bfa7d066fc9
			return this.driver.findElement(By.id("submit"));
		}
		
		public WebElement getBuscarAgenciaPorProximidadeDigiteEnderecoTextField() {
			return this.driver.findElement(By.id("cepEndereco"));
		}
		
		public WebElement getMapaLocalizacaoAgenciaMap() {
			return this.driver.findElement(By.cssSelector("map > div > div > div:nth-child(2) > a > div > img"));
		}
		
		public WebElement getImagemCarregamentoImg() {
			return this.driver.findElement(By.id("imgPesquisaMap"));
		}
		
		public WebElement getBuscarAgenciasPorLocalidadeRadialButton() {
			return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[2]"));			
		}
		
		public WebElement getBuscarAgenciasPorLocalidadeEServicoEstadoComboBox() {
			return this.driver.findElement(By.id("estadoAgencia"));
		}
		
		public WebElement getBuscarAgenciasPorLocalidadeEServicoMunicipioComboBox() {
			return this.driver.findElement(By.id("municipioAgencia"));
		}
		
		public WebElement getBuscarAgenciasPorLocalidadeEServicoBairroComboBox() {
			return this.driver.findElement(By.id("bairroAgencia"));
		}
		

		
	
		
		
}
