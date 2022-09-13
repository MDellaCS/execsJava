package view;

import java.util.concurrent.Semaphore;
import controller.threadCorredor;

public class MainCorredor {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { // Ativa 4 threads (pessoas)

			threadCorredor pessoa = new threadCorredor(i, semaforo);
			pessoa.start();

		}

	}

}