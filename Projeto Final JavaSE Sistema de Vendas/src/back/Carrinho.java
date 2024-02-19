package back;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Carrinho {

	// atributos

	private Produtos itens; // produtos registrados adicionados ao carrinho
	private Cliente cliente; // cliente que está efetuando a compra
	private double total; // soma dos valores dos produtos
	private int quantidadeItens; // quantos itens tem no carrinho

	//

	private ArrayList<Produtos> carrinhoAl = new ArrayList<Produtos>();

	// construtores

	public Carrinho() {
		super();
	}

	public Carrinho(Produtos itens, Cliente cliente, double total, int quantidadeItens) {
		super();
		this.itens = itens;
		this.cliente = cliente;
		this.total = total;
		this.quantidadeItens = quantidadeItens;
	}

	// getters e setters

	public Produtos getItens() {
		return itens;
	}

	public void setItens(Produtos itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(int quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	// get e set array list

	public ArrayList<Produtos> getCarrinhoAl() {
		return carrinhoAl;
	}

	public void setCarrinhoAl(ArrayList<Produtos> carrinhoAl) {
		this.carrinhoAl = carrinhoAl;
	}

	// MÉTODOS

	// ADD PRODUTOS CARRINHO

	public void adicionarProduto(String caminho, String nomeProduto, ArrayList<Produtos> carrinhoAl) {

		try {

			// localizar objeto produto pelo atributo nome

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			int cont = 0;
			Produtos p = null;

			while (br.ready()) {

				String linha = br.readLine();
				String vet[] = linha.split("#");

				// adicionar objeto produto carrinho

				if (vet[1].equalsIgnoreCase(nomeProduto)) {
					cont++;

					p = new Produtos(Integer.parseInt(vet[0]), vet[1], vet[2], Double.parseDouble(vet[3]), vet[4],
							vet[5], Integer.parseInt(vet[6]), vet[7], vet[8], vet[9]);
				}

			}

			if (cont != 0) {
				carrinhoAl.add(p);
				System.out.println("Produto adicionado ao carrinho!\n");
			} else if (nomeProduto.equalsIgnoreCase("x")) {
				System.out.println("Carrinho finalizado.\n");
			} else {
				System.err.println("Produto não cadastrado.\n");
			}

			br.close();
			fr.close();

		} catch (java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro ao adicionar o produto ao carrinho.\n");
		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

	}

	// REMOVER PRODUTOS CARRINHO

	public void removerProduto(String nomeProduto, ArrayList<Produtos> carrinhoAl) {

		try {

			int cont = 0;

			// percorrer carrinho

			for (int i = 0; i < carrinhoAl.size(); i++) {

				Produtos produto = carrinhoAl.get(i); // pegar objeto do carrinho baseado no indice

				if (produto.getNome().equalsIgnoreCase(nomeProduto)) { // comparar atributo nome com a string digitada
					carrinhoAl.remove(produto);
					System.out.println("Item removido do carrinho.\n");
					break;

				} else {
					cont++;
				}

			}

			if (nomeProduto.equalsIgnoreCase("x")) {
				System.out.println("Carrinho finalizado.\n");
			}

			//

			if (cont == carrinhoAl.size()) {
				System.err.println("Erro ao remover o item do carrinho.");
			}

		} catch (java.lang.IndexOutOfBoundsException e) {
			System.err.println("Erro ao remover o item do carrinho.\n");
		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

	}

	// IMPRIMIR ITENS CARRINHO

	public void imprimirItensCarrinho(ArrayList<Produtos> carrinhoAl) {

		try {

			System.out.println("\nCARRINHO:\n");

			for (int i = 0; i < carrinhoAl.size(); i++) {

				Produtos produto = carrinhoAl.get(i);
				System.out.println(produto.getNome().toUpperCase() + " - R$ " + produto.getPreco());
			}

			System.out.println();

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

	}

	// CALCULAR TOTAL

	public void calcularTotal(ArrayList<Produtos> carrinhoAl) {

		try {

			// pegar a info de valores de cada produto adicionado ao carrinho e somar

			double total = 0;

			//

			for (int i = 0; i < carrinhoAl.size(); i++) {

				Produtos produto = carrinhoAl.get(i);
				double preco = produto.getPreco();

				total = total + preco;

			}

			System.out.println("TOTAL: R$ " + total + "\n");

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

	}

	// LIMPAR CARRINHO

	public void limparCarrinho() {

		carrinhoAl.clear();

	}

	// FINALIZAR COMPRA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	public Venda finalizarCompra(Cliente cliente) {

		// carrinho vazio
		if (itens.isEmpty()) {
			return null;
		}

		// instanciar venda e finalizar compra
		Venda venda = new Venda(cliente, itens);

		// limpar info carrinho
		itens.limparCarrinho();

		return venda;

	}
}
