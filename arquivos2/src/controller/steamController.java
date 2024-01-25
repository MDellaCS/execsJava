package controller;

import java.io.*;
import java.io.IOException;

public class steamController {

	public void leDir(String dirSteam, String dirGravar) throws IOException {

		File dir1 = new File(dirSteam); // Criação de dir do tipo File, com o caminho
		File dir2 = new File(dirGravar);

		if (dir1.exists() && dir1.isDirectory() && dir2.exists() && dir2.isDirectory()) { // Verifica se oo diretórioo
																							// existem e se são
																							// diretórios

			File[] lista1 = dir1.listFiles(); // Cria um vetor para armazenar os diretórios/arquivos da pesquisa
			File[] lista2 = dir2.listFiles();

			System.out.println("\nArquivos em " + dirSteam + "\n");
			for (File f : lista1) { // Para cada File em lista...

				if (f.isDirectory()) { // Se for diretório...

					System.out.println("[" + f.getName() + "]");

				}

				if (f.isFile()) { // Se for arquivo...

					System.out.println(f.getName());

				}

			}

			System.out.println("\nArquivos em " + dirGravar + "\n");
			for (File f : lista2) { // Para cada File em lista...

				if (f.isDirectory()) { // Se for diretório...

					System.out.println("[" + f.getName() + "]");

				}

				if (f.isFile()) { // Se for arquivo...

					System.out.println(f.getName());

				}

			}

		} else {
			throw new IOException("Erro de Caminho!");
		}

	}

	public void leSteam(String fileSteam, int ano, String mes, double valor) throws IOException {

		File arquivo = new File(fileSteam); // Criação de arquivo do tipo File com o caminho do arquivo

		if (arquivo.exists()) { // Se tal arquivo existir...

			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine(); // Pulando a primeira linha do arquivo

			System.out.println();
			System.out.printf("| %-100s | %-20s |", "Título", "Média de Jogadores Ativos");
			System.out.println();
			System.out.printf("| %-100s | %-20s |", "", "");
			System.out.println();

			while (linha != null) {

				String v[] = linha.split(",");

				if (ano == Integer.parseInt(v[1]) && mes.contains(v[2]) && valor <= Double.parseDouble(v[3])) {

					System.out.printf("| %-100s | %-20s |", v[0], v[3]);
					System.out.println();

				}

				linha = buffer.readLine();

			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo Inválido!");
		}

	}

	public void gravaArquivo(String fileSteam, String fileGravar, int ano, String mes) throws IOException {

		File arquivo = new File(fileSteam); // Criação de arquivo do tipo File com o caminho do arquivo

		if (arquivo.exists()) { // Se tal arquivo existir...

			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine(); // Pulando a primeira linha do arquivo

			BufferedWriter io = new BufferedWriter(new FileWriter(fileGravar));

			while (linha != null) {

				String v[] = linha.split(",");

				if (ano == Integer.parseInt(v[1]) && mes.contains(v[2])) {

					io.write(v[0] + " ; " + v[3]);
					io.newLine();

				}

				linha = buffer.readLine();

			}

			System.out.println("\n\nArquivo Gerado.");

			io.close();
			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo Inválido!");
		}

	}
}