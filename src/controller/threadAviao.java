package controller;

import java.util.concurrent.Semaphore;

public class threadAviao extends Thread {

	private int idAviao;
	private Semaphore pistaSul;
	private Semaphore pistaNorte;

	public threadAviao(int idAviao, Semaphore pistaSul, Semaphore pistaNorte) {
		super();
		this.idAviao = idAviao;
		this.pistaSul = pistaSul;
		this.pistaNorte = pistaNorte;
	}

	@Override
	public void run() {

		try {

			int rng = (int) (Math.random() * 2) + 0;

			if (rng == 0) {

				pistaSul.acquire();
				System.out.println("Avião " + idAviao + " entrou na Pista Sul");
				manobrar();
				taxiar();
				decolar();
				afastArea();
				System.out.println("Avião " + idAviao + " saiu da Pista Sul");

			} else {

				pistaNorte.acquire();
				System.out.println("Avião " + idAviao + " entrou na Pista Norte");
				manobrar();
				taxiar();
				decolar();
				afastArea();
				System.out.println("Avião " + idAviao + " saiu da Pista Norte");

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			pistaSul.release();
			pistaNorte.release();
		}

	}

	private void manobrar() {

		System.err.println("Avião " + idAviao + " está manobrando");

		try {
			sleep((int) (Math.random() * 4001) + 3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("Avião " + idAviao + " manobrou");

	}

	private void taxiar() {

		System.err.println("Avião " + idAviao + " está taxiando");

		try {
			sleep((int) (Math.random() * 5001) + 5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("Avião " + idAviao + " taxiou");

	}

	private void decolar() {

		System.err.println("Avião " + idAviao + " está decolando");

		try {
			sleep((int) (Math.random() * 3001) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("Avião " + idAviao + " decolou");

	}

	private void afastArea() {

		System.err.println("Afastando a área do Avião " + idAviao);

		try {
			sleep((int) (Math.random() * 5001) + 3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.err.println("Terminado de afastar a área do Avião " + idAviao);

	}

}