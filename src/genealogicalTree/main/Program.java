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
			selection = menu(sc); // print menu and get the user's choice
			
			switch(selection) {
				case 1:
					Pessoa ancestral = inputAncestral(sc);
					pessoa.adicionaAncestral(ancestral);
					break;
				case 2:
					pessoa.exibiArvoreGenealogica();
					break;
				default:
					break;
			}
				
		} while(selection != 0);
		
	}
	
	public static int menu(Scanner sc) {
		String menu =  "[1] Adicionar ancestral" +
						"\n[2] Exibir árvore genealógica" + 
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
}
