
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	private static Scanner in = new Scanner(System.in);
	static ListaClientes listaClientes;
	static ListaProdutos lista;

	public static void main(String[] args) throws IOException {
		
		listaClientes = new ListaClientes();
		lista = new ListaProdutos();
		
		int op;
		
		do {
			out.println("Menu Compras de Produtos");
			out.println("1: Adicionar cliente");
			out.println("2: Remover cliente");
			out.println("3: Adicionar produto a um cliente");
			out.println("4: Remover produto de um cliente");			
			out.println("5: Mostrar lista de clientes");
			out.println("6: Mostrar lista de compras de um cliente");
			out.println("0: Terminar programa");
			out.print("Op��o: ");
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					addCliente();
					break;			
				case 2:
					removeCliente();
					break;
				case 3:
					addProduto();
					break;			
				case 4:
//					removeProduto();
					break;
				case 5:
					printClientesList();
					break;
				case 6:
					
					break;
				case 0:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 0) out.println("Op��o inv�lida\nTente novamente\n");
			
		} while(op != 0);
		
	}
	
	private static void addCliente() throws IOException {	/////////////////////////////////////////////////////////
		
		out.println("\tSelecionou a op��o 1");
		
		String nome;
		int cc;
		String dataNasc;
		Genero genero = null;
		int opc;
		int op;
		
		
		
		do {
			out.print("\t1: Adicionar clientes atrav�s de um ficheiro\n\t2: Adicionar apenas um cliente\n\tOp��o: ");
			opc = Integer.parseInt(in.nextLine());
			
			if(opc != 1 && opc != 2) out.println("\t\tOp��o inv�lida\n\t\tTente novamente\n");
			
		} while(opc != 1 && opc != 2);
		
		if(opc == 1) {
			
			listaClientes.addCliente("src\\Files\\clientes.txt");
			out.println("\n\tClientes adicionados\n");
			
		} else {
			out.print("\n\tNome: ");
			nome = in.nextLine();
			
			out.print("\tCC: ");
			cc = Integer.parseInt(in.nextLine());
			
			out.print("\tData de nacimento (dd/mm/aaaa): ");
			dataNasc = in.nextLine();
			
			do {
				out.print("\tG�nero: \n\t\t1: Masculino\n\t\t2: Feminino\n\t\tOp��o: ");
				op = Integer.parseInt(in.nextLine());
				
				if(op != 1 && op != 2) out.println("\t\tOp��o inv�lida\n\t\tTente novamente\n");
				
			} while(op != 1 && op != 2);
			
			if(op == 1) genero = Genero.MASCULINO;
			else genero = Genero.FEMININO;
			
			listaClientes.addCliente(new Cliente(nome, cc, new Data(dataNasc), genero));
			out.println("\n\tCliente " + nome + " adicionado com sucesso\n");
		}
	}
	
	public static void removeCliente() {	/////////////////////////////////////////////////////////////
		
		out.println("\tSelecionou a op��o 2");
		
		assert listaClientes.size() > 0 : "A lista de Clientes est� vazia";
		
		int op;
		String nome;
		int cc;
		
		do {
			out.print("\tEscolher cliente a remover atrav�s de:\n\t\t1: Nome\n\t\t2: Cart�o de cidad�o\n\t\tOp��o: ");
			op = Integer.parseInt(in.nextLine());
			if(op != 1 && op != 2) out.println("\t\tOp��o inv�lida\n\tTente novamente\n");
		} while(op != 1 && op != 2);
		
		if(op == 1) {
			
			out.print("\tNome: ");
			nome = in.nextLine();
			
			for(Cliente c : listaClientes.getClientes()) {
				if(c.getNome().equals(nome)) {
					listaClientes.removeCliente(c);
					out.println("\n\tCliente " + nome + " removido com sucesso\n");
					break;
				} else {
					out.println("\n\tNenhum cliente " + nome + " na lista de clientes\n");
					break;
				}				
			}
			
		} else {
			
			out.print("\tCart�o de cidad�o: ");
			cc = Integer.parseInt(in.nextLine());
			
			for(Cliente c : listaClientes.getClientes()) {
				if(c.getCC() == cc) {
					listaClientes.removeCliente(c);
					out.println("\n\tCliente com  o CC " + cc + " removido com sucesso\n");
					break;
				} else {
					out.println("\n\tNenhum cliente com o CC " + cc + " na lista de clientes\n");
					break;
				}				
			}	
		}
	}
	
	private static void addProduto() {	//////////////////////////////////////////////////////////
		
		out.println("\tSelecionou a op��o 3");
		
		int opc;
		String nomeCliente;
		int cc;
		Cliente cliente = null;
		
		String nomeProduto;
		String marca;
		int codigoBarras;	
		boolean reutilizavel;
		String opr;
		TipoLixo tipoLixo;
		int opl;
		
		do {
			out.print("\tEscolher cliente atrav�s de:\n\t\t1: Nome\n\t\t2: Cart�o de cidad�o\n\t\tOp��o: ");
			opc = Integer.parseInt(in.nextLine());
			if(opc != 1 && opc != 2) out.println("\t\tOp��o inv�lida\n\tTente novamente\n");
		} while(opc != 1 && opc != 2);
		
		if(opc == 1) {
			
			out.print("\tNome: ");
			nomeCliente = in.nextLine();
			
			for(Cliente c : listaClientes.getClientes()) {
				if(c.getNome().equals(nomeCliente)) {
					c = cliente;
					out.println("\n\tCliente " + nomeCliente + " encontrado\n");
					
					out.println("\tInforma��es do produto:");
					out.print("\tNome: ");
					nomeProduto = in.nextLine();
					
					out.print("\tMarca: ");
					marca = in.nextLine();
					
					out.print("\tC�digo de barras: ");
					codigoBarras = Integer.parseInt(in.nextLine());
					
					do {
						out.print("\tReutiliz�vel (s/n): ");
						opr = in.nextLine();
						if(!opr.equals("s") && !opr.equals("n")) out.println("n\tOp��o inv�lida\n\tTente novamente\n");
					} while(!opr.equals("s") && !opr.equals("n"));
					
					if(opr.equals("s")) reutilizavel = true;
					else reutilizavel = false;
					
					do {
						out.print("\tTipo de lixo: \n\t\t1: Org�nico\n\t\t2: Azul\n\t\t3: Amarelo\n\t\t4: Verde\n\t\tOp��o: ");
						opl = Integer.parseInt(in.nextLine());
						
						if(opl != 1 && opl != 2 & opl != 3 && opl != 4) out.println("\t\tOp��o inv�lida\nTente novamente\n");
						
					} while(opl != 1 && opl != 2 & opl != 3 && opl != 4);
					
					if(opl == 1) tipoLixo = TipoLixo.ORGANICO;
					else if(opl == 2) tipoLixo = TipoLixo.AZUL;
					else if(opl == 3) tipoLixo = TipoLixo.AMARELO;
					else tipoLixo = TipoLixo.VERDE;
					
					c.addProduto(new Produto(nomeProduto, marca, codigoBarras, reutilizavel, tipoLixo));
					
					out.println("\n\tProduto " + nomeProduto + " adicionado com sucesso\n");
					
					break;
					
				} else {
					out.println("\n\tNenhum cliente com o nome " + nomeCliente + " na lista de clientes\n");
					break;
				}
			}
			
		} else {
			
			out.print("\tCart�o de cidad�o: ");
			cc = Integer.parseInt(in.nextLine());
			
			for(Cliente c : listaClientes.getClientes()) {
				if(c.getCC() == cc) {
					c = cliente;
					out.println("\n\tCliente com  o CC " + cc + " encontrado\n");
					
					out.println("\tInforma��es do produto:");
					out.print("\tNome: ");
					nomeProduto = in.nextLine();
					
					out.print("\tMarca: ");
					marca = in.nextLine();
					
					out.print("\tC�digo de barras: ");
					codigoBarras = Integer.parseInt(in.nextLine());
					
					do {
						out.print("\tReutiliz�vel (s/n): ");
						opr = in.nextLine();
						if(!opr.equals("s") && !opr.equals("n")) out.println("Op��o inv�lida\\nTente novamente\\n");
					} while(!opr.equals("s") && !opr.equals("n"));
					
					if(opr.equals("s")) reutilizavel = true;
					else reutilizavel = false;
					
					do {
						out.print("\tTipo de lixo: \n\t\t1: Org�nico\n\t\t2: Azul\n\t\t3: Amarelo\n\t\t4: Verde\n\t\tOp��o: ");
						opl = Integer.parseInt(in.nextLine());
						
						if(opl != 1 && opl != 2 & opl != 3 && opl != 4) out.println("\t\tOp��o inv�lida\nTente novamente\n");
						
					} while(opl != 1 && opl != 2 & opl != 3 && opl != 4);
					
					if(opl == 1) tipoLixo = TipoLixo.ORGANICO;
					else if(opl == 2) tipoLixo = TipoLixo.AZUL;
					else if(opl == 3) tipoLixo = TipoLixo.AMARELO;
					else tipoLixo = TipoLixo.VERDE;
					
					c.addProduto(new Produto(nomeProduto, marca, codigoBarras, reutilizavel, tipoLixo));
					
					out.println("\n\tProduto " + nomeProduto + " adicionado com sucesso\n");
					
					break;
				} else {
					out.println("\n\tNenhum cliente com o CC " + cc + " na lista de clientes\n");
					break;
				}				
			}	
		}
		
		
		
		
		
		
		
		
		
		
	}
	
