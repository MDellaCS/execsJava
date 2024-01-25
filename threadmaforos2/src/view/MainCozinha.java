package view;

import java.util.concurrent.Semaphore;
import controller.threadCozinha;

public class MainCozinha {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 5; i++) {

			threadCozinha prato = new threadCozinha(i, semaforo);
			prato.start();

		}

	}

}