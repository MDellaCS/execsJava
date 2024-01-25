package view;

import java.util.concurrent.Semaphore;
import controller.threadSaqDep;

public class MainBanco {

	public static void main(String[] args) {

		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(2);

		for (int i = 1; i <= 20; i++) { // Ativa 20 threads (transações)

			threadSaqDep transacao = new threadSaqDep(i, s1, s2);
			transacao.start();

		}

	}

}