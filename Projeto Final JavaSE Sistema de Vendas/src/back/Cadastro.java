package back;

import java.io.File;

public class Cadastro {

	// construtores

	public Cadastro() {
		super();
	}

	// MÉTODOS

	// VERIFICAR DIRETÓRIO

	public void verificarDiretorio(String caminhoDiretorio) {

		File f = new File(caminhoDiretorio);

		// caso o arquivo não exista

		if (!f.exists()) {

			try {

				if (f.createNewFile()) { // caso tenha criado
					System.out.println("Diretório(s) criado(s) com sucesso.");
				} else {
					System.err.println("Erro ao criar o(s) diretórios(s).");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // ele já existe
			System.err.println("O(s) diretório(s) já existem.");
		}
	}

	// VERIFICAR ARQUIVO

	public void verificarArquivo(String caminhoCompleto) {

		File f = new File(caminhoCompleto);

		if (!f.exists()) {
			try {
				if (f.createNewFile()) {
					System.out.println("Arquivo criado com sucesso.");
				} else {
					System.err.println("Erro ao criar o arquivo.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("O arquivo já existe.");
		}
	}

	// VERIFICAR NOME

	public boolean verificarNome(String nome) {

		try {

			nome = nome.trim().toLowerCase();

			while (nome.contains("  ")) {
				nome = nome.replace("  ", " ");
			}

			String listaPermitida = "abcdefghijklmnopqrstuvwxyz";

			for (int i = 0; i < nome.length(); i++) {

				char aux = nome.charAt(i);

				if (!listaPermitida.contains(aux + "")) {
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
