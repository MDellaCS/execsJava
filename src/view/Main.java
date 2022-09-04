package view;

import controller.threadVetor;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {

		int[] vetor = new int[1000];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 100) + 1;
		}

		for(int i=1;i<=2;i++) {
			threadVetor tV = new threadVetor(i, vetor);
			tV.start();
		}

	}

}
