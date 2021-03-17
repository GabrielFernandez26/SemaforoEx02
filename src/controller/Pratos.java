package controller;

import java.util.concurrent.Semaphore;

public class Pratos extends Thread{
	
	private int id;
	private Semaphore semaforo;
	
	public Pratos(int id, Semaphore semaforo) {
	this.id = id;
	this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			inicio(id);
			semaforo.acquire();
			cozinhando(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}
	
	private void inicio(int id) {
		int tempo;
		float percentualCozimento;
			try {
				if (id % 2 == 0) {
				sleep(100);
				tempo = (int)((Math.random() * 301 ) + 500);
				percentualCozimento = (int)(tempo / 0.1f);
				System.out.println("A " +id+ "a. sopa de cebola foi inicializada");
				System.out.println("O percentual de cozimento da " +id+ "a. sopa de cebola foi " +percentualCozimento);
			} else {
				sleep(100);
				tempo = (int)((Math.random() * 301 ) + 500);
				percentualCozimento = (int)(tempo / 0.1f);
				System.out.println("A " +id+ "a. lasanha à bolonhesa foi inicializada");
				System.out.println("O percentual de da " +id+" a. lasanha à bolonhesa cozimento foi " +percentualCozimento);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	private void cozinhando(int id) {
		int tempo;
			try {
				if (id % 2 == 0) {
				sleep(500);
				tempo = (int)((Math.random() * 301 ) + 500);
				System.out.println("A " +id+ "a. sopa de cebola está cozinhando");
				
			} else {
				sleep(500);
				tempo = (int)((Math.random() * 301 ) + 500);
			}System.out.println("A " +id+ "a. lasanha à bolonhesa está pronta");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
