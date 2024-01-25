package controller;

import java.util.concurrent.Semaphore;

public class threadCozinha extends Thread {

	private int idThread;
	private Semaphore semaforo;

	public threadCozinha(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		String[] infPrato = new String[2];

		try {

			cozinharPrato(infPrato);
			semaforo.acquire();
			entregarPrato(infPrato);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private String[] cozinharPrato(String[] iP) {

		if ((idThread % 2) == 1) {

			try {

				int tempoTotal = (int) (Math.random() * 301) + 500;

				iP[0] = "Sopa de Cebola";
				System.err.println("Preparando uma " + iP[0] + "!\nPrato n" + idThread + "\n");

				int tempo = 0;
				double porcent = 0;
				while (tempoTotal > tempo) {

					porcent += 100 / (tempoTotal / 100);
					if (porcent > 100)
						porcent = 100;
					System.out.println("Prato n" + idThread + " está " + porcent + "% pronto.\n");
					sleep(100);
					tempo += 100;

				}

				iP[1] = String.valueOf(tempo);
				sleep(tempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 2) == 0) {

			try {

				int tempoTotal = (int) (Math.random() * 601) + 600;

				iP[0] = "Lasanha a Bolonhesa";
				System.err.println("Preparando uma " + iP[0] + "!\nPrato n" + idThread + "\n");

				int tempo = 0;
				double porcent = 0;
				while (tempoTotal > tempo) {

					porcent += 100 / (tempoTotal / 100);
					if (porcent > 100)
						porcent = 100;
					System.out.println("Prato n" + idThread + " está " + porcent + "% pronto.\n");
					sleep(100);
					tempo += 100;

				}

				iP[1] = String.valueOf(tempo);
				sleep(tempo);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		return iP;

	}

	private void entregarPrato(String[] iP) {

		try {

			sleep(500);
			System.err.println(
					"Saindo uma " + iP[0] + " no capricho! Cozinhada em " + iP[1] + "ms\n(Prato n" + idThread + ")\n");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}