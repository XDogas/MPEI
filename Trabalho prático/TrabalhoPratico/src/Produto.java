

public class Produto {
	
	private String nome;
	private String marca;
	private int codigoBarras;	
	private boolean reutilizavel;
	private TipoLixo tipoLixo;
	private Data dataCompra;
	
	public Produto(String nome, String marca, int codigoBarras, boolean reutilizavel, TipoLixo tipoLixo) {
		assert nome.length() > 0 : "Nome do produto inv�lido";
		assert marca.length() > 0 : "Marca do produto inv�lida";
		assert codigoBarras > 0 : "Codigo de barras do produto inv�lido";
		assert tipoLixo != null : "Tipo de lixo inv�lido";
		
		this.nome = nome;
		this.marca = marca;
		this.codigoBarras = codigoBarras;
		this.reutilizavel = reutilizavel;
		this.tipoLixo = tipoLixo;
		this.dataCompra = Data.hoje();
		
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public int getCodigoBarras() {
		return codigoBarras;
	}

	public boolean isReutilizavel() {
		return reutilizavel;
	}

	public TipoLixo getTipoLixo() {
		return tipoLixo;
	}
	
	public Data getDataCompra() {
		return dataCompra;
	}
	
	

}
