package MPEI;
import java.util.*;

public class Main {
	static Scanner ler = new Scanner(System.in);
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static MinHash minhash = new MinHash(50);
	static BloomFilter bloomfilternome = new BloomFilter(300);
	static BloomFilter bloomfiltercc = new BloomFilter(300);
	public static void main(String[] args) {


		int op;
		do {
			System.out.println("\nMenu");
			System.out.println("1: Adicionar cliente");
			System.out.println("2: Mostrar lista de clientes");
			System.out.println("3: Mostrar lista de compras de um cliente");
			System.out.println("4: Gerar 5 Clientes");
			System.out.println("5: Encontrar Semelhantes");
			System.out.println("6: Numero de clientes na base de dados");
			System.out.println("0: Terminar programa");
			System.out.print("Op��o: ");
			op = ler.nextInt();

			switch(op) {
			case 1:
				addCliente();
				break;	
			case 2:
				printClientesList();
				break;
			case 3:
				printHabitos();
				break;
			case 4: 
				gerarClientes();
				break;
			case 5:
				encontrarSemelhantes();
				break;
			case 6:
				System.out.println(clientes.size());
				break;
			case 0:
				System.out.print("Terminar programa");
				System.exit(0);
				break;
			}

			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 6 && op != 0) 
				System.out.println("Opção inválida\nTente novamente\n");

		} while(op != 0);


	}

	public static void gerarClientes() {
		for(int i=0;i<5;i++) {
			Cliente c = new Cliente(Geradores.GerarNome(),Geradores.GerarnumCC(),Geradores.GerarHabito());
			bloomfilternome.Filtroinserir(c.getNome());
			bloomfiltercc.Filtroinserir(Integer.toString(c.getCc()));
			clientes.add(c);
		}
	}

	public static void addCliente() {
		String habitos;
		int cc;
		ler.nextLine();
		System.out.println("Nome: ");
		String nome = ler.nextLine();

		if(bloomfilternome.Filtroismember(nome)) {

			do {

				System.out.println("BloomFilter detectou que nome ja existe");
				nome = ler.nextLine();

			}while(bloomfilternome.Filtroismember(nome));
		}
		else {
			bloomfilternome.Filtroinserir(nome);
		}



		
		do {
			System.out.println("Cc: ");
			cc = Integer.parseInt(ler.nextLine());
			if (Integer.toString(cc).length()!=9 ) {
				System.out.println("Número de CC invalido");
			}
		}while(Integer.toString(cc).length() != 9);

		if(bloomfiltercc.Filtroismember(Integer.toString(cc))) {

			do {

				System.out.println("BloomFilter detectou que CC ja existe");
				cc = Integer.parseInt(ler.nextLine());

			}while(bloomfiltercc.Filtroismember(Integer.toString(cc)));
		}
		else {
			bloomfiltercc.Filtroinserir(Integer.toString(cc));
		}

		System.out.println("Habitos (produtos separados por espacos) ");
		habitos = ler.nextLine();
		clientes.add(new Cliente(nome,cc,habitos.split(" ")));

	}

	public static void printClientesList() {
		for(Cliente e: clientes) {
			System.out.println("Numero de cliente: " + clientes.indexOf(e) + " || Nome: " + e.getNome() + " || CC:" + e.getCc());
		}
	}

	public static void printHabitos() {
		System.out.print("Insira numero de cliente: ");
		int op = ler.nextInt();
		Cliente c  = clientes.get(op);
		System.out.println("Habitos de compra de: " + c.getNome() +"\n"+ Arrays.toString(c.getHabitos()));
	}
	
	public static void encontrarSemelhantes() {
		int count = 0;
		int i=0;
		String[] habitos = new String[clientes.size()] ;
		String[] nomes = new String[clientes.size()];
		for(Cliente e: clientes) {
			habitos[i] = Arrays.toString(e.getHabitos()).replaceAll(",", "").replaceAll("\\[","").replaceAll("\\]", "");
			nomes[i] = e.getNome();
			i++;
		}
		
		for(int n=0; n<habitos.length;n++) {
			String set1 = habitos[n];
			String nome1 =  nomes[n];
			for(int m=n+1; m<habitos.length;m++) {
				String set2 = habitos[m];
				String nome2 = nomes[m];
				double jaccsim = (double) minhash.jaccard(set1,set2);
				if(jaccsim >=0.75) {
					count++;
					System.out.print(count + " || " + "Num cliente:" + n + " "+ nome1 + " || similar com || Num cliente: " + m + " " + nome2); System.out.printf(" || %.2f%% de Semelhanca\n", 100 *jaccsim);
				}
			}
		}
		if(count==0) 
					System.out.println("Não há habitos de compra semelhantes");
	}

}
