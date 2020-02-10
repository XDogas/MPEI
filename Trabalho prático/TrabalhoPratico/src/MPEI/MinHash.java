package MPEI;

import java.util.*;

public class MinHash {
	private int nhashFunc;				//numero de hash functions
	private int[] seeds;  				// seeds que vao servir como funçao de hash
	public MinHash(int nhashFunc) {
		this.nhashFunc = nhashFunc;
		seeds =  HashSeeds(nhashFunc);
	}



	//PUBLIC 
	/*
	 *metodo jaccard para quando
	 *queremos trabalhar com shingles de tamanho k 
	 */
	public double jaccard(String str1,String str2,int k) {

		int[] hashArray1 = ShinglestoHashes(toShingle(str2,k));
		int[] hashArray2 = ShinglestoHashes(toShingle(str1,k));
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();

		for(int e : hashArray1) {
			set1.add(e);
		}

		for(int f : hashArray2) {
			set2.add(f);
		}

		Set<Integer> intersecao = new TreeSet<Integer>();
		intersecao.addAll(set1);
		intersecao.retainAll(set2);

		Set<Integer> uniao = new TreeSet<Integer>();
		uniao.addAll(set1);
		uniao.addAll(set2);

		if (uniao.isEmpty()) {
			return 0;
		}

		return (double) intersecao.size() / (double )uniao.size();
	}
	/*
	 * metodo jaccard para quando
	 * queremos trabalhar com as palavras inteiras
	 * 
	 */
	public double jaccard(String str1,String str2) {

		int[] hashArray1 = ShinglestoHashes(toShingle(str2));
		int[] hashArray2 = ShinglestoHashes(toShingle(str1));
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();

		for(int e : hashArray1) {
			set1.add(e);
		}

		for(int f : hashArray2) {
			set2.add(f);
		}

		Set<Integer> intersecao = new TreeSet<Integer>();
		intersecao.addAll(set1);
		intersecao.retainAll(set2);

		Set<Integer> uniao = new TreeSet<Integer>();
		uniao.addAll(set1);
		uniao.addAll(set2);

		if (uniao.isEmpty()) {
			return 0;
		}

		return (double) intersecao.size() / (double )uniao.size();
	}

	/*
	 * metodo toshingle que aceita um argumento 
	 * para tornar a string em k-shingles
	 * 
	 */
	public Set<String> toShingle(String str, int length) {		

		Set<String> shingles = new TreeSet<String>();

		for(int i = 0; i+length <= str.length(); i++) {
			shingles.add(str.substring(i, i+length));
		}

		return shingles;
	}

	/*
	 * metodo toshingle que trabalha com as palavras inteiras separadas por espaço
	 */
	public Set<String> toShingle(String str) {						
		String[] array = str.split(" ");
		Set<String> shingles = new TreeSet<String>(Arrays.asList(array));
		return shingles;
	}


	//PRIVATE 
	/* 
	 * Passa as shingles para hash
	 * preenchendo assim um array de 2d
	 * 
	 */
	private  int[] ShinglestoHashes(Set<String> shingles){

		int[] minHashes = new int[nhashFunc];
		int[][] hashes = new int[shingles.size()][nhashFunc] ;		//array 2 dimensoes : Linhas têm o mesmo número de hashfunction, Colunas têm o mesmo numero que o tamanho dos shingles
		Iterator<String> iterator = shingles.iterator();


		for(int i = 0; i < shingles.size(); i++) {					//Preenche o array em que cada linha tem os "nhashFunc" valores resultantes da shingle daquela linha transformada pela hashFunction
			String temp = iterator.next();
			for(int j=0; j < nhashFunc;j++) {
				hashes[i][j] = temp.hashCode() ^ seeds[j];			//aplica o hashcode seguido de xor com as seeds previamente geradas
			}
		}
		minHashes = Calculateminhash(hashes,shingles,nhashFunc);
		return minHashes;
	}

	/* 
	 * Determina os valores minimos do
	 * array gerados anteriormente
	 */
	private int[] Calculateminhash(int[][] hashes,Set<String> shingles,int nhashFunc) {			
		int min = Integer.MAX_VALUE;
		int[] minHashes = new int[nhashFunc];
		for(int j = 0;j  < nhashFunc; j++) {				
			min = Integer.MAX_VALUE;
			for(int i=0; i < shingles.size() ;i++) {
				min = Math.min(min, hashes[i][j]);
			}
			minHashes[j] = min;
		}
		return minHashes;
	}


	// hashfunction
	private  int hashFunction(String str) { //Nao funcionou muito bem no caso do minhash(por isso termos optado pelo hashcode do java mas resultou bem no bloom filter 
		int hash = 7;
		for (int i = 0; i < str.length(); i++) {
			hash = hash*31 + str.charAt(i);
		}
		return hash;
	}

	//Gerador de seeds
	private static int[] HashSeeds(int nHash) { //gera valores de seed que serao xor com o hash do shingle
		int [] seeds = new int [nHash];
		for (int i=0; i<nHash; i++) {
			seeds[i] = ValorEntre(-900000000, 900000000);
		}
		return seeds;
	}

	private static int ValorEntre(int min, int max) {

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
