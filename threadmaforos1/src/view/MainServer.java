package view;

import java.util.concurrent.Semaphore;
import controller.threadServer;

public class MainServer {

	public static void main(String[] args) {

		Semaphore semaforo = new Semaphore(1);

		for (int i = 1; i <= 21; i++) {

			threadServer server = new threadServer(i, semaforo);
			server.start();

		}

	}

}