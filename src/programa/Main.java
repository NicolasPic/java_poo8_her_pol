package programa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o numero de produtos: ");	
		int n = sc.nextInt();
		
		List<Produto> lista = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			System.out.println("Dados produto #"+(i+1));
			System.out.println("Comum, usado ou importado(c/u/i)?");
			char c = sc.next().charAt(0);
			System.out.println("Nome:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.println("Preço: ");
			double preco = sc.nextDouble();
			if(c == 'c') {
				lista.add(new Produto(nome,preco));
			}
			else if(c == 'u') {
				System.out.println("Data de fabricação(DD/MM/YYYY): ");
				sc.nextLine();
				Date data = sdf.parse(sc.nextLine());
				lista.add(new ProdutoUsado(nome,preco,data));
			}
			else if(c == 'i') {
				System.out.println("Taxa customizada:");
				double taxa = sc.nextDouble();
				lista.add(new ProdutoImportado(nome,preco,taxa));
			}			
		}
		
		System.out.println("TAGS DOS PREÇOS:");
		
		for(Produto pro : lista) {
			System.out.println(pro.tagPreco());
		}
		
		sc.close();
	}

}
