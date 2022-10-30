package controller;

import java.io.IOException;

public interface IArquivosFruits { // Essa é a Interface que é assinada for arquivosFruits, onde essa última terá de implementar todos os métodos presentes aqui

	public void leDir(String path) throws IOException;
	public void leTxt(String absolutePath) throws IOException;

}