//	private static void removeProduto() {	//////////////////////////////////////////////////////////
//		
//		out.println("\tSelecionou a op��o 4");
//		
//		assert lista.size() > 0 : "A lista de produtos est� vazia";
//		
//		String nome;
//		int op;
//		
//		do {
//			out.print("Escolher produto a remover atrav�s de:\n\t1: Nome\n\t2: C�digo de barras\n\tOp��o:");
//			op = Integer.parseInt(in.nextLine());
//			if(op != 1 && op != 2) out.println("Op��o inv�lida\nTente novamente\n");
//		} while(op != 1 && op != 2);
//		
//		if(op == 1) {
//			
//			out.print("Nome: ");
//			nome = in.nextLine();
//			
//			
//		}
//	}
	
	public static void printClientesList() {	/////////////////////////////////////////////////////////
		out.println("\tSelecionou a op��o 5");
		
		out.println("\tLista de clientes:");
		out.println("\t---------------------------------------------------------------------------------");
		String str = String.format("\t| %-20s | %-20s | %-20s | %-9s |", "Nome", "Cart�o de cidad�o", "Data de nascimento", "G�nero");
		out.println(str);
		out.println("\t----------------------------------------------------------------------------------");
		for(Cliente c : listaClientes.getClientes()) {
			out.println(c);
		}
		out.println("\t----------------------------------------------------------------------------------");
	}
		
}
