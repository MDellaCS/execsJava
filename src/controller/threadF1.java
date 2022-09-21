package controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class threadF1 extends Thread {

	private int idCarro;
	private Semaphore pista;
	private String timeCarro;
	private static double[] podio = { 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100 };
	private static int iPodio = 0;

	public threadF1(int idCarro, Semaphore pista, String timeCarro) {
		this.idCarro = idCarro;
		this.pista = pista;
		this.timeCarro = timeCarro;
	}

	@Override
	public void run() {

		try {

			System.out.println(timeCarro + " #" + idCarro + " quer entrar na pista");
			sleep(1000);
			pista.acquire();
			System.err.println(timeCarro + " #" + idCarro + " entrou na pista");
			correr();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			pista.release();
		}

	}

	private void correr() {

		double tI = System.nanoTime();

		int voltaAtual = 1;
		while (voltaAtual <= 3) {

			try {
				sleep((int) (Math.random() * 500) + 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(timeCarro + " #" + idCarro + " deu " + voltaAtual + " volta(s)");

			voltaAtual++;
		}

		double tF = (System.nanoTime() - tI) / Math.pow(10, 9);

		if (tF < podio[iPodio]) {
			podio[(iPodio + 1)] = podio[iPodio];
			podio[iPodio] = tF;
			Arrays.sort(podio);
			iPodio++;
		}

		System.err.println(timeCarro + " #" + idCarro + " terminou a corrida em " + tF + "s (" + iPodio + "o lugar)");

		if (iPodio == 14) {
			System.out.println("\nPódio Da Corrida\n");

			for (iPodio = 0; iPodio < 14; iPodio++) {
				System.out.println(podio[iPodio]);
			}
		}

	}

}