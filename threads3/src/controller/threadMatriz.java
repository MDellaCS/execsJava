package controller;

public class threadMatriz extends Thread {

	int i;
	int[][] m;

	public threadMatriz(int i, int[][] m) {
		this.i = i;
		this.m = m;
	}

	@Override
	public void run() {

		int[] soma = new int[3]; // Vetor para armazenar as somas

		for (int c = 0; c < 5; c++) { //Percorre cada coluna com a linha fixa em i para cada thread
			soma[i] += m[i][c];
		}

		System.out.println("Soma dos números da linha " + (i+1) + ": " + soma[i]);

	}

}
