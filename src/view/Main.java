package view;

import controller.threadSapos;

public class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) { // Ativa 5 threads (sapos)
			threadSapos sapo = new threadSapos();
			sapo.start();
		}

	}

}