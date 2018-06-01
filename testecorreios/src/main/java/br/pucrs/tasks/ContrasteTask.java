package br.pucrs.tasks;

import org.openqa.selenium.WebDriver;

import br.pucrs.appObject.HomeAppObject;

public class ContrasteTask {
	
	private HomeAppObject homeAppObject;
	
	public ContrasteTask(WebDriver driver) {
		this.homeAppObject = new HomeAppObject(driver);
	}

}
