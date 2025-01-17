package MPEI;

import java.util.*;


public class MinHashTeste {

	public static void main(String[] args) 
		{int numHashFunc = 50; 	//fun��oes de hash	
		MinHash minhash = new MinHash(numHashFunc);
		
		//Teste com palavras predefinidas
		System.out.println("Teste com frases predefinidas");
					
		
		
		String str1 = "rato roeu a garrafa";
		String str2 = "girafa bateu com a cabe�a";
		String str3 = "roeu a garrafa";
		String str4 = "rato roeu a garrafa";
		String str5 = "manga couve vinho-tinto cerveja soja melao detergente alho nespera sardinha papaia pasta-dentes piri-piri pimenta nuggets clementina";
		String str6 = "vinho-verde nuggets pilhas cidra abacaxi leite-achocolatado alho-frances ervilhas fanta laranja";

		Set<String> set1 = minhash.toShingle(str1);
		Set<String> set2 = minhash.toShingle(str2);
		Set<String> set3 = minhash.toShingle(str3);
		Set<String> set4 = minhash.toShingle(str4);
		
		System.out.println(Arrays.toString(set1.toArray()));
		System.out.println(Arrays.toString(set2.toArray()));
		System.out.println(Arrays.toString(set3.toArray()));
		System.out.println(Arrays.toString(set4.toArray()));
		
		System.out.print("Similariedade entre \"" + str1 + "\" e \""+ str2 + "\": ");System.out.printf("%.2f%%\n", 100 * minhash.jaccard(str1, str2)); // D� 0 porque a shingle "a" raramente � o valor mais pequeno depois de passar na hashfunction
		System.out.print("Similariedade entre \"" + str1 + "\" e \""+ str4 + "\": ");System.out.printf("%.2f%%\n", 100 * minhash.jaccard(str1, str4));
		System.out.print("Similariedade entre \"" + str1 + "\" e \""+ str3 + "\": ");System.out.printf("%.2f%%\n", 100 * minhash.jaccard(str1, str3));
		System.out.print("Similariedade entre str5 e str6: "); 						 System.out.printf("%.2f%%\n", 100 * minhash.jaccard(str5, str6));
		
		
		
		
		//Teste com strings random
		System.out.println("\nTeste com strings random:");
		int k = 2; //k-shingles
		int N = 100000;
		double parecenca = 0.10;			//percentagem de parecen�a aceitavel (10%)
		String stringmain = randString(); 	//String que vai ser comparada com as outras
		int parecidos = 0; 					//counter para o numero de elementos parecidos com a stringmain
		System.err.println("Loading...");
		for(int i = 0; i < N; i++) {
			String random = randString();
			double jaccindex = minhash.jaccard(random,stringmain,k);
			if(jaccindex>= parecenca) 
				parecidos++;
		}
		System.err.println("Done!");
		
		System.out.println("N�mero de strings que sao " + 100 * (double)parecenca + "% semelhantes: " + parecidos);

	}
	
	
		//Gerador de strings e afins
		public static String randString() {
			char[] alfabeto = {'a','b', 'c', 'd','e','f' ,'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			StringBuilder s = new StringBuilder();
			int comp = ValorEntre(50,100);
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
