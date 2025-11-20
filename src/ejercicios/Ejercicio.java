package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {
		
		// En el hilo, usa un bucle while (!Thread.currentThread().isInterrupted()).
				Thread t = new Thread(() -> {
					int contador = 0;

					// Dentro del bucle, imprime un contador y haz sleep(500).
					try {
						while (!Thread.currentThread().isInterrupted()) {
							contador++;
							System.out.println("Contador: " + contador);
							Thread.sleep(500);
						}
						// Maneja InterruptedException terminando el hilo con un mensaje claro.
					} catch (InterruptedException e) {
						System.out.println("Se interrumpió el hilo :(");
					}
					System.out.println("El hilo finalizó");
				});

				// En el main, tras start(), espera con sleep(2000) y luego llama a
				// t.interrupt().
				t.start();
				try {
					Thread.sleep(2000);
					t.interrupt();
				} catch (InterruptedException e) {
				}
			}
			
	}


