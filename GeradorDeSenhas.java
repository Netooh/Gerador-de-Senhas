package GeradorDesenhas;

import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorDeSenhas {
	
	private static String senha = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SecureRandom secureRandom = new SecureRandom();
		
		char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] letrasMaiusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		char[] letrasMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		char[] simbolos = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', '|', ';', ':', '\'', '"', ',', '.', '/', '<', '>', '?'};
		 
		char[][] vetores = {numeros, letrasMaiusculas, letrasMinusculas, simbolos};
		
		asciiart();
		menu();
		String resposta;
		
		do {
			senha = "";
			senha = geradorSenha(sc, vetores, secureRandom);
			avaliarSenha(senha);
			
			System.out.print("\nDeseja gerar uma nova senha? (s/n): ");
			resposta = sc.next();

		} while (resposta.equalsIgnoreCase("s"));
		
	}
	
	public static void menu() {
		System.out.println("\nBem-vindo ao Gerador de Senhas!");
		System.out.println("Este programa cria senhas seguras que incluem números, letras maiúsculas, letras minúsculas e ");
		System.out.println("símbolos especiais. Informe a quantidade de dígitos desejada para a sua senha e nós a geraremos ");
		System.out.println("para você.");
	}
	
	public static String geradorSenha(Scanner sc, char[][] vetores,SecureRandom secureRandom) {
		int digitos = 0;
		int seletorVetor;
		int seletorChar;

		System.out.print("\nQuantos digitos Deseja sua senha ? ");
		digitos = sc.nextInt();

		for (int i = 0; i < digitos; i++) {
			seletorVetor = secureRandom.nextInt(vetores.length);
			seletorChar = secureRandom.nextInt(vetores[seletorVetor].length);

			senha = senha + vetores[seletorVetor][seletorChar];
		}

		System.out.println("\n\033[1mSenha Gerada:  \033[0m" + senha);
		return senha;
	}
	
	public static void avaliarSenha(String senha) {
		if (senha.length() < 8) {
			System.out.println("\nAvaliacao = Ruim;");
			System.out.println("Essa senha é muito curta. Cuidado ao usá-la, pois pode não oferecer segurança suficiente.");
		}else if (senha.length() <= 12) {
			System.out.println("\nAvaliacao = Média;");
			System.out.println("Essa senha está legal. Oferece um nível razoável de segurança.");
		} else {
			System.out.println("\nAvaliacao = Boa;");
			System.out.println("Essa senha é forte e oferece um bom nível de segurança.");
		}
	}
	
	public static void asciiart () {
		String[] asciiArt = { "+========================================================================+",
				"|  ____                    _            ____             _               |",
				"| / ___| ___ _ __ __ _  __| | ___  _ __/ ___|  ___ _ __ | |__   __ _ ___ |",
				"|| |  _ / _ \\ '__/ _ |/ _ |/ _ \\| '__\\___ \\ / _ \\ '_ \\| '_ \\ / _ / __||",
				"|| |_| |  __/ | | (_| | (_| | (_) | |   ___) |  __/ | | | | | | (_| \\__ \\|",
				"| \\____|\\___|_|  \\__,_|\\__,_|\\___/|_|  |____/ \\___|_| |_|_| |_|\\__,_|___/|",
				"+========================================================================+" };

		for (String line : asciiArt) {
			System.out.println(line);
		}
	}

}