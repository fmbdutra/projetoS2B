package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultadoBuscaCepEnderecoAppObject {
	private WebDriver driver;
	
	public ResultadoBuscaCepEnderecoAppObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTextoResultadoBusca() {
		return this.driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/p"));
	}
}
