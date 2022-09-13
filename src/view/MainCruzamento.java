package view;

import java.util.concurrent.Semaphore;
import controller.threadCarros;

public class MainCruzamento {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 4; i++) { // Ativa 4 threads (pessoas)

			threadCarros carro = new threadCarros(i, semaforo);
			carro.start();

		}

	}

}