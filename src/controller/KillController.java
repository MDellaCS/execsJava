package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {

	public String[] os() { // Pega informações do PC

		String[] infoSO = new String[4];

		infoSO[0] = System.getProperty("os.name"); // Nome do sistema, se é Windows, Linux...
		infoSO[1] = System.getProperty("os.version"); // Versão do sistema, 10.0, 1.7.10...
		infoSO[2] = System.getProperty("os.arch"); // Bitagem, 32x ou 64x
		infoSO[3] = System.getProperty("user.name"); // Nome do usuário logado

		return infoSO;

	}

	@SuppressWarnings("deprecation")
	public void listaProcessos(String nSO) { // Lista todos os processos atuais do PC, depende do SO

		String processo = ""; // String que receberá o comando dependendo do SO

		if (nSO.contains("Windows")) { // Se for Windows...
			processo = "tasklist /fo table"; // Mostrar os processos arrumadinhos em tabela, ADM se precisar

		} else if (nSO.contains("Linux")) { // Se for Linux...
			processo = "ps -ef"; // Processos

		} else { // Se for inválido...
			JOptionPane.showMessageDialog(null, "Seu SO não é suportado por este programa.");
		}

		try { // Tenta fazer o que está aqui. Se falhar por qualquer motivo, é conta do Catch
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String txt = "PROCESSOS ATIVOS NA MÁQUINA\n\n";

			while (linha != null) {
				txt += linha + "\n";
				linha = buffer.readLine();
			}

			System.out.println(txt);
			JOptionPane.showMessageDialog(null, "No console, chefia.");

			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (Exception e) { // Qualquer exceção virá aqui
			String[] separador = e.getMessage().split(", "); // Separa a mensagem para ficar mais simples
			System.err.println("Erro: \n" + separador[1] + "\n"); // Mostra o erro

			if (e.getMessage().contains("740")) { // Se for o erro de elevação...

				System.err.println("Tentando rodar novamente com cmd /c\n\n");

				String elevacao = "cmd /c "; // Comando para pedir ADM
				elevacao += processo; // Coloca elevacao antes de processo

				try {
					Runtime.getRuntime().exec(elevacao); // Tenta novamente
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

	@SuppressWarnings("deprecation")
	public void mataPID(String PID, String nSO) {

		String processo = "";

		if (nSO.contains("Windows")) {
			processo = "TASKKILL /PID " + PID;

		} else if (nSO.contains("Linux")) {
			processo = "kill -9 " + PID;

		} else {
			JOptionPane.showMessageDialog(null, "Seu SO não é suportado por este programa.");
		}

		try { // Tenta fazer o que está aqui. Se falhar por qualquer motivo, é conta do Catch
			Runtime.getRuntime().exec(processo);

			JOptionPane.showMessageDialog(null, "PID cancelado.\n(Por PID)\n\n");

		} catch (Exception e) { // Qualquer exceção virá aqui
			String[] separador = e.getMessage().split(", "); // Separa a mensagem para ficar mais simples
			System.err.println("Erro: \n" + separador[1] + "\n"); // Mostra o erro

			if (e.getMessage().contains("740")) { // Se for o erro de elevação...

				System.err.println("Tentando rodar novamente com cmd /c\n\n");

				String elevacao = "cmd /c "; // Comando para pedir ADM
				elevacao += processo; // Coloca elevacao antes de processo

				try {
					Runtime.getRuntime().exec(elevacao); // Tenta novamente
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

	@SuppressWarnings("deprecation")
	public void mataNome(String nPr, String nSO) {

		String processo = "";

		if (nSO.contains("Windows")) {
			processo = "TASKKILL /IM " + nPr;

		} else if (nSO.contains("Linux")) {
			processo = "pkill -f " + nPr;

		} else {
			JOptionPane.showMessageDialog(null, "Seu SO não é suportado por este programa.");
		}

		try { // Tenta fazer o que está aqui. Se falhar por qualquer motivo, é conta do Catch
			Runtime.getRuntime().exec(processo);

			JOptionPane.showMessageDialog(null, "PID cancelado.\n(Por Nome)\n\n");

		} catch (Exception e) { // Qualquer exceção virá aqui
			String[] separador = e.getMessage().split(", "); // Separa a mensagem para ficar mais simples
			System.err.println("Erro: \n" + separador[1] + "\n"); // Mostra o erro

			if (e.getMessage().contains("740")) { // Se for o erro de elevação...

				System.err.println("Tentando rodar novamente com cmd /c\n\n");

				String elevacao = "cmd /c "; // Comando para pedir ADM
				elevacao += processo; // Coloca elevacao antes de processo

				try {
					Runtime.getRuntime().exec(elevacao); // Tenta novamente
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

}
