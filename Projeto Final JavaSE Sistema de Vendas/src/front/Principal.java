package front;

import java.util.ArrayList;
import java.util.Scanner;

import back.Cadastro;
import back.Carrinho;
import back.Cliente;
import back.Funcionario;
import back.Pessoa;
import back.Produtos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ler = new Scanner(System.in);
		String op;

		//
		try {

			String caminhoDiretorio = "E:\\Step\\sistemavendas";

			String caminhoCliente = caminhoDiretorio + "\\cliente.txt";
			String caminhoProduto = caminhoDiretorio + "\\produto.txt";
			String caminhoFuncionario = caminhoDiretorio + "\\funcionario.txt";

			// verificar diretorios

			Cliente c0 = new Cliente();
			c0.verificarDiretorio(caminhoDiretorio);

			Produtos p0 = new Produtos();
			p0.verificarDiretorio(caminhoDiretorio);

			Funcionario f0 = new Funcionario();
			f0.verificarDiretorio(caminhoDiretorio);

			// verificar arquivos

			Cliente c01 = new Cliente();
			c01.verificarArquivo(caminhoCliente);

			Produtos p01 = new Produtos();
			p01.verificarArquivo(caminhoProduto);

			Funcionario f01 = new Funcionario();
			f01.verificarArquivo(caminhoFuncionario);

			//

			System.out.println();

			//

			Carrinho c = new Carrinho();
			ArrayList<Produtos> carrinhoAux = new ArrayList<Produtos>();

			//

			do {

				System.out.println("Menu:");
				System.out.println("1. Cadastrar produto;");
				System.out.println("2. Excluir produto;");
				System.out.println("3. Cadastrar cliente;");
				System.out.println("4. Excluir cliente;");
				System.out.println("5. Cadastrar funcionário;");
				System.out.println("6. Excluir funcionário;");
				System.out.println("7. Localizar produto pelo ID;");
				System.out.println("8. Localizar cliente pelo nome;");
				System.out.println("9. Localizar funcionário pelo ID;");
				System.out.println("10. Imprimir relatório de produtos;");
				System.out.println("11. Imprimir relatório de clientes;");
				System.out.println("12. Imprimir relatório de funcionários;");
				System.out.println();
				System.out.println("Menu de Compras:");
				System.out.println("13. Ver carrinho;");
				System.out.println("14. Adicionar produto ao carrinho;");
				System.out.println("15. Remover produto do carrinho;");
				System.out.println("16. Finalizar compra;");

				System.out.println("S. Sair;");

				op = ler.nextLine();

				switch (op) {
				case "1": {

					// cadastrar produto

					System.out.print("Digite o ID do produto: ");
					String id = ler.nextLine().trim();

					System.out.print("Digite o nome do produto: ");
					String nome = ler.nextLine().trim();

					System.out.print("Digite a descrição do produto: ");
					String descricao = ler.nextLine().trim();

					System.out.print("Digite o preço do produto: ");
					String preco = ler.nextLine().trim();

					System.out.print("Digite a categoria do produto: ");
					String categoria = ler.nextLine().trim();

					System.out.print("Digite o fornecedor: ");
					String fornecedor = ler.nextLine().trim();

					System.out.print("Digite a quantidade em estoque: ");
					String quantidadeEstoque = ler.nextLine().trim();

					System.out.print("Digite o peso: ");
					String peso = ler.nextLine().trim();

					System.out.print("Digite o status de disponibilidade: (disponível/esgotado) ");
					String disponibilidade = ler.nextLine().trim();

					System.out.print("Digite a data de validade: ");
					String dataValidade = ler.nextLine().trim();

					//

					Cadastro spC = new Cadastro();
					Produtos p2 = new Produtos();

					// VERIFICAÇÃO DAS INFO

					if (spC.verificarNome(nome) && p2.verificarPeso(peso)) {

						// verificar se não foi preenchido

						if (disponibilidade.isEmpty()) {

							System.err.println("Forneça o status de disponibilidade e tente novamente.\n");

							break;
						}

						// verificar se é uma das duas opções possíveis

						if (!disponibilidade.equalsIgnoreCase("esgotado")
								&& !disponibilidade.equalsIgnoreCase("disponível")) {

							System.err.println("Forneça um status de disponibilidade válido.\n");
						}

						// esgotado

						if (disponibilidade.equalsIgnoreCase("esgotado")) {

							Produtos p = new Produtos();

							if (p.cadastrar(caminhoProduto, id, preco, quantidadeEstoque, nome, descricao, categoria,
									fornecedor, peso, disponibilidade, dataValidade)) {
								System.out.println("Produto cadastrado com sucesso.\n");

							}
						}

						// disponível

						if (disponibilidade.equalsIgnoreCase("disponível")) {

							Produtos p = new Produtos();

							if (p.cadastrar(caminhoProduto, id, preco, quantidadeEstoque, nome, descricao, categoria,
									fornecedor, peso, disponibilidade, dataValidade)) {
								System.out.println("Produto cadastrado com sucesso.\n");

							}

						}

					} else {
						System.err.println(
								"Erro ao fazer o cadastro. Preencha os campos corretamente e tente novamente.\n");
					}

					break;

				}

				case "2": {

					// excluir o produto

					System.out.print("Digite o ID do produto a ser excluído do sistema: ");
					String idS = ler.nextLine().trim();

					Produtos p = new Produtos();

					if (p.excluir(caminhoProduto, idS)) {
						System.out.println("Produto excluído do sistema com sucesso.\n");
					} else {
						System.err.println("Algo deu errado. Verifique o ID do produto e tente novamente.\n");
					}

					break;

				}

				case "3": {

					// cadastrar cliente

					System.out.print("Digite o nome do cliente: ");
					String nome = ler.nextLine().trim();

					System.out.print("Digite o CPF: ");
					String cpf = ler.nextLine().trim();

					System.out.print("Digite o e-mail: ");
					String email = ler.nextLine().trim();

					System.out.print("Digite o telefone/celular: ");
					String telefone = ler.nextLine().trim();

					System.out.print("Digite a data de nascimento: ");
					String dataNascimento = ler.nextLine().trim();

					System.out.print("Digite o gênero: (F: feminino/M: masculino/O: outro)");
					String genero = ler.nextLine().trim();

					System.out.print("Digite a senha: ");
					String senha = ler.nextLine();

					System.out.print("Digite o CEP: ");
					String cep = ler.nextLine();

					//

					Cadastro spC = new Cadastro();
					Pessoa p1 = new Pessoa();

					// verificação das info

					if (spC.verificarNome(nome) && p1.verificarCPF(cpf) && p1.verificarTel(telefone)
							&& p1.verificarCEP(cep)) {

						// cadastrar cpf no formato 000.000.000-00

						cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
								+ cpf.substring(9);

						// cadastrar telefone no formato (00) 00000-0000

						telefone = "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-"
								+ telefone.substring(7);

						// cadastrar cep no formato 00000-000

						cep = cep.substring(0, 5) + "-" + cep.substring(5);

						//

						Cliente cl1 = new Cliente(nome, cpf, email, telefone, dataNascimento, genero, senha, cep);

						if (cl1.cadastrar(caminhoCliente)) {
							System.out.println("Cliente cadastrado com sucesso.\n");
						} else {
							System.err.println("Erro ao cadastrar. Tente novamente.\n");
						}

					} else {
						System.err
								.println("Erro ao cadastrar o cliente. Verifique as informações e tente novamente.\n");
					}

					break;

				}

				case "4": {

					// excluir cliente

					System.out.print("Digite o nome do cliente a ser excluído do sistema: ");
					String nome = ler.nextLine().trim();

					Cliente cl1 = new Cliente();

					if (cl1.excluir(caminhoCliente, nome)) {
						System.out.println("Cliente excluído do sistema com sucesso.\n");
					} else {
						System.err.println("Algo deu errado. Verifique o nome do cliente e tente novamente.\n");
					}

					break;
				}

				case "5": {

					// cadastrar funcionário

					System.out.print("Digite o nome do funcionário: ");
					String nome = ler.nextLine().trim();

					System.out.print("Digite o CPF do funcionário: ");
					String cpf = ler.nextLine().trim();

					System.out.print("Digite o e-mail: ");
					String email = ler.nextLine().trim();

					System.out.print("Digite o telefone/celular: ");
					String telefone = ler.nextLine().trim();

					System.out.print("Digite a data de nascimento: ");
					String dataNascimento = ler.nextLine().trim();

					System.out.print("Digite o gênero: (F: feminino/M: masculino/O: outro)");
					String genero = ler.nextLine().trim();

					System.out.print("Digite o CEP: ");
					String cep = ler.nextLine().trim();

					System.out.print("Digite o ID do funcionário: ");
					String idFunc = ler.nextLine().trim();

					System.out.print("Digite o salário: ");
					String salario = ler.nextLine().trim();

					System.out.print("Digite o cargo: ");
					String cargo = ler.nextLine().trim();

					System.out.print("Digite a data de contratação: ");
					String dataContratacao = ler.nextLine().trim();

					//

					Cadastro spC = new Cadastro();
					Pessoa p1 = new Pessoa();

					// verificação infos

					if (spC.verificarNome(nome) && p1.verificarCPF(cpf) && p1.verificarCEP(cep)) {
						Funcionario f = new Funcionario();

						// cadastrar cpf no formato 000.000.000-00

						cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
								+ cpf.substring(9);

						// cadastrar telefone no formato (00) 00000-0000

						telefone = "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-"
								+ telefone.substring(7);

						// cadastrar cep no formato 00000-000

						cep = cep.substring(0, 5) + "-" + cep.substring(5);

						//

						if (f.cadastrar(caminhoFuncionario, nome, cpf, email, telefone, dataNascimento, genero, cep,
								idFunc, salario, cargo, dataContratacao)) {
							System.out.println("Funcionário cadastrado com sucesso.\n");
						} else {
							System.err.println("Erro ao cadastrar. Tente novamente.\n");
						}
					} else {
						System.err.println(
								"Erro ao cadastrar o funcionário. Verifique as informações e tente novamente.\n");
					}

					break;
				}

				case "6": {

					// excluir funcionario

					System.out.print("Digite o nome do funcionário a ser excluído do sistema: ");
					String nome = ler.nextLine().trim();

					Funcionario f = new Funcionario();

					if (f.excluir(caminhoFuncionario, nome)) {
						System.out.println("Funcionário excluído do sistema com sucesso.\n");
					} else {
						System.err.println("Algo deu errado. Verifique o nome do funcionário e tente novamente.\n");
					}

					break;
				}

				case "7": {

					// localizar produto

					System.out.print("Digite o ID do produto desejado: ");
					String id = ler.nextLine().trim();

					Produtos p = new Produtos();

					p.localizarImprimirLinha(caminhoProduto, id);

					break;
				}

				case "8": {

					// localizar cliente

					System.out.print("Digite o nome do cliente procurado: ");
					String nome = ler.nextLine().trim();

					Cliente cl1 = new Cliente();

					cl1.localizarImprimirLinha(caminhoCliente, nome);

					break;
				}

				case "9": {

					// localizar funcionario

					System.out.print("Digite o ID do funcionário procurado: ");
					String id = ler.nextLine().trim();

					Funcionario f = new Funcionario();

					f.localizarImprimirLinha(caminhoFuncionario, id);

					break;
				}

				case "10": {

					Produtos p = new Produtos();
					p.imprimirRelatorio(caminhoProduto);

					break;
				}

				case "11": {

					Cliente cl1 = new Cliente();
					cl1.imprimirRelatorio(caminhoCliente);

					break;
				}

				case "12": {

					Funcionario f = new Funcionario();
					f.imprimirRelatorio(caminhoFuncionario);

					break;
				}

				case "13": {

					// imprimir itens e valores

					c.imprimirItensCarrinho(c.getCarrinhoAl());
					System.out.println("Quantidade de produtos no carrinho: " + c.getCarrinhoAl().size());

					// imprimir total

					c.calcularTotal(c.getCarrinhoAl());

					break;
				}

				case "14": {

					// exibir as possibilidades a serem add ao carrinho
					Produtos p = new Produtos();
					System.out.println("\nLISTA DE PRODUTOS:\n");
					p.imprimirRelatorio(caminhoProduto);

					//
					System.out.println("Digite 'x' quando terminar de adicionar itens ao carrinho.");
					String nomeProduto = null;
					//

					do {
						// add o produto ao carrinho
						System.out.println("Digite o nome do produto a ser adicionado ao carrinho:");
						nomeProduto = ler.nextLine();

						c = new Carrinho();
						c.adicionarProduto(caminhoProduto, nomeProduto, carrinhoAux);

						c.setCarrinhoAl(carrinhoAux);

						//

					} while (!nomeProduto.equalsIgnoreCase("x"));

					break;
				}

				case "15": {

					// exibir itens do carrinho

					c.imprimirItensCarrinho(c.getCarrinhoAl());

					//

					System.out.println("Digite 'x' quando terminar de remover itens do carrinho.");
					String nomeProduto = null;

					//

					do {
						// remover o produto do carrinho
						System.out.println("Digite o nome do produto a ser removido do carrinho:");
						nomeProduto = ler.nextLine();

						c = new Carrinho();
						c.removerProduto(nomeProduto, carrinhoAux);

						c.setCarrinhoAl(carrinhoAux);

						//

					} while (!nomeProduto.equalsIgnoreCase("x"));

					break;
				}

				case "16": {

					break;
				}

				case "s":
				case "S":
					System.out.println("Você saiu do programa.");
					break;
				default:
					System.err.println("Digite uma das opções do menu.\n");
					break;
				}

			} while (!op.equalsIgnoreCase("s"));

			ler.close();

		} catch (

		Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}
}
