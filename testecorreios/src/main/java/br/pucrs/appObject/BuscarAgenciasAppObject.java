package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarAgenciasAppObject {
		private WebDriver driver;
		
		public BuscarAgenciasAppObject(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement getProximidadeRadialButton() {
			return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[1]"));
		
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
		
		public WebElement getBairroComboBox() {
			return this.driver.findElement(By.id("bairroAgencia"));
		}
		
		public WebElement getPesquisarButton() {
			return this.driver.findElement(By.id("submit"));
		}
		
		public WebElement getEnderecoTextField() {
			return this.driver.findElement(By.id("cepEndereco"));
		}
		
		public WebElement getLocalizacaoAgenciaMap() {
			return this.driver.findElement(By.cssSelector("map > div > div > div:nth-child(2) > a > div > img"));
		}
		
		public WebElement getCarregamentoImg() {
			return this.driver.findElement(By.id("imgPesquisaMap"));
		}
		
		public WebElement getLocalidadeRadialButton() {
			return this.driver.findElement(By.xpath("//*[@id=\"formBuscaAgencia\"]/div/div/div[1]/span[2]"));
		}
}