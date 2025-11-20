package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {
		
		// Crea un hilo que haga sleep(3000) para simular tarea larga.
				Thread t = new Thread(() -> {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					}
					System.out.println("FIN");
				});

				// En el main, tras t.start(), usa t.join(1000).
				try {
					t.start();
					t.join(1000);
					// Después del join con timeout, comprueba t.isAlive() para saber si terminó.
					// Muestra mensajes distintos según haya terminado o haya expirado el tiempo.
					if (t.isAlive()) {
						System.out.println("Está vivo");
					} else {
						System.out.println("Terminó");
					}
				} catch (InterruptedException e) {
				}

			}
			
	}


