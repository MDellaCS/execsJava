package view;

import java.util.concurrent.Semaphore;
import controller.threadF1;

public class MainF1 {

	public static void main(String[] args) {

		String[] times = { "Ferrari", "McLaren", "Mercedes", "Red Bull", "Alpine", "Willians", "Aston Martin" };
		int time = 0;
		int num = 0;
		Semaphore pista = new Semaphore(5);

		for (int i = 0; i < 14; i++) { // Ativa 14 threads (carros)

			if (i > 6) {
				time = i - 7;
				num = 2;
			}else {
				time = i;
				num = 1;
			}
			
			threadF1 t = new threadF1(num, pista, times[time]);
			t.start();

		}

	}

}