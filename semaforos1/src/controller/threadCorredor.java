package controller;

import java.util.concurrent.Semaphore;

public class threadCorredor extends Thread {

	static int tamCorredor = 200;
	private int idPessoa;
	private Semaphore semaforo;
	
	public threadCorredor(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		
		andarCorredor();
		
		try {
			
			semaforo.acquire();
			passarPorta();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			semaforo.release();
			
		}

	}

	private void andarCorredor() {

		int velPessoa = (int) (Math.random() * 2) + 4;
		int localPessoa = 0;

		while (localPessoa < tamCorredor) {

			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			localPessoa += velPessoa;

			if (localPessoa > 200)
				localPessoa = 200;

			System.out.println("Pessoa " + idPessoa + " andou " + localPessoa + " metros.\n(" + localPessoa + "/" + tamCorredor + ")\n");

		}

		System.err.println("Pessoa " + idPessoa + " chegou na porta.\n");

	}

	private void passarPorta() {

		System.err.println("Pessoa " + idPessoa + " está passando pela porta.\n");

		int tempoPassar = (int) (Math.random() * 1001) + 1000;

		try {
			sleep(tempoPassar);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.err.println("Pessoa " + idPessoa + " passou pela porta.\n" + "(Demorou " + tempoPassar + "ms)\n");

	}

}