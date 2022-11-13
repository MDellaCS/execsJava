package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.steamController;

public class mainSteam {

	public static void main(String[] args) {

		String dirSteam = "C:\\TEMP"; // Caminho do diretório que será vasculhado
		String fileSteam = "C:\\TEMP\\SteamCharts.csv"; // Caminho do arquivo que terá seu conteúdo mostrado
		String dirGravar = "C:\\TEMP";
		String fileGravar = "C:\\TEMP\\Gravado.txt";
		
		steamController sC = new steamController();

		try { // As exceptions do controller cairão aqui

			int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um ano: "));
			int mes = Integer.parseInt(JOptionPane.showInputDialog("Digite um mês: (Número do mês)"));
			String Smes = "";
			
			switch(mes) {
			
			case 1: Smes = "January"; break;
			case 2: Smes = "February"; break;
			case 3: Smes = "March"; break;
			case 4: Smes = "April"; break;
			case 5: Smes = "May"; break;
			case 6: Smes = "June"; break;
			case 7: Smes = "July"; break;
			case 8: Smes = "August"; break;
			case 9: Smes = "September"; break;
			case 10: Smes = "October"; break;
			case 11: Smes = "November"; break;
			case 12: Smes = "December"; break;
			default: throw new IOException("Mês Inválido!");
			
			}
				
			double valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor para a pesquisa: "));

			sC.leDir(dirSteam, dirGravar);
			sC.leSteam(fileSteam, ano, Smes, valor);
			sC.gravaArquivo(fileSteam, fileGravar, ano, Smes);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro.", JOptionPane.ERROR_MESSAGE);
		}

	}

}
