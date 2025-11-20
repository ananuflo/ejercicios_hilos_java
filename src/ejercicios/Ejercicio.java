package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {
		
		// Crea un Thread cuyo run() haga sleep(500).
				Thread hilo = new Thread(() -> {
					System.out.println("Hilo: " + Thread.currentThread().getName());
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				});

				// Antes de start(): muestra t.getState() (debería ser NEW).
				System.out.println("Estado antes de start(): " + hilo.getState());

				// Tras start(), imprime getState() y isAlive().
				hilo.start();
				System.out.println("Estado después de start(): " + hilo.getState());
				System.out.println("isAlive?: " + hilo.isAlive());

				// Después de join(), verifica que el estado es TERMINATED y isAlive() == false.
				try {
					hilo.join();
				} catch (InterruptedException e) {
				}
				System.out.println("Estado después de join(): " + hilo.getState());
				System.out.println("isAlive?: " + hilo.isAlive());

			}
			
	}


