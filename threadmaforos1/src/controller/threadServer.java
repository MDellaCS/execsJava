package controller;

import java.util.concurrent.Semaphore;

public class threadServer extends Thread {

	private int idThread;
	private Semaphore semaforo;

	public threadServer(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {

		try {
			calcServer();
			semaforo.acquire();
			bdServer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void calcServer() {
		
		System.out.println("Thread " + idThread + " começou um cálculo\n");

		int tempo = 0;

		if ((idThread % 3) == 1) {

			try {
				tempo = (int) (Math.random() * 801) + 200;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 3) == 2) {

			try {
				tempo = (int) (Math.random() * 1001) + 500;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 3) == 0) {

			try {
				tempo = (int) (Math.random() * 1001) + 1000;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Cálculo da Thread " + idThread + " durou " + tempo + "ms\n");

	}

	private void bdServer() {
		
		System.err.println("Thread " + idThread + " começou uma transação\n");

		int tempo = 0;

		if ((idThread % 3) == 1) {

			try {
				tempo = 1000;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 3) == 2) {

			try {
				tempo = 1500;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if ((idThread % 3) == 0) {

			try {
				tempo = 1500;
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.err.println("Transação da Thread " + idThread + " durou " + tempo + "ms\n");

	}

}