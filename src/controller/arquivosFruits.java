package controller;

import java.io.*;
import java.io.IOException;

public class arquivosFruits implements IArquivosFruits {

	@Override
	public void leDir(String path) throws IOException {

		File dir = new File(path); // Criação de dir do tipo File, com o caminho
		
		if (dir.exists() && dir.isDirectory()) { // Verifica se o diretório existe e se é um diretório

			File[] lista = dir.listFiles(); // Cria um vetor para armazenar os diretórios/arquivos da pesquisa

			for (File f : lista) { // Para cada File em lista...
				
				if (f.isDirectory()) { // Se for diretório...

					System.out.println("[" + f.getName() + "]");

				}
				
				if (f.isFile()) { // Se for arquivo...

					System.out.println(f.getName());

				}
				
			}

		} else {
			throw new IOException("File Inválido!");
		}

	}

	@Override
	public void leTxt(String absolutePath) throws IOException {

		File arquivo = new File(absolutePath); // Criação de arquivo do tipo File com o caminho do arquivo

		if (arquivo.exists()) { // Se tal arquivo existir...
			
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			System.out.println();
			System.out.printf("| %-50s | %-50s | %-20s |", "Nome", "Nome Científico", "Sub Grupo"); // Tabulação com printf
			System.out.println();
			System.out.printf("| %-50s | %-50s | %-20s |", "", "", "");
			System.out.println();

			while (linha != null) {

				if (linha.contains(",Fruits,")) { // Se a linha é uma Fruta...

					if (linha.contains("\"")) { // Tratamento especial para algumas frutas

						String v[] = linha.split("\"");
						String v2[] = v[2].split(",");

						System.out.printf("| %-50s | %-50s | %-20s |", v[1].trim(), v2[1].trim(), v2[3].trim());
						System.out.println();

					} else { // Tratamento normal para a maioria das frutas

						String v[] = linha.split(",");

						System.out.printf("| %-50s | %-50s | %-20s |", v[0].trim(), v[1].trim(), v[3].trim());
						System.out.println();

					}

				}

				linha = buffer.readLine(); // Próxima linha
			}

			buffer.close();
			leitor.close();
			fluxo.close();

		} else {
			throw new IOException("Arquivo Inválido!");
		}

	}

}