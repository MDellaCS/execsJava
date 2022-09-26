package view;

import java.util.concurrent.Semaphore;
import controller.threadAviao;

public class MainAeroporto {

    public static void main(String[] args) {

        Semaphore pistaSul = new Semaphore(1);
        Semaphore pistaNorte = new Semaphore(1);

        for (int i = 1; i <= 12; i++) { // Ativa 12 threads (aviões)

            threadAviao t = new threadAviao(i, pistaSul, pistaNorte);
            t.start();

        }

    }

}