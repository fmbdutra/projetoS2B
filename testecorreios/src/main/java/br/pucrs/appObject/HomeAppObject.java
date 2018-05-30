package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAppObject {
	private WebDriver driver;
	
	public HomeAppObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getFonteDoTexto() {
		WebElement tamanhoFonte = this.driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/ul/li[1]/a"));
		return tamanhoFonte;
	}
	
	public WebElement getAumentaTextoButton() {
		return this.driver.findElement(By.id("txt-aumenta1"));
	}
	
	public WebElement getDiminuiTextoButton() {
		return this.driver.findElement(By.id("txt-diminuir1"));
	}
	
	public WebElement getEnglishButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"list-idiomas\"]/ul/li[1]/a"));
	}
	
	public WebElement getEspanholButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"list-idiomas\"]/ul/li[2]/a"));
	}
	
	public WebElement getTrackAndTrace() {
		return this.driver.findElement(By.xpath("//*[@id=\"rastreamento-obj\"]/form/div[1]/label/strong"));
	}
	
	public WebElement getBuscarAgencia() {
		return this.driver.findElement(By.cssSelector("#content-servicos > ul > li:nth-child(5) > div.acao > a"));
	}
		
}


