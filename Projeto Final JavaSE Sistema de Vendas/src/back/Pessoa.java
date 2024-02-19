package back;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Pessoa extends Cadastro {

	// atributos

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String dataNascimento;
	private String genero;
	private String cep;

	// construtores

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String cpf, String email, String telefone, String dataNascimento, String genero,
			String cep) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.cep = cep;
	}

	// getters e setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	// métodos

	// EXCLUIR

	public boolean excluir(String caminho, String nome) {

		try {

			// escrever no arquivo temp

			String caminhoTemp = caminho.replace(".txt", "Temp.txt");

			FileWriter fw = new FileWriter(caminhoTemp);
			BufferedWriter bw = new BufferedWriter(fw);

			// ler do principal

			FileReader fr = new FileReader(caminho);
			BufferedReader br = new BufferedReader(fr);

			//

			int cont = 0;

			// quebrar a linha em vetor e procurar pelo nome

			while (br.ready()) {

				String linha = br.readLine();
				String vet[] = linha.split("#");

				// se o indice do nome for igual ao nome procurado

				if (vet[0].equalsIgnoreCase(nome)) {
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

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.\n");
		}

		return false;

	}

	// VERIFICAR CPF

	public boolean verificarCPF(String cpf) {

		try {

			cpf = cpf.trim();

			while (cpf.contains(" ")) {
				cpf = cpf.replace(" ", "");
			}

			String listaPermitida = "0123456789";

			for (int i = 0; i < cpf.length(); i++) {

				char aux = cpf.charAt(i);

				if (!listaPermitida.contains(aux + "") || cpf.length() != 11) {
					return false;
				}

			}

			return true;

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.");
		}

		return false;
	}

	// VERIFICAR TELEFONE

	public boolean verificarTel(String telefone) {

		try {

			telefone = telefone.trim();

			while (telefone.contains(" ")) {
				telefone = telefone.replace(" ", "");
			}

			String listaPermitida = "0123456789";

			for (int i = 0; i < telefone.length(); i++) {

				char aux = telefone.charAt(i);

				if (!listaPermitida.contains(aux + "") || (telefone.length() != 11 && telefone.length() != 10)) {
					return false;
				}

			}

			return true;

		} catch (Exception e) {
			System.err.println("Algo deu errado. Tente novamente.");
		}

		return false;
	}

	// VERIFICAR CEP

	public boolean verificarCEP(String cep) {

		try {

			cep = cep.trim();

			while (cep.contains(" ")) {
				cep = cep.replace(" ", "");
			}

			String listaPermitida = "0123456789";

			for (int i = 0; i < cep.length(); i++) {

				char aux = cep.charAt(i);

				if (!listaPermitida.contains(aux + "") || (cep.length() != 8)) {
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
