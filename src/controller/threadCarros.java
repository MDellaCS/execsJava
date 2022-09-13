package controller;

import java.util.concurrent.Semaphore;

public class threadCarros extends Thread {

	static String sentidoCarro;
	private int idCarro;
	private Semaphore semaforo;

	public threadCarros(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		try {

			semaforo.acquire();
			carroCruzar();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			semaforo.release();

		}

	}

	private void carroCruzar() {

		int idSentido = idCarro;
		
		idSentido %= 4;

		if (idSentido == 0) {
			sentidoCarro = "Esquerda para Direita";
		}
		if (idSentido == 1) {
			sentidoCarro = "Cima para Baixo";
		}
		if (idSentido == 2) {
			sentidoCarro = "Direita para Esquerda";
		}
		if (idSentido == 3) {
			sentidoCarro = "Baixo para Cima";
		}

		System.err.println("Carro " + idCarro + " está cruzando com sentido: " + sentidoCarro);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Carro " + idCarro + " cruzou.\n");

	}

}