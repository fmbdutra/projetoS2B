package br.pucrs.verificationPoints;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import br.pucrs.framework.Report;
import br.pucrs.framework.Screenshot;
import br.pucrs.pageObject.HomePage;
import br.pucrs.tasks.ContrasteTask;

public class ContrasteDaPaginaVerificationPoint {
	private WebDriver driver;
	private ContrasteTask contrasteTask;
	private HomePage homeAppObject;
	
	boolean expected;

	public ContrasteDaPaginaVerificationPoint(WebDriver driver) {
		this.driver = driver;
		this.contrasteTask = new ContrasteTask(driver);
		this.homeAppObject = new HomePage(driver);
	}

	private void errorContraste() {
		Report.log(Status.FAIL, "A Página Não Apresenta Modo Contraste por Completo", Screenshot.capture(driver));
	}

	public void checarFuncaoContraste() throws InterruptedException {
		
		String  fundoCab = this.homeAppObject.getCorCabecalhoHtml().getCssValue("background-color"),
				fundoOpc = this.homeAppObject.getCorOpcoesHtml().getCssValue("backgroud-color"),
				fundoSol = this.homeAppObject.getCorSolucoesHtml().getCssValue("backgroud-color"), 
				fundoFim = this.homeAppObject.getCorFimHtml().getCssValue("backgroud-color"),
				fundoRod = this.homeAppObject.getCorRodapeHtml().getCssValue("background-color");

		String  letraCab = this.homeAppObject.getCorCabecalhoHtml().getCssValue("color"),
				letraOpc = this.homeAppObject.getCorOpcoesHtml().getCssValue("color"),
				letraSol = this.homeAppObject.getCorOpcoesHtml().getCssValue("color"), 
				letraFim = this.homeAppObject.getCorFimHtml().getCssValue("color"),
				letraRod = this.homeAppObject.getCorRodapeHtml().getCssValue("color");		

		// this.driver.wait(2000);
		Thread.sleep(2000);

		this.contrasteTask.percorrePagina();

		if (fundoCab == "#000 !important" || fundoCab == "black") {
			Report.log(Status.INFO, "O Fundo em Preto Foi Apresetando no Cabeçalho da Página",
					Screenshot.capture(driver));

			this.contrasteTask.percorrePagina();

			if (fundoOpc == "#000 !important" || fundoOpc == "black") {
				Report.log(Status.INFO, "O Fundo em Preto Foi Apresetando nas Opções", Screenshot.capture(driver));

				this.contrasteTask.percorrePagina();

				if (fundoSol == "#000 !important" || fundoSol == "black") {
					Report.log(Status.INFO, "O Fundo em Preto Foi Apresetando nas 'Soluções que Se Aproximam'",
							Screenshot.capture(driver));

					this.contrasteTask.percorrePagina();
					
					if (fundoFim == "#000 !important" || fundoFim == "black") {
						Report.log(Status.INFO, "O Fundo em Preto Foi Apresetando no Fim da Página",
								Screenshot.capture(driver));

						this.contrasteTask.percorrePagina();
						
						if (fundoRod == "#000 !important" || fundoRod == "black") {
							Report.log(Status.INFO, "O Fundo em Preto Foi Apresetando no Rodapé Página",
									Screenshot.capture(driver));

							if (letraCab != "#000 !important" || letraCab != "black") {
								Report.log(Status.INFO, "O Texto em Branco Foi Apresetando no Cabeçalho da Página",
										Screenshot.capture(driver));
								if (letraOpc != "#000 !important" || letraOpc != "black") {
									Report.log(Status.INFO, "O Texto em Branco Foi Apresetando nas Opções",
											Screenshot.capture(driver));
									if (letraSol != "#000 !important" || letraSol != "black") {
										Report.log(Status.INFO,
												"O Texto em Branco Foi Apresetando nas 'Soluções que Se Aproximam'",
												Screenshot.capture(driver));
										if (letraFim != "#000 !important" || letraFim != "black") {
											Report.log(Status.INFO,
													"O Texto em Branco Foi Apresetando no Fim da Página",
													Screenshot.capture(driver));
											if (letraRod != "#000 !important" || letraRod != "black") {
												Report.log(Status.INFO,
														"O Texto em Branco Foi Apresetando no Rodapé Página",
														Screenshot.capture(driver));

												Report.log(Status.PASS,
														"Toda a Página Inicial foi Apresentada em Alto Contraste",
														Screenshot.capture(driver));
												expected = true;
											}

										}
									}
								}
							}
						}

					}
				}
			}
		}

		else {
			errorContraste();
			expected = false;
		}

		assertTrue("A Página Não Apresenta Modo Contraste por Completo", this.expected);

	}
}
