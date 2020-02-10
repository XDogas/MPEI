package MPEI;

import java.util.Random;
import java.util.Scanner;

public class BloomFilterTeste {
	static Scanner read = new Scanner(System.in);
	public static void main(String[] args) {
		//Teste bÃ¡sico
		BloomFilter BF1 = new BloomFilter(10);
		String nome1= "Gabriel Ribeiro";
		BF1.Filtroinserir(nome1);
		String nome2 = "João Oliveira";
		BF1.Filtroinserir(nome2);
		String nome3 = "Miguel Nogueira";
		BF1.Filtroinserir(nome3);
		String nome4 = "Gabriel Ribeiro";
		if(BF1.Filtroismember(nome4))
			System.out.println(nome4 + " já está na lista");
	
		//teste com nomes gerados aleatoriamente
		String [] nomesP = { "Vitor","Miguel","João","Gabriel","Marco","António","Manuel","José","Bernardo","Tiago","Luís","Diogo","André","Pedro","Diogo", "Arnaldo","Joaquim","Henrique","Damião",
							 "Maria","Joana","Carmen","Catarina","Carolina","Lara","Elsa","Ana","Paula","Raquel","Raúl","Anacleto","Luísa","Lúcia","Áfia","Florinda","Corina","Carla","Constança","Gabriela","Daniela","Daniel","Celina","Clara","Natercia","Berta",
							 "Rita","Adelaide","Bianca","Plácido","Eva", "Cristiano", "Ronaldo","Armando","Josefina","Juliana"};
		
		String [] nomesA = { "Ribeiro","Nogueira","Oliveira","Fernandes","Gomes","Pinto","Rainho","Ramos","Costa","Patacas","Silva","Portas","Vila Real","Caló","Furão","Henriques","Aveiro","Pereira","Santos","Castelhano","Neves",
						 	"Pires","Araujo","Moura","Moinheiro","Freitas","Leite","Teixeira","Mendes","Barros","Domingues","Gameiro","Loureira","Graça","Almeida","Martins","Amaral","da Silva","da Mota","Mota", "Leitão", "Costeira",
						 	"Fidalgo","Soares","Suazo","Silas","Barreto","Bernstein","Boavida","Domingues","Menisco","Dias","Capela","Magalhães","Brandão"};
		
		int countfp1 = 0;
		int n = 10000;
		BloomFilter BF2 = new BloomFilter(n);
		
		for(int i = 0; i<n; i++) {
			String nome = nomesP[ValorEntre(0,nomesP.length-1)] + " " + nomesP[ValorEntre(0,nomesP.length-1)] + " " + nomesA[ValorEntre(0,nomesA.length-1)] + " " + nomesA[ValorEntre(0,nomesA.length-1)];
			BF2.Filtroinserir(nome);
					
		}
			
		for(int m = 0; m<n; m++) {
			String nomet = nomesP[ValorEntre(0,nomesP.length-1)] + " " + nomesP[ValorEntre(0,nomesP.length-1)] + " " + nomesA[ValorEntre(0,nomesA.length-1)] + " " + nomesA[ValorEntre(0,nomesA.length-1)];
			if(BF2.Filtroismember(nomet)) {
				countfp1++;
				//System.out.println(nomet); //tirar o comentário para ver os nomes possivelmente repetidos
			}
				
		}
		double prob1_fp = 100*((double)countfp1/(double)n);
		System.out.printf("\n(Teste com os nomes)Probabilidade de falsos positivos  %.4f%% :\n" , prob1_fp); 		
		System.out.println("A probabilidade de falsos positivos foi definida quando criamos o bloom filter. \nEsta é 0.1 que corresponde ao valor apresentado");
		System.out.println("\n" + BF2.toString());	
		
		// Teste com strings geradas aleatoriamente. BloomFilter com tamanho substancialmente maior devido a sua maior aleatoriadade
		n = 100000;
		BloomFilter BF3 = new BloomFilter(n);
		int countfp2 = 0;
		
		for(int i = 0; i<n; i++) {
			
			String nome = randString();
			BF3.Filtroinserir(nome);
					
		}
			
		for(int m = 0; m<n; m++) {
			String nomet = randString();
			if(BF3.Filtroismember(nomet)) {
				countfp2++;
			}
				
		}
		
		double prob2_fp = 100*((double)countfp2/(double)n);
		System.out.printf("(Teste com strings random)Probabilidade de falsos positivos  %.4f%% :" , prob2_fp); 
		System.out.println("\nA probabilidade de falsos positivos foi definida quando criamos o bloom filter. \nEsta é 0.1 que corresponde ao valor apresentado");
		System.out.println("\n" + BF3.toString());
	}
	
	// MÃ©todos adicionais para os testes
	public static String randString() {
		char[] alfabeto = {'a','b', 'c', 'd','e','f' ,'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		StringBuilder s = new StringBuilder();
		int comp = ValorEntre(10,20);
		for (int i = 0; i < comp; i++) {
		    char c = alfabeto[ValorEntre(0,alfabeto.length-1)];
		    s.append(c);
		}
		return s.toString();
	}
	public static int ValorEntre(int min, int max) {
		
			Random r = new Random();
			return r.nextInt((max - min) + 1) + min;
	}

}
