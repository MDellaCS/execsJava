package view;

import java.io.IOException;
import javax.swing.JOptionPane;
import controller.IArquivosFruits;
import controller.arquivosFruits;

public class mainFruits {

	public static void main(String[] args) {

		String path = "C:\\TEMP"; // Caminho do diretório que será vasculhado
		String absolutePath = "C:\\TEMP\\generic_food.csv"; // Caminho do arquivo que terá seu conteúdo mostrado

		IArquivosFruits af = new arquivosFruits();

		try { // As exceptions do controller cairão aqui

			af.leDir(path);
			af.leTxt(absolutePath);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Houve um erro.", JOptionPane.ERROR_MESSAGE);
		}

	}

}
