package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main {

	public static void main(String[] args) {

		KillController killer = new KillController(); // Instância de KillController para chamarmos seus métodos

		String[] infoSO = killer.os(); // Método os, tudo vai no vetor

		int opc = 0; // opc para o switch/while

		while (opc != 9) { // Enquanto não for 9...

			opc = Integer.parseInt(JOptionPane.showInputDialog("ULTIMATE TASK KILLER\n\nSaudações " + infoSO[3]
					+ ".\nPortador(a) da máquina: " + infoSO[0] + " | v" + infoSO[1] + " | " + infoSO[2].substring(3, 5)
					+ " bits"
					+ "\n\nO que deseja?\n\n1 - Quero uma lista de todas as vítimas, por favor.\n2 - Procuro matar por PID.\n3 - Procuro matar por Nome.\n\n9 - Desejo sair.\n(Pessoa de bem)\n\n"));

			switch (opc) { // Escolha...

			case 1: // 1º método
				killer.listaProcessos(infoSO[0]);
				break;

			case 2: // 2º método
				String pid = JOptionPane.showInputDialog("Me informe o PID do alvo.");
				killer.mataPID(pid, infoSO[0]);
				break;

			case 3: // 3º método
				String nome = JOptionPane.showInputDialog("Me informe o Nome do alvo.");
				killer.mataNome(nome, infoSO[0]);
				break;

			case 9: // Fecha o programa
				JOptionPane.showMessageDialog(null, "Até mais...");
				System.exit(0); // Morte ao Java!
				break;

			default: // Nenhum dos acima
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;

			}

		}

	}

}