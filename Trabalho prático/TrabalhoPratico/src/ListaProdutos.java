
import java.util.ArrayList;

public class ListaProdutos {
	
	private ArrayList<Produto> listaProdutos;
	
	public ListaProdutos() {
		listaProdutos = new ArrayList<Produto>();
	}
	
	public void addProduto(Produto p) {
		listaProdutos.add(p);
	}
	
	public void removeProduto(Produto p) {
		assert !listaProdutos.isEmpty() : "A lista de compras est� vazia";
		listaProdutos.remove(p);
	}
	
	public int size() {
		return listaProdutos.size();
	}
	
	public Produto[] getProdutos() {
		assert !listaProdutos.isEmpty() : "A lista de compras est� vazia";
		return listaProdutos.toArray(new Produto[size()]);
	}

}
