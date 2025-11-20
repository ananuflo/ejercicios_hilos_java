package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {
		
		// Crea dos Thread con lambdas que impriman varios mensajes.
				Thread a = new Thread(() -> {
					for (int i = 0; i < 5; i++) {
						System.out.println("Hola desde hilo A");
					}
					System.out.println("Con el ID: " + Thread.currentThread().getId());
				});

				Thread b = new Thread(() -> {
					for (int i = 0; i < 5; i++) {
						System.out.println("Hola desde hilo B");
					}
					System.out.println("Con el ID: " + Thread.currentThread().getId());
				});

				// En el main, arranca primero A con a.start().
				a.start();

				// Haz a.join() antes de b.start().
				try {
					a.join();
				} catch (InterruptedException e) {
				}
				b.start();
				// Comprueba que la salida de B no comienza hasta que A finaliza.

			}
			
	}


