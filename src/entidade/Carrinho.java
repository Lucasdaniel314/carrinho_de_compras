package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Carrinho {
	
	/**
	 * olá, este é o meu primeiro javadoc 
	 * 
	 * este programa simula uma loja que tem um carrinho
	 * @author Lucas Daniel
	 */
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Scanner sc = new Scanner(System.in);
	
	private Date data;
	private Cliente cliente;
	private Produto produto;
	
	List<Produto> lista = new ArrayList<>();
	
	public Carrinho() {
	}

	public Carrinho(Date data, Cliente cliente) {
		this.data = data;
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getLista() {
		return lista;
	}

	public void adcionarProduto(Produto produto) {
		lista.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		lista.remove(produto);
	}
	
	public void adcionar() {
		System.out.print("nome do produto: ");
		String nomeproduto = sc.nextLine();
		System.out.print("preço: ");
		double preco = sc.nextDouble();
		Produto produto = new Produto(nomeproduto, preco);
		adcionarProduto(produto);
	}
	
	public void remover() {
		System.out.print("o que quer remover? ");
		String hj = sc.nextLine();
		lista.removeIf(produto -> produto.getNome().equals(hj));
	}
	
	public double total() {
		double soma = 0.0;
		for(Produto item : lista) {
			soma += item.getPreco();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("resumo do carrinho" + "\n");
		sb.append("data: ");
		sb.append(sdf.format(data) + "\n");
		for (Produto item: lista) {
			sb.append(item + "\n");
		}
		sb.append("total: ");
		sb.append(total());
		return sb.toString();
	}
	
}
