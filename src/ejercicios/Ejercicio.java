package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {
		
		// En run(), usa un for del 1 al 5.
		Thread hilo = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Soy: " + Thread.currentThread().getName() + ", i: " + i);
				// En cada iteración imprime el número y llama a Thread.sleep(1000).
				try {
					Thread.sleep(1000);
					// Captura InterruptedException con try/catch.
				} catch (InterruptedException e) {
				}
			}
		});

		hilo.start();
		
		// Comprueba que el hilo principal puede seguir haciendo otras cosas mientras tanto.
		for (int i = 0; i < 10; i++) {
			System.out.println("Soy: " + Thread.currentThread().getName() + ", i: " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}

	}
			
	}


