
/* OBSERVACOES
 * 
 * Codigo construido para rodar na pagina desenvolvida para a UC12, da codificacao de frontend
 * 
 * como é utilizado dominio local, é importate que altere os mesmos em caso de testes do script.
 * 
 * 
 * autor: Andre Ruan Cesar Dal Negro
 * turma: Senai - Oi
 * 
 * */

package testsFront;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.junit.Test;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

import java.lang.*;

@SuppressWarnings("unused")
public class Frontend {
	public static void main(String[] args) throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			Console console = System.console();

			// cenário 1//

			System.out.println("usuario entra na pagina");
			page.navigate("http://localhost:4200/");
			System.out.println("Pagina carregada com sucesso.");
			
			System.out.println("Iniciando rolagem para baixo");
			page.keyboard().press("PageDown");
			page.keyboard().press("PageDown");
			page.keyboard().press("PageDown");
			System.out.println("Iniciando rolagem para cima");
			page.keyboard().press("PageUp");
			page.keyboard().press("PageUp");
			page.keyboard().press("PageUp");
			
			System.out.println("Entrando na aba e login");
			page.locator("xpath=/html/body/app-root/app-header/header/div[2]/a[2]").click();
			
			System.out.println("Entrando na aba para criar conta");
			page.locator("xpath=/html/body/app-root/app-login/main/form/div[2]/button").click();
			page.locator("[ng-reflect-name='email']").fill("UsuarioDeTeste");
			page.locator("[ng-reflect-name='password']").fill("senhadeteste");
			page.locator("xpath=/html/body/app-root/app-createusr/main/div[2]/form/button").click();
			System.out.println(page.locator(".erroOnLogin").textContent());
			
			System.out.println("Entrando na aba para deletar conta");
			page.navigate("http://localhost:4200/deluser");
			page.locator("[ng-reflect-name='email']").fill("UsuarioDeTeste");
			page.locator("xpath=/html/body/app-root/app-delusr/main/div[2]/form/button").click();
			System.out.println(page.locator(".erroOnLogin").textContent());

		}
	}
}
