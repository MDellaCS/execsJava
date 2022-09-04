package view;

import controller.threadMatriz;

public class Main {

	public static void main(String[] args) {

		int[][] m = new int[3][5]; // Matriz 3 x 5

		for (int l = 0; l < 3; l++) { // Percorre a matriz
			for (int c = 0; c < 5; c++) {
				m[l][c] = (int) (Math.random() * 10) + 1; // Preenche cada espaço com um número random de 1 a 10
			}
		}

		for (int i = 0; i < 3; i++) { // Ativa 3 threads
			threadMatriz tV = new threadMatriz(i, m);
			tV.start();
		}

	}

}