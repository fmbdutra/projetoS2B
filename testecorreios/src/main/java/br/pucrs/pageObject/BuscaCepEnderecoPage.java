package br.pucrs.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscaCepEnderecoPage {
	private WebDriver driver;

	public BuscaCepEnderecoPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCepEnderecoInput() {
		return this.driver.findElement(By.name("relaxation"));
	}
}
