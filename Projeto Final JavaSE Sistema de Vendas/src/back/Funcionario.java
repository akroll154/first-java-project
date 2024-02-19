package back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Funcionario extends Pessoa {

	// atributos

	private int idFunc;
	private double salario;
	private String cargo;
	private String dataContratacao;

	// construtores

	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String email, String telefone, String dataNascimento, String genero,
			String cep, int idFunc, double salario, String cargo, String dataContratacao) {
		super(nome, cpf, email, telefone, dataNascimento, genero, cep);
		this.idFunc = idFunc;
		this.salario = salario;
		this.cargo = cargo;
		this.dataContratacao = dataContratacao;
	}

	// getters e setters

	public int getIdFunc() {
		return idFunc;
	}

	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	// métodos

	// CADASTRAR

	public boolean cadastrar(String caminho, String nome, String cpf, String email, String telefone,
			String dataNascimento, String genero, String cep, String idS, String salarioS, String cargo,
			String dataContratacao) {

		try {

			// tratar excecao

			this.idFunc = Integer.parseInt(idS);
			this.salario = Double.parseDouble(salarioS);

			// tratar infos cadastradas

			if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || dataNascimento.isEmpty()
					|| genero.isEmpty() || cep.isEmpty() || idFunc < 0 || salario < 0 || cargo.isEmpty()
					|| dataContratacao.isEmpty()) {

				return false;

			} else {

				// escrever

				FileWriter fw = new FileWriter(caminho, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(nome + "#" + cpf + "#" + email + "#" + telefone + "#" + dataNascimento + "#" + genero + "#"
						+ cep + "#" + idFunc + "#" + salario + "#" + cargo + "#" + dataContratacao);

				bw.newLine();

				// fechar

				bw.close();
				fw.close();

				return true;

			}

		} catch (NumberFormatException e) {
			System.err.println("ID e/ou sálario inválidos.\n");
			return false; // executar apenas esse catch em caso de numberformatexception

		} catch (Exception e) {
			System.err.println("Erro ao cadastrar. Tente novamente.\n");

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
			boolean funcionarioEncontrado = false;

			//

			while (br.ready()) {
				linha = br.readLine();
				String vet[] = linha.split("#");

				if (vet[7].equalsIgnoreCase(id + "")) {

					funcionarioEncontrado = true;

					System.out.println();

					for (int i = 0; i < vet.length; i++) {

						switch (i) {
						case 0:
							System.out.print("Nome: ");
							break;
						case 1:
							System.out.print("CPF: ");
							break;
						case 2:
							System.out.print("E-mail: ");
							break;
						case 3:
							System.out.print("Telefone: ");
							break;
						case 4:
							System.out.print("Data de nascimento: ");
							break;
						case 5:
							System.out.print("Gênero: ");
							break;
						case 6:
							System.out.print("CEP: ");
							break;
						case 7:
							System.out.print("ID: ");
							break;
						case 8:
							System.out.print("Salário: R$ ");
							break;
						case 9:
							System.out.print("Cargo: ");
							break;
						case 10:
							System.out.print("Data de contratação: ");
							break;
						}

						System.out.print(vet[i].toUpperCase() + "\n");
					}

					System.out.println();

				}
			}

			br.close();
			fr.close();

			if (!funcionarioEncontrado) {
				System.err.println("Funcionário não encontrado.\n");
			}

		} catch (NumberFormatException e) {
			System.err.println("Digite um ID válido para a busca.\n");

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.");
		}
	}

	// IMPRIMIR RELATORIO

	public void imprimirRelatorio(String caminho) {

		try {

			//

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			String linha;

			while (br.ready()) {
				linha = br.readLine();
				String vet[] = linha.split("#");

				System.out.println();

				for (int i = 0; i < vet.length; i++) {

					switch (i) {
					case 0:
						System.out.print("Nome: ");
						break;
					case 1:
						System.out.print("CPF: ");
						break;
					case 2:
						System.out.print("E-mail: ");
						break;
					case 3:
						System.out.print("Telefone: ");
						break;
					case 4:
						System.out.print("Data de nascimento: ");
						break;
					case 5:
						System.out.print("Gênero: ");
						break;
					case 6:
						System.out.print("CEP: ");
						break;
					case 7:
						System.out.print("ID: ");
						break;
					case 8:
						System.out.print("Salário: R$ ");
						break;
					case 9:
						System.out.print("Cargo: ");
						break;
					case 10:
						System.out.print("Data de contratação: ");
						break;

					}
					System.out.print(vet[i].toUpperCase() + "\n");
				}

				System.out.println();

			}

			br.close();
			fr.close();

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

	}

}
