package testsFront;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.junit.Test;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

import java.lang.*;

@SuppressWarnings("unused")
public class PageHome {
	public static void main(String[] args) throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			Console console = System.console();

			// cenário 1//

			System.out.println("usuario entra na pagina");
			page.navigate("https://online.sp.senai.br/");

			// botao de pesquisa é pressionado

			System.out.println("Campo de pesquisa é selecionado");

			page.locator("#Busca1_txtFiltro").click();

			System.out.println("Curso pesquisado");

			// page.keyboard().insertText("Programação");

			String[] lista = { 
					"tecnologia", 
					"Automação", 
					"programacao", 
					"Comunicação", 
					"Computador" , 
					"Desvendando a Blockchain",
					"Desvendando a Indústria 4.0",
					"Desvendando o 5g",
					"Desvendando o Bim",
					"Economia Circular em Espanhol",
					"Economia Circular em Português",
					"Empreender Senai",
					"Preparação para o Mercado de Trabalho",
					"Privacidade e Proteção de Dados (LGPD)",
					"Veículos Elétricos e Híbridos",
					"Competências transversais",
					"Consumo Consciente de Energia",
					"Educação Ambiental",
					"Excel Básico",
					"Finanças Pessoais",
					"Fundamentos da Logística",
					"Lógica de Programação",
					"Metrologia",
					"Noções Básicas de Mecânica Automotiva",
					"Propriedade Intelectual",
					"Segurança no Trabalho",
					"Tecnologia da Informação e Comunicação",
					"Administração",
					"Ciências Contábeis",
					"Ciências Econômicas",
					"Comércio Exterior (tecnológico)",
					"Design de Moda",
					"Gastronomia (tecnológico)",
					"Gestão Comercial (tecnológico)",
					"Gestão da Qualidade (tecnológico)",
					"Gestão de Recursos Humanos (tecnológico)",
					"Gestão Financeira (tecnológico)",
					"Jornalismo",
					"Logística (tecnológico)",
					"Marketing (tecnológico)",
					"Processos Gerenciais (tecnológico)",
					"Publicidade e Propaganda",
					"Rádio, TV e Internet",
					"Relações Internacionais",
					"Relações Públicas",
					"Segurança no Trabalho",
					"Ciências Biológicas e da Saúde",
					"Biomedicina",
					"Ciências biológicas",
					"Ciências biológicas (licenciatura)",
					"Educação física (bacharelado)",
					"Educação física (licenciatura)",
					"Enfermagem",
					"Estética e cosmética (tecnológico)",
					"Farmácia",
					"Fisioterapia",
					"Gestão ambiental (tecnológico)",
					"Gestão hospitalar",
					"Medicina veterinária",
					"Nutrição",
					"Odontologia",
					"Psicologia",
					"Radiolox"
			};

//			for (int i = 0; i < lista.length; i++) {
//				
//				page.locator("#Busca1_txtFiltro").fill(lista[i]);
//
//				page.keyboard().press("Enter");
//
//				String response = page.locator(".lead").textContent();
//				
//				System.out.println("-----------------------" + "\n" + "Curso m pesquisa:" + lista[i] + "\n" + "Lead: " + response + "\n" + "Totalidade verdadeira: " + page.locator(".curso").allTextContents().size());
//			};
			
			//inicia-se testes dos botoes laterais.
			
			String[] nome_lateral = {
					"Home",
					"Institucional",
	
					"Atendimento às Empresas",
					"Galeria de Vídeos",
					"2ª VIA DE BOLETO",
			};
			for (int i = 0; i < nome_lateral.length; i++) {
				page.navigate("https://online.sp.senai.br/");
				List<String> botoes = page.locator("#nav").allTextContents();
				System.out.println(botoes);
//				page.locator(String.format("#%s", nome_lateral[i])).click();
				page.locator(String.format("[title='%s']", nome_lateral[i])).click();
//				System.out.printf();
				
			}
			page.navigate("https://online.sp.senai.br/");
			page.close();
			
			



		}
	}
}
