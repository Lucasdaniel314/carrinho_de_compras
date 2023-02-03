package aplicacao;

import java.util.Date;
import java.util.Scanner;

import entidade.Carrinho;
import entidade.Cliente;
import entidade.Produto;

public class Programa {

	public static void main(String[] args) {
		int resp = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("bem vindo ao mercadinho Lucas!");
		System.out.println("para iniciarmos, você deve digitar seu dados:");
		System.out.print("nome: ");
		String nome = sc.nextLine();
		System.out.print("id (numero de 4 digitos): ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("email: ");
		sc.next();
		String email = sc.nextLine();
		Cliente cliente = new Cliente(nome, email, id);
		
		
		System.out.println("vamos adcionar um produto!");
		System.out.print("nome do produto: ");
		String nomeproduto = sc.nextLine();
		System.out.print("preço: ");
		double preco = sc.nextDouble();
		Produto produto = new Produto(nomeproduto, preco);
		Carrinho carrinho = new Carrinho(new Date(), cliente);
		carrinho.adcionarProduto(produto);
		
		do {
			System.out.println("menu: ");
			System.out.println("[1] adcionar produto");
			System.out.println("[2] remover produto");
			System.out.println("[3] mostar resumo");
			System.out.println("[4] encerrar programa");
			resp = sc.nextInt();
			sc.nextLine();
			switch (resp) {
				case 1:
					carrinho.adcionar();
					break;
				case 2:
					carrinho.remover();
					break;
				case 3:
					System.out.println(carrinho.toString());
					break;
				case 4:
					break;
				default:
					System.out.println("código inválido");
					break;
			}
		}while(resp != 4);
		
		sc.close();
	}

}
