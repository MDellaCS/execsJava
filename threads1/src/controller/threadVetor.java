package controller;

import javax.swing.JOptionPane;

public class threadVetor extends Thread {

	private int num; // Número a ser recebido pelo parâmetro
	private int[] vet; // Vetor a ser recebido pelo parâmetro

	public threadVetor(int num, int[] vet) {
		this.num = num; // Número recebido pelo parâmetro
		this.vet = vet; // Vetor recebido pelo parâmetro
	}

	@Override
	public void run() {

		if ((num % 2) == 0) { // Se for par...

			double tI = System.nanoTime(); // Pega o tempo inicial

			for (int i = 0; i < vet.length; i++) { // Percorre o vetor com For
				vet[i] *= 2;
				vet[i] /= 2;
				vet[i] *= 2;
				vet[i] /= 2;
				vet[i] *= 2;
				vet[i] /= 2;
				System.out.println(vet[i]); // Só pra tomar um tempo
			}

			double tF = System.nanoTime(); // Pega o tempo final

			double tT = (tF - tI) / Math.pow(10, 9); // Calcula o tempo total e converte de ns para s

			JOptionPane.showMessageDialog(null, "Tempo do For: " + tT + "s"); // Apresenta o resultado

		} else { // Se for ímpar...

			double tI = System.nanoTime();

			for (int v : vet) { // Percorre o vetor com For Each
				v *= 2;
				v /= 2;
				v *= 2;
				v /= 2;
				v *= 2;
				v /= 2;
				System.out.println(v);
			}

			double tF = System.nanoTime();

			double tT = (tF - tI) / Math.pow(10, 9);

			JOptionPane.showMessageDialog(null, "Tempo do For Each: " + tT + "s");
		}

	}

}
