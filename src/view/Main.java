package view;
//ASFDASSA
import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {

		RedesController rCont = new RedesController(); // Instância de RedesController para chamarmos seus métodos

		String[] infoSO = rCont.os(); // Método os, tudo vai no vetor

		int opc = 0; // opc para o switch/while

		while (opc != 9) { // Enquanto não for 9...

			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU PROCESSOS DE REDE\n\nOlá " + infoSO[3]
					+ "!\nSeu SO: " + infoSO[0] + " | v" + infoSO[1] + " | " + infoSO[2].substring(3, 5) + " bits"
					+ "\n\nEscolha uma das opções:\n\n1 - Mostrar IPv4s da máquina\n2 - Tempo médio de ping pro Google\n3 - Como sabe das minhas informações?\n\n9 - Sair\n\n"));

			switch (opc) { // Escolha...

			case 1: // 1º método
				rCont.ip(infoSO[0]);
				break;

			case 2: // 2º método
				rCont.ping(infoSO[0]);
				break;

			case 3: // Brincadeirinha
				JOptionPane.showMessageDialog(null, "System.getProperties();\n:)\n\n");
				break;

			case 9: // Fecha o programa
				JOptionPane.showMessageDialog(null, "Você escolheu sair...");
				System.exit(0); // Morte ao Java!
				break;

			default: // Nenhum dos acima
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;

			}

		}

	}

}
