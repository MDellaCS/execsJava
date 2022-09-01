package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class RedesController {

	public String[] os() { // O certo era esse método privadamente só pegar o nome do SO, mas decidi fazer
							// ele pegar mais algumas coisas, e mostrar no menu no Main

		String[] infoSO = new String[4]; // Cria um vetor para armazenar algumas informações do sistema

		infoSO[0] = System.getProperty("os.name"); // Nome do sistema, se é Windows, Linux...
		infoSO[1] = System.getProperty("os.version"); // Versão do sistema, 10.0, 1.7.10...
		infoSO[2] = System.getProperty("os.arch"); // Bitagem, 32x ou 64x
		infoSO[3] = System.getProperty("user.name"); // Nome do usuário logado

		return infoSO; // Retorna as informações coletadas

	}

	@SuppressWarnings("deprecation")
	public void ip(String nSO) { // Da um comando e mostra o nome dos Adaptadores e seus IPv4s, comando depende
									// do SO

		// nSO = "Teste"; Linha para testar em SO inválido

		String processo = ""; // String que receberá o comando dependendo do SO

		if (nSO.contains("Windows")) { // Se for Windows...
			processo = "ipconfig"; // Mostrar redes no sistema, permissão de ADM se necessária

		} else if (nSO.contains("Linux")) { // Se for Linux...
			processo = "ifconfig"; // Mostrar redes no sistema

		} else { // Se for inválido...
			JOptionPane.showMessageDialog(null, "Seu SO não é suportado por este programa.");
		}

		try { // Tenta fazer o que está aqui. Se falhar por qualquer motivo, é conta do Catch
			Process p = Runtime.getRuntime().exec(processo); // Executa um código no Terminal, tentando criar um
																// processo filho
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); // Próxima linha, nesse caso, a primeira

			String txt = "Adaptadores e seus IPv4s\n\n"; // String para armazenar toda a mensagem final, e mais um
															// cabeçalho

			while (linha != null) { // Enquanto a linha não for vazia...

				String[] separador; // Esse vetor de String recebera os splits

				if (nSO.contains("Windows") && linha.contains("Adaptador Ethernet")) { // Se a linha tiver o texto...
					separador = linha.split(":"); // Separa no :
					txt += separador[0] + "\n"; // Escreve em txt
				}

				if (nSO.contains("Windows") && linha.contains("IPv4")) { // Se a linha tiver o texto...
					txt += "IPv4 dele é: "; // Escreve em txt
					separador = linha.split(": "); // Sepera no : (com um espaço depois do :)
					txt += separador[1] + "\n\n"; // Escreve em txt
				}

				if (nSO.contains("Linux") && linha.contains("flags=")) { // Se a linha tiver o texto...
					separador = linha.split(":"); // Separa no :
					txt += separador[0] + "\n"; // Escreve em txt
				}

				if (nSO.contains("Linux") && linha.contains("inet ")) { // Se a linha tiver o texto...
					txt += "IPv4 dele é: "; // Escreve em txt
					separador = linha.split("inet "); // Separa em inet (com um espaço depois do inet)
					separador = separador[1].split(" netmask"); // Separa em netmask (com um espaço antes de
																// netmask)
					txt += separador[0] + "\n\n"; // Escreve em txt
				}

				linha = buffer.readLine(); // Próxima linha

			}

			JOptionPane.showMessageDialog(null, txt); // Mostra tudo que foi acumulado em txt

			buffer.close(); // Fecha o buffer para salvar memória
			leitor.close(); // Mesma coisa
			fluxo.close(); // " "

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
	public void ping(String nSO) { // Pinga o Google e diz o ms médio

		// nSO = "Teste"; Linha para testar em SO inválido

		String processo = ""; // String que receberá o comando dependendo do SO

		if (nSO.contains("Windows")) { // Se for Windows...
			processo = "ping -4 -n 10 www.google.com.br"; // Pingar Google com IPv4 10 vezes, permissão de ADM se
															// necessária

		} else if (nSO.contains("Linux")) { // Se for Linux...
			processo = "ping -4 -c 10 www.google.com.br"; // Pingar Google com inet 10 vezes

		} else { // Se for inválido...
			JOptionPane.showMessageDialog(null, "Seu SO não é suportado por este programa.");
		}

		try { // Tenta executar o que está aqui, erro irá pro Catch
			Process p = Runtime.getRuntime().exec(processo); // Executa o comando criando um Processo filho
			JOptionPane.showMessageDialog(null, "Pingando o Google...\n(De OK quando quiser)\n\n"); // Textinho para
																									// distrair
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine(); // Primeira linha

			String txt = "Tempo médio do ping: "; // Texto final + cabeçalho

			while (linha != null) { // Enquanto a linha não estiver vazia...

				String[] separador; // String para receber os splits

				if (nSO.contains("Windows") && linha.contains("dia = ")) { // Se for Windows faz isso
					separador = linha.split("dia = "); // Split pelo "dia" de média
					txt += separador[1];
				}

				if (nSO.contains("Linux") && linha.contains("min/avg/max")) { // Linux faz isso
					separador = linha.split("= ");
					separador = separador[1].split("/");
					txt += separador[1] + "ms";
				}

				linha = buffer.readLine(); // Próxima linha

			}

			JOptionPane.showMessageDialog(null, txt + "\n\n"); // Mostra o resultado

			buffer.close(); // Fecha o buffer para salvar memória
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

}
