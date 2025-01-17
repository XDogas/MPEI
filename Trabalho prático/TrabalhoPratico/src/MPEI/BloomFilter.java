package MPEI;

import java.util.Arrays;

public class BloomFilter {
	
	private boolean[] filtro; 		// o filtro
	private int	nE = 0; 			// n elementos no filtro	
	private int k; 					// numero de hashfunctions
	private int size;				// Tamanho bloomfilter

	
	//Construtor
	
	public BloomFilter(int n) { 	//quantos elementos pretende o utilizador inserir
		
		int size = (int)Math.round(((-n*Math.log(0.01))/Math.pow((Math.log(2)),2)));  // numero de elementos que o bloom filter deve ter
		filtro = new boolean[size];	
		k = (int)Math.ceil((size/n) * Math.log(2));
	}
	


	public int getK() {
		return k;
	}


	public int getnE() {
		return nE;
	}


	public int getSize() {
		return size;
	}
	
	/* 
	 * Atribui as posi��es
	 * ao elemento que passa por k hashfunctions
	 */
	

	private int[] FiltroPosicoes(String str) {
		int[] posicao = new int[k];
		String str_accum = str;
		
		for(int i=1; i<=k; i++) {
			
			int hash = Math.abs(hash_function(str_accum));
			posicao[i-1] =  Math.abs((hash % filtro.length));
			str_accum = str_accum + i;
		}
		return posicao;
	}
	
	/*
	 * Verifica se o argumento 
	 * podera ja estar no filtro
	 * 
	 */
	
	public boolean Filtroismember(String str) {
		int[] posicao = FiltroPosicoes(str);
		for(int i=0; i<posicao.length; i++) {
			if (filtro[posicao[i]]!=true) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Insere o argumento no bloomfilter
	 */
	
	public void Filtroinserir(String str) {
		
		int [] posicao = FiltroPosicoes(str);
		for(int i=0; i<posicao.length;i++) {
			filtro[posicao[i]]=true;
		}
		nE++;
		
	}
	

	@Override
	public String toString() { 
		return "Bloom Filter\n" + 
								"Tamanho do filtro  =  " +  filtro.length + ";\n" + 
								"N�mero Elementos  =  " +  nE + ";\n" + 
								"N�mero de Hash Functions  =  " + k + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloomFilter other = (BloomFilter) obj;
		if (!Arrays.equals(filtro, other.filtro))
			return false;
		if (k != other.k)
			return false;
		if (size != other.size)
			return false;
		if (nE != other.nE)
			return false;
		return true;

	}	
	// hashfunction
	private  int hash_function(String str) {
		int hash = 7;
		for (int i = 0; i < str.length(); i++) {
		    hash = hash*31 + str.charAt(i);
		}
		return hash;
	}
	
	
}
