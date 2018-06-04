package br.pucrs.appObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaCepEnderecoAppObject {
	private WebDriver driver;

	public BuscaCepEnderecoAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCepEnderecoInput() {
		return this.driver.findElement(By.name("relaxation"));
	}
}
