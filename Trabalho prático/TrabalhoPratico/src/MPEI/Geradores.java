package MPEI;

import java.util.Arrays;
import java.util.Random;

public class Geradores {
	public static String [] nomesP = { "Vitor","Miguel","João","Gabriel","Marco","António","Manuel","José","Bernardo","Tiago","Luís","Diogo","André","Pedro","Diogo", "Arnaldo","Joaquim","Henrique","Damião",
						 "Maria","Joana","Carmen","Catarina","Carolina","Lara","Elsa","Ana","Paula","Raquel","Raúl","Anacleto","Luísa","Lucia","Áfia","Florinda","Corina","Carla","Constança","Gabriela","Daniela","Daniel","Celina","Clara","Natercia","Berta",
						 "Rita","Adelaide","Bianca","Plácido","Eva", "Cristiano", "Ronaldo","Armando","Josefina","Juliana"};

	public static String [] nomesA = { "Ribeiro","Nogueira","Oliveira","Fernandes","Gomes","Pinto","Rainho","Ramos","Costa","Patacas","Silva","Portas","Vila Real","Caló","Furão","Henriques","Aveiro","Pereira","Santos","Castelhano","Neves",
						 "Pires","Araujo","Moura","Moinheiro","Freitas","Leite","Teixeira","Mendes","Barros","Domingues","Gameiro","Loureira","Graça","Almeida","Martins","Amaral","da Silva","da Mota","Mota", "Leitao", "Costeira",
						 "Fidalgo","Soares","Suazo","Silas","Barreto","Bernstein","Boavida","Domingues","Menisco","Dias","Capela","Magalhaes","Brandao"};
	
	public static String [] produtos = {"leite", "arroz", "massa", "papelhigienico", "chaverde", "chacamomila", "lapis",  "caneta", "resmas-papel", "pera", "bananas", "uvas","pessego","carapau", "ananas", "sardinha",
								 "abacaxi", "shampoo", "gel-de-banho", "melao", "meloa", "laranja", "clementina", "nespera", "racao-cao","racao-gato","racao-passaro","areia-gato", "detergente", "febra", "novilho", "peito-frango", "frango",
								 "coca-cola", "fanta", "sevenup", "compal", "kiwi", "pimenta", "acafrao","piri-piri", "guardanapos", "gelados", "rissois", "nuggets", "cerveja", "vinho-branco", "vinho-verde", "vinho-tinto", "cidra", 
								 "Whisky", "compota", "geleia", "mel", "bolachas-maria", "bolachas-chocolate", "leite-achocolatado", "iogurtes", "maca", "ervilhas", "pilhas", "couve", "alho", "alho-frances", "cenoura", "cebolas",
								 "soja", "sabonete","pasta-dentes","toalhitas","feijao-verde", "broa","pao","limpa-vidros", "mamao", "manga", "papaia","agua", "ovos"};
	
	public static String GerarNome() { // Gera nomes. Nao nos importamos muito com a correcao por isso pode surgir um nome masculino seguido de um feminino ou vice-versa. 
									  // Mesmo assim garantimos que os nomes dentro do nome nao se repetem
		int tamanho = ValorEntre(3,5);
		String nome ="";
		String nome1="";
		String nome2="";
		String nome3=""; 
		String nome4="";
		String nome5="";
		
		if(tamanho == 3) {
			nome1 = nomesP[ValorEntre(0,nomesP.length-1)];
			
			nome2 = nomesA[ValorEntre(0,nomesA.length-1)];
			
			do {
				nome3 = nomesA[ValorEntre(0,nomesA.length-1)];
			}while(nome2 == nome3);
			
			nome = nome1 + " " + nome2 + " " + nome3;
		}
		if(tamanho ==4) {
			nome1 = nomesP[ValorEntre(0,nomesP.length-1)];
			
			do {
				nome2 = nomesP[ValorEntre(0,nomesP.length-1)];
			}while(nome1 == nome2);
			
			nome3 = nomesA[ValorEntre(0,nomesA.length-1)];
			
			do {
				nome4 = nomesA[ValorEntre(0,nomesA.length-1)];
			}while(nome3 == nome4);
			
			nome = nome1 + " " + nome2 + " " + nome3 + " " + nome4;
		}
		
		if(tamanho ==5) {
			nome1 = nomesP[ValorEntre(0,nomesP.length-1)];
			
			do {
				nome2 = nomesP[ValorEntre(0,nomesP.length-1)];
			}while(nome1 == nome2);
			
			nome3 = nomesA[ValorEntre(0,nomesA.length-1)];
			
			do {
				nome4 = nomesA[ValorEntre(0,nomesA.length-1)];
			}while(nome3 == nome4);
			
			do {
				nome5 = nomesA[ValorEntre(0,nomesA.length-1)];
			}while(nome5 == nome4);
			
			nome = nome1 + " " + nome2 + " " + nome3 + " " + nome4 + " " + nome5;
			
		}
		return nome;
		
	}
	
	public static String[] GerarHabito() {
		int tamanho = ValorEntre(15,20);
		String[] habito = new String[tamanho];
		String temp = "";
		for(int i = 0; i<habito.length;i++) {
			do {
				temp = produtos[ValorEntre(0,produtos.length-1)];
			} while(Arrays.asList(habito).contains(temp)); // garantir que nome nao se repete
			habito[i] = temp;
		}
		return habito;
		
	}
	
	public static int GerarnumCC() {
		String num = Integer.toString(ValorEntre(1,9)); //primeiro não pode ser zero(?)
		
		do {
			num += Integer.toString(ValorEntre(1,9));
		}while(num.length() <9);
		
		return Integer.parseInt(num);
	}
	
	private static int ValorEntre(int min, int max) {
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
