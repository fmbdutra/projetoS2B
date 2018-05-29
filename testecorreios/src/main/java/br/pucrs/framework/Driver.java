package br.pucrs.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver getFirefoxDriver(){
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}
