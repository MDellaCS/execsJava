package view;

import controller.threadNum;

public class Main {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) { // Ativa 5 threads
			threadNum tV = new threadNum();
			tV.start();
		}

	}

}
