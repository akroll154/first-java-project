package back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Cliente extends Pessoa {

	// atributos

	private String senha;

	// construtores

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String email, String telefone, String dataNascimento, String genero,
			String cep, String senha) {
		super(nome, cpf, email, telefone, dataNascimento, genero, cep);
		this.senha = senha;
	}

	// getters e setters
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// metodos

	// CADASTRAR

	public boolean cadastrar(String caminho) {

		// tratar infos cadastradas

		if (getNome().isEmpty() || getCpf().isEmpty() || getEmail().isEmpty() || getTelefone().isEmpty()
				|| getDataNascimento().isEmpty() || getGenero().isEmpty() || getCep().isEmpty() || senha.isEmpty()) {

			return false;

		} else {

			// try-catch

			try {

				// escrever

				FileWriter fw = new FileWriter(caminho, true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(getNome() + "#" + getCpf() + "#" + getEmail() + "#" + getTelefone() + "#" + getDataNascimento()
						+ "#" + getGenero() + "#" + getCep() + "#" + senha);

				bw.newLine();

				// fechar

				bw.close();
				fw.close();

				return true;

			} catch (Exception e) {
				System.err.println("Erro ao cadastrar. Tente novamente.\n");

			}

			return false;

		}

	}

	// LOCALIZAR E IMPRIMIR LINHA

	public void localizarImprimirLinha(String caminho, String nome) {

		try {

			//

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			String linha;
			boolean clienteEncontrado = false;

			//

			while (br.ready()) {
				linha = br.readLine();
				String vet[] = linha.split("#");

				if (vet[0].equalsIgnoreCase(nome)) {

					clienteEncontrado = true;

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
							System.out.print("Senha: ");
							break;
						case 7:
							System.out.print("CEP: ");
							break;

						}

						System.out.print(vet[i].toUpperCase() + "\n");
					}

					System.out.println();

				}
			}

			br.close();
			fr.close();

			if (!clienteEncontrado) {
				System.err.println("Cliente não encontrado.\n");
			}

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
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
						System.out.print("Senha: ");
						break;
					case 7:
						System.out.print("CEP: ");
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
