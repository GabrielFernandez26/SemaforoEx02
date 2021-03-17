package controller;

import java.util.Set;
import java.util.concurrent.Semaphore;

public class Pratos extends Thread {

	private Semaphore semaforo;

	public Pratos(Semaphore semaforo) {
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			inicio();
			semaforo.acquire();
			cozinhando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void inicio() {
		int tempo;
		float percentualCozimento;
			try {
				if ((getId()) % 2 == 0) {
					sleep(100);
					tempo = (int) ((Math.random() * 301) + 500);
					percentualCozimento = (int) (tempo / 0.1f);
					System.out.println("A " + getId() + "a. sopa de cebola foi inicializada");
					System.out.println("O percentual de cozimento da " + getId() + "a. sopa de cebola foi " + percentualCozimento);

				} else {
					sleep(100);
					tempo = (int) ((Math.random() * 601) + 600);
					percentualCozimento = (int) (tempo / 0.1f);
					System.out.println("A " + getId() + "a. lasanha à bolonhesa foi inicializada");
					System.out.println("O percentual de da " + (getId()) + " a. lasanha à bolonhesa cozimento foi "+ percentualCozimento);
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	private void cozinhando() {
		int tempo;
			try {
				if ((getId()) % 2 == 0) {
				sleep(500);
				tempo = (int)((Math.random() * 301 ) + 500);
				System.out.println("A " +getId()+ "a. sopa de cebola está cozinhando");
				
			} else {
				sleep(500);
				tempo = (int)((Math.random() * 601) + 600);
			}System.out.println("A " +getId()+ "a. lasanha à bolonhesa está pronta");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
