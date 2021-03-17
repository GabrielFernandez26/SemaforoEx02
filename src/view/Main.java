package view;

import java.util.concurrent.Semaphore;

import controller.Pratos;

public class Main {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int i = 0; i < 5; i++) {
			int id = (int)((Math.random()*11) + 1);
			Thread t = new Pratos(id, semaforo);
			t.start();
		}
	}

}
