package view;

import controller.threadVetor;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {

		int[] vetor = new int[1000]; // Cria um vetor com 1000 espaços

		for (int i = 0; i < vetor.length; i++) { // Preenche esse vetor com números randoms de 1 a 100
			vetor[i] = (int) (Math.random() * 100) + 1;
		}

		for(int i=1;i<=2;i++) { // Ativa as 2 threads com 1 e 2 e o mesmo vetor
			threadVetor tV = new threadVetor(i, vetor);
			tV.start();
		}

	}

}
