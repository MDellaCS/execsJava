package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class threadSaqDep extends Thread {

	static private String tipoGlobal;
	static private boolean segueGlobal = false;
	private int i;
	private Semaphore s1;
	private Semaphore s2;

	public threadSaqDep(int i, Semaphore s1, Semaphore s2) {
		this.i = i;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {

		try {

			int Codigo = i;
			double Saldo = (double) (Math.random() * 30001) + 10000;
			double Valor = (double) (Math.random() * 3001) + 1000;
			String tipoLocal = darTipo();

			s1.acquire();

			while (segueGlobal == false) {

				segueGlobal = testaDup(Codigo, tipoLocal);

			}

			segueGlobal = false;
			s1.release();

			s2.acquire();
			calcTransacao(Codigo, Saldo, Valor, tipoLocal);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			s1.release();
			s2.release();
		}

	}

	private String darTipo() {

		Random rng = new Random();
		boolean Saque = rng.nextBoolean();

		if (Saque == true) {
			return "Saque";
		} else {
			return "Depósito";
		}

	}

	private boolean testaDup(int cod, String tipo) {

		System.out.println(cod + " " + tipo);

		if (tipo.equals(tipoGlobal) == true) {
			return false;
		} else {
			tipoGlobal = tipo;
			return true;
		}

	}

	private void calcTransacao(int C, double S, double V, String T) {

		System.err.println(C + " começou uma transação");

		if (T.equals("Saque") == true) {

			S -= V;

		} else {

			S += V;

		}

		System.err.println(C + " terminou");
		tipoGlobal = "";

	}

}