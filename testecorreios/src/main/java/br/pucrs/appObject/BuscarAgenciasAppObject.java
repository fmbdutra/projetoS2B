package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarAgenciasAppObject {
		private WebDriver driver;
		
		public BuscarAgenciasAppObject(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement buscarAgenciasPorProximidadeRadialButton() {
			return this.driver.findElement(By.id("tipoBusca"));
		
		}
		
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
			return this.driver.findElement(By.id("submit"));
		}
		
		public WebElement buscarAgenciaPorProximidadeDigiteEnderecoTextField() {
			return this.driver.findElement(By.id("cepEndereco"));
		}
		
		public WebElement mapaLocalizacaoAgenciaMap() {
			return this.driver.findElement(By.cssSelector("map > div > div > div:nth-child(2) > a > div > img"));
		}
		
		public WebElement imagemCarregamentoImg() {
			return this.driver.findElement(By.id("imgPesquisaMap"));
		}
		
		
}
