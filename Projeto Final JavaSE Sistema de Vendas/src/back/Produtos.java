package back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Produtos extends Cadastro {

	// atributos

	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private String categoria;
	private String fornecedor;
	private int quantidadeEstoque;
	private String peso;
	private String disponibilidade;
	private String dataValidade;

	// construtores

	public Produtos() {
		super();
	}

	public Produtos(int id, String nome, String descricao, double preco, String categoria, String fornecedor,
			int quantidadeEstoque, String peso, String disponibilidade, String dataValidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.fornecedor = fornecedor;
		this.quantidadeEstoque = quantidadeEstoque;
		this.peso = peso;
		this.disponibilidade = disponibilidade;
		this.dataValidade = dataValidade;
	}

	// getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	// metodos

	// CADASTRAR

	public boolean cadastrar(String caminho, String idS, String precoS, String qntEs, String nome, String descricao,
			String categoria, String fornecedor, String peso, String disponibilidade, String dataValidade) {

		try {

			// afim de add NumberFormatException

			id = Integer.parseInt(idS);
			preco = Double.parseDouble(precoS);
			quantidadeEstoque = Integer.parseInt(qntEs);

			// tratar infos cadastradas

			if (id < 0 || nome.isEmpty() || descricao.isEmpty() || preco < 0 || categoria.isEmpty()
					|| fornecedor.isEmpty() || quantidadeEstoque < 0 || peso.isEmpty() || disponibilidade.isEmpty()
					|| dataValidade.isEmpty()) {

				return false;

			} else {

				// escrever

				FileWriter fw = new FileWriter(caminho, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(id + "#" + nome + "#" + descricao + "#" + preco + "#" + categoria + "#" + fornecedor + "#"
						+ quantidadeEstoque + "#" + peso + "#" + disponibilidade + "#" + dataValidade);
				bw.newLine();

				//

				bw.close();
				fw.close();

				return true;

			}
		} catch (NumberFormatException e) {
			System.err.println("Valores inválidos para ID e/ou preço e/ou quantidade em estoque.\n");
			return false;
		} catch (Exception e) {
			System.err.println("Erro ao cadastrar. Tente novamente.\n");
		}

		return false;
	}

	// EXCLUIR

	public boolean excluir(String caminho, String idS) {

		try {

			// ler como String e converter para int para evitar que o usuário digite algo
			// inválido

			// agora NumberFormatException pode ser colocado para tratar a exceção

			int id = Integer.parseInt(idS);

			// escrever no arquivo temp

			String caminhoTemp = caminho.replace(".txt", "Temp.txt");

			FileWriter fw = new FileWriter(caminhoTemp);
			BufferedWriter bw = new BufferedWriter(fw);

			// ler do principal

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			int cont = 0;

			// quebrar a linha em vetor e procurar pelo id

			while (br.ready()) {

				String linha = br.readLine();
				String vet[] = linha.split("#");

				// se o indice do id for igual ao id procurado

				if (vet[0].equalsIgnoreCase(id + "")) {
					cont++; // contador de exclusão
				} else {
					bw.write(linha);
					bw.newLine();
				}
			}

			br.close();
			fr.close();
			bw.close();
			fw.close();

			// se cont == 0 nada foi excluído

			if (cont == 0) {
				return false;

				// excluir o arquivo original
				// renomear o arquivo temp para o original
			} else {

				File f1 = new File(caminho);
				f1.delete();

				File f2 = new File(caminhoTemp);

				if (f2.renameTo(f1)) {
					return true;
				} else {
					return false;
				}
			}

		} catch (NumberFormatException e) {
			System.err.println("Digite um ID válido.");
		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

		return false;

	}

	// LOCALIZAR E IMPRIMIR LINHA

	public void localizarImprimirLinha(String caminho, String idS) {

		try {

			int id = Integer.parseInt(idS);

			//

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			String linha;
			boolean produtoEncontrado = false;

			//

			while (br.ready()) {
				linha = br.readLine();
				String vet[] = linha.split("#");

				if (vet[0].equalsIgnoreCase(id + "")) {

					produtoEncontrado = true;

					System.out.println();

					for (int i = 0; i < vet.length; i++) {

						switch (i) {
						case 0:
							System.out.print("ID: ");
							break;
						case 1:
							System.out.print("Nome do produto: ");
							break;
						case 2:
							System.out.print("Descrição: ");
							break;
						case 3:
							System.out.print("Preço: R$ ");
							break;
						case 4:
							System.out.print("Categoria: ");
							break;
						case 5:
							System.out.print("Fornecedor: ");
							break;
						case 6:
							System.out.print("Quantidade em estoque: ");
							break;
						case 7:
							System.out.print("Peso: ");
							break;
						case 8:
							System.out.print("Disponibilidade: ");
							break;
						case 9:
							System.out.print("Data de validade: ");
							break;

						}

						System.out.print(vet[i].toUpperCase() + "\n");
					}

					System.out.println();

				}
			}

			br.close();
			fr.close();

			if (!produtoEncontrado) {
				System.err.println("Produto não encontrado.\n");
			}

		} catch (NumberFormatException e) {
			System.err.println("Digite um ID válido para realizar a busca.\n");

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.");
		}

	}

	// VERIFICAR SE O OBJETO ESTÁ VAZIO PARA FINALIZAR A VENDA

	public boolean isEmpty() {

		// retorna true se todas as condições forem verdadeiras, indicando que o objeto
		// está vazio

		return this.id == 0 && this.nome == null && this.descricao == null && this.preco == 0 && this.categoria == null
				&& this.fornecedor == null && this.quantidadeEstoque == 0 && this.peso == null;
	}

	// LIMPAR CARRINHO

	public void limparCarrinho() {

		this.id = 0;
		this.nome = null;
		this.descricao = null;
		this.preco = 0;
		this.categoria = null;
		this.fornecedor = null;
		this.quantidadeEstoque = 0;
		this.peso = null;

	}

	// IMPRIMIR RELATORIO

	public void imprimirRelatorio(String caminho) {

		// ler

		try {

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			while (br.ready()) {

				String linha = br.readLine();
				String vet[] = linha.split("#");

				for (int i = 0; i < vet.length; i++) {

					switch (i) {
					case 0:
						System.out.print("ID: ");
						break;
					case 1:
						System.out.print("Nome do produto: ");
						break;
					case 2:
						System.out.print("Descrição: ");
						break;
					case 3:
						System.out.print("Preço: R$ ");
						break;
					case 4:
						System.out.print("Categoria: ");
						break;
					case 5:
						System.out.print("Fornecedor: ");
						break;
					case 6:
						System.out.print("Quantidade em estoque: ");
						break;
					case 7:
						System.out.print("Peso: ");
						break;
					case 8:
						System.out.print("Disponibilidade: ");
						break;
					case 9:
						System.out.print("Data de validade: ");
						break;
					}

					System.out.print(vet[i].toUpperCase() + "\n");

				}
				System.out.println();
			}

			br.close();
			fr.close();

		} catch (Exception e) {
			System.err.println("Erro ao imprimir o relatório.\n");
		}

	}

	// VERIFICAR PESO

	public boolean verificarPeso(String peso) {

		try {

			peso = peso.trim().toLowerCase();

			while (peso.contains(" ")) {
				peso = peso.replace(" ", "");
			}

			String listaPermitida = "0123456789";

			for (int i = 0; i < peso.length(); i++) {

				char aux = peso.charAt(i);

				if (!listaPermitida.contains(aux + "")
						&& (!listaPermitida.contains("g") || !listaPermitida.contains("l")
								|| !listaPermitida.contains("kg") || !listaPermitida.contains("ml"))) {
					return false;
				}

			}

			return true;

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.");
		}

		return false;
	}

}
