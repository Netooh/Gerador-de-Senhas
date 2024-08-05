package GeradorDesenhas;

import java.security.SecureRandom;
import java.util.Scanner;

public class GeradorDeSenhasC {
    
    // Variável global para armazenar a senha gerada
    private static String senha = "";

    public static void main(String[] args) {
        // Criação do objeto Scanner para leitura de dados do usuário
        Scanner sc = new Scanner(System.in);
        // Criação do objeto SecureRandom para gerar números aleatórios seguros
        SecureRandom secureRandom = new SecureRandom();
        
        // Definição dos arrays de caracteres para composição da senha
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] letrasMaiusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] letrasMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] simbolos = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', '|', ';', ':', '\'', '"', ',', '.', '/', '<', '>', '?'};
         
        // Array bidimensional contendo todos os vetores de caracteres
        char[][] vetores = {numeros, letrasMaiusculas, letrasMinusculas, simbolos};
        
        // Exibe uma arte ASCII para boas-vindas
        asciiart();
        // Exibe o menu de boas-vindas
        menu();
        String resposta;
        
        do {
            // Reinicia a senha a cada nova geração
            senha = "";
            // Gera a senha com base na entrada do usuário e nos vetores de caracteres
            senha = geradorSenha(sc, vetores, secureRandom);
            // Avalia a qualidade da senha gerada
            avaliarSenha(senha);
            
            // Pergunta ao usuário se ele deseja gerar uma nova senha
            System.out.print("\nDeseja gerar uma nova senha? (s/n): ");
            resposta = sc.next();

        // Continua gerando senhas enquanto o usuário responde "s"
        } while (resposta.equalsIgnoreCase("s"));
        
        // Fecha o objeto Scanner para liberar recursos
        sc.close();
    }
    
    // Exibe uma mensagem de boas-vindas e instruções para o usuário
    public static void menu() {
        System.out.println("\nBem-vindo ao Gerador de Senhas!");
        System.out.println("Este programa cria senhas seguras que incluem números, letras maiúsculas, letras minúsculas e ");
        System.out.println("símbolos especiais. Informe a quantidade de dígitos desejada para a sua senha e nós a geraremos ");
        System.out.println("para você.");
    }
    
    // Gera uma senha aleatória com base no número de dígitos desejado
    // e nos vetores de caracteres fornecidos
    public static String geradorSenha(Scanner sc, char[][] vetores, SecureRandom secureRandom) {
        int digitos = 0;
        int seletorVetor;
        int seletorChar;

        // Solicita ao usuário o número de dígitos desejados para a senha
        System.out.print("\nQuantos digitos deseja sua senha? ");
        digitos = sc.nextInt();

        // Gera a senha selecionando caracteres aleatórios dos vetores
        for (int i = 0; i < digitos; i++) {
            // Seleciona aleatoriamente um vetor de caracteres
            seletorVetor = secureRandom.nextInt(vetores.length);
            // Seleciona aleatoriamente um caractere do vetor selecionado
            seletorChar = secureRandom.nextInt(vetores[seletorVetor].length);

            // Concatena o caractere selecionado à senha
            senha = senha + vetores[seletorVetor][seletorChar];
        }

        // Exibe a senha gerada no console
        System.out.println("\n\033[1mSenha Gerada:  \033[0m" + senha);
        return senha;
    }
    
    // Avalia a segurança da senha gerada com base em seu comprimento
    public static void avaliarSenha(String senha) {
        // Verifica o comprimento da senha e fornece uma avaliação
        if (senha.length() < 8) {
            System.out.println("\nAvaliação = Ruim;");
            System.out.println("Essa senha é muito curta. Cuidado ao usá-la, pois pode não oferecer segurança suficiente.");
        } else if (senha.length() <= 12) {
            System.out.println("\nAvaliação = Média;");
            System.out.println("Essa senha está legal. Oferece um nível razoável de segurança.");
        } else {
            System.out.println("\nAvaliação = Boa;");
            System.out.println("Essa senha é forte e oferece um bom nível de segurança.");
        }
    }
    
    // Exibe uma arte ASCII decorativa no console
    public static void asciiart() {
        // Array de strings representando a arte ASCII
        String[] asciiArt = { "+========================================================================+",
                "|  ____                    _            ____             _               |",
                "| / ___| ___ _ __ __ _  __| | ___  _ __/ ___|  ___ _ __ | |__   __ _ ___ |",
                "|| |  _ / _ \\ '__/ _ |/ _ |/ _ \\| '__\\___ \\ / _ \\ '_ \\| '_ \\ / _ / __||",
                "|| |_| |  __/ | | (_| | (_| | (_) | |   ___) |  __/ | | | | | | (_| \\__ \\|",
                "| \\____|\\___|_|  \\__,_|\\__,_|\\___/|_|  |____/ \\___|_| |_|_| |_|\\__,_|___/|",
                "+========================================================================+" };

        // Imprime cada linha da arte ASCII no console
        for (String line : asciiArt) {
            System.out.println(line);
        }
    }
}