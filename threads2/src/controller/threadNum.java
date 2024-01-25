package controller;

public class threadNum extends Thread {

	public threadNum() {

	}

	@Override
	public void run() {

		System.out.println("#" + getId()); // Mostra o TID

	}

}
