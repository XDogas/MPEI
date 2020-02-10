

import java.util.Calendar;

public class Cliente {
	
	private String nome;
	private int cc;
	private Data dataNasc;
	private Genero genero;
	private ListaProdutos listaProdutos;
	
	public Cliente(String nome, int cc, Data dataNasc, Genero genero) {
		assert nomeValido(nome) : "Nome do cliente inválido";
		assert ccValido(cc) : "Cartão de cidadão do cliente inválido";
		assert genero != null : "Género do cliente inválido";
		
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
		this.genero = genero;
		this.listaProdutos = new ListaProdutos();
	}
			
	public String getNome() {
		return nome;
	}

	public int getCC() {
		return cc;
	}

	public Data getDataNasc() {
		return dataNasc;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public Produto[] getProdutos() {
		return listaProdutos.getProdutos();
	}
		
	public int listaProdutosSize() {
		return listaProdutos.size();
	}

	public static boolean nomeValido(String nome) {
		return nome.length() > 0;
	}
	
	public static boolean ccValido(int cc) {
		return cc >= 0;
	}
	
	public void addProduto(Produto p) {
		listaProdutos.addProduto(p);
	}
	
	public void removeProduto(Produto p) {
		listaProdutos.removeProduto(p);
	}
	
	public int getIdade(){
		Calendar todayDate = Calendar.getInstance();
		int idade = todayDate.get(Calendar.YEAR) - this.dataNasc.getAno();
	    if (this.dataNasc.getMes() > todayDate.get(Calendar.MONTH) + 1 || (this.dataNasc.getMes() == todayDate.get(Calendar.MONTH) + 1 && this.dataNasc.getDia() > todayDate.get(Calendar.DAY_OF_MONTH))) {
	        idade--;
	    }
	    return idade;
	}
	
	@Override
	public String toString() {		
		return String.format("\t| %-20s | %-20s | %-20s | %-9s |", this.nome, this.cc, this.dataNasc.toString(), this.genero);
				 
	}

	
	
}

