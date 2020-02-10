package MPEI;

import java.util.Arrays;

public class Cliente {
	private String nome;
	private String[] habitos;
	private int cc;
	public Cliente(String nome, int cc, String[] habitos) {
		assert nome.length() > 0  && !nome.contains("[0-9]"): "Nome Invalido";
		assert Integer.toString(cc).length() == 9: "CC invalido";
		assert habitos.length > 0: "Insira habitos";
		this.nome = nome;
		this.cc = cc;
		this.habitos = habitos;
	}
	

	public String getNome() {
		return nome;
	}
	
	public String[] getHabitos() {
		return habitos;
	}

	public int getCc() {
		return cc;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cc != other.cc)
			return false;
		if (!Arrays.equals(habitos, other.habitos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cliente: nome=" + nome + ", habitos=" + Arrays.toString(habitos) + ", cc=" + cc ;
	}
	
}
