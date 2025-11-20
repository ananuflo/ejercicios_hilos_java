package ejercicios;

public class Ejercicio {

	public static void main(String[] args) {

		// En el main, crea un Thread con una lambda.
				// Dentro de la lambda, usa Thread.currentThread().getName() para mostrar el
				// nombre.
				Runnable ej2 = () -> System.out.println("Ejecutando: " + Thread.currentThread().getName());
				Thread hilo = new Thread(ej2);

				// Antes de start(), llama a setName("Hilo-Usuario").
				hilo.setName("Hilo-Usuario");

				hilo.start();

				// Repite con varios hilos con nombres distintos.
				Thread hilo2 = new Thread(ej2);
				hilo2.setName("Otro-Usuario");
				hilo2.start();
			}		
	}


