package genealogicalTree.main;

import java.util.Scanner;

import genealogicalTree.entities.Pessoa;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Name: ");
		String name = sc.next();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(name);
		
		int selection = 0;
		do {
			System.out.println();
			selection = menu(sc); // print menu and get the user's choice
			
			switch(selection) {
				case 1:
					Pessoa ancestral = inputAncestral(sc);
					pessoa.adicionaAncestral(ancestral);
					break;
				case 2:
					pessoa.exibiArvoreGenealogica();
					break;
				case 3: 
					String[] nomes = inputAlteraNome(sc);
					pessoa.alterarAncestral(nomes[0], nomes[1]);
					break;
				case 4:
					String pessoaDeserdada = inputDeserdaMembroFamiliar(sc);
					pessoa.deserdaPessoa(pessoaDeserdada);
					break;
				case 5:
					String[] nomesAdotados = inputAdotaPessoa(sc);
					pessoa.adotaPessoa(nomesAdotados[0], nomesAdotados[1]);
					break;
				default:
					break;
			}
				
		} while(selection != 0);
		
	}
	
	public static int menu(Scanner sc) {
		String menu =  "[1] Adicionar ancestral" +
						"\n[2] Exibir árvore genealógica" + 
						"\n[3] Alterar ancestral" +
						"\n[4] Deserda membro familiar" +
						"\n[5] Adota filho" + 
						"\n[0] Sair";
		
		System.out.println(menu);
		return sc.nextInt();	
	}
	
	public static Pessoa inputAncestral(Scanner sc) {
		sc.nextLine();
		System.out.print("Nome do ancestral: ");
		String name = sc.nextLine();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(name);
		
		return pessoa;
	}
	
	public static String[] inputAlteraNome(Scanner sc) {
		sc.nextLine();
		String[] nomes = new String[2];
		
		System.out.print("Nome do ancestral que deseja alterar: ");
		nomes[0] = sc.nextLine();
		
		System.out.print("Nome novo do ancestral: ");
		nomes[1] = sc.nextLine();
		
		return nomes;
	}
	
	public static String inputDeserdaMembroFamiliar(Scanner sc) {
		sc.nextLine();
		System.out.print("Nome do membro a ser deserdado: ");
		return sc.nextLine();
	}
	
	public static String[] inputAdotaPessoa(Scanner sc) {
		sc.nextLine();
		System.out.print("Nome do adotador(a): ");
		String[] nomes = new String[2];
		nomes[0] = sc.nextLine();
		
		System.out.print("Nome do adotado(a): ");
		nomes[1] = sc.nextLine();
		
		return nomes;
	}
}
