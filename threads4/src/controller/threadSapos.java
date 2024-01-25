package controller;

public class threadSapos extends Thread {

	static int maxPulo = 25; // Pulo máximo de cada sapo
	static int maxDist = 100; // Linha de chegada
	static int i = 1; // Variável para fazer o pódio

	public threadSapos() {
	}

	@Override
	public void run() {

		int puloSapo = 0; // Tamanho do pulo
		int localSapo = 0; // Onde esse sapo está
		int contPulo = 0; // Contador de pulos

		while (localSapo < maxDist) { // O ato de correr de cada sapo

			puloSapo = (int) (Math.random() * maxPulo) + 0; // Tamanho random do pulo
			localSapo += puloSapo; // Distância total do sapo
			contPulo++;
			System.out.println("Sapo #" + getId() + " deu um salto de " + puloSapo + " metros.\n(" + localSapo + "/"
					+ maxDist + ")\n");

		}

		System.err.println("Sapo #" + getId() + " chegou em " + i + "o! Com " + contPulo + " pulos.\n");
		i++;

	}

}