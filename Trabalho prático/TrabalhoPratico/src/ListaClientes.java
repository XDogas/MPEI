
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListaClientes {
	
	private ArrayList<Cliente> listaClientes;
	
	public ListaClientes() {
		listaClientes = new ArrayList<Cliente>();
	}
	
	public void addCliente(Cliente c) {
		listaClientes.add(c);
	}
	
	public void addCliente(String filePath) throws IOException {
		List<String> l = readFileInList(filePath);
		  
		Iterator<String> itr = l.iterator(); 
		while (itr.hasNext()) {
			
			String line = itr.next();
			
			String nome = line.split("\t")[0];
			int cc = Integer.parseInt(line.split("\t")[1]);
			String dataNascStr = line.split("\t")[2];
			Data dataNasc = new Data(dataNascStr);
			Genero genero = null;
			if(line.split("\t")[3].equals("masculino")) genero = Genero.MASCULINO;
			else if(line.split("\t")[3].equals("feminino")) genero = Genero.FEMININO;			
			
			this.addCliente(new Cliente(nome, cc, dataNasc, genero));
		}
	}
	
	public static List<String> readFileInList(String fileName) throws IOException {
	  
		List<String> lines = Collections.emptyList(); 
		lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		
		return lines; 
	  } 
	
	public void removeCliente(Cliente c) {
		assert !listaClientes.isEmpty() : "A lista de clientes está vazia";
		listaClientes.remove(c);
	}
	
	public int size() {
		return listaClientes.size();
	}
	
	public Cliente[] getClientes() {
		assert !listaClientes.isEmpty() : "A lista de compras está vazia";
		return listaClientes.toArray(new Cliente[size()]);
	}
}