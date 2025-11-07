package com;
import java.util.*;

public class SimuladorHilos {


		public static void nHilos(int n) {
			
			List<Thread> lista = new ArrayList<>();
			
			//Creamos los hilos
			for(int i = 1; i <= n; i++) {
				Thread t = new Thread(new Hilo("Hilo " + i));
				lista.add(t);
				
			}
			
			// Mezclar orden de ejecución
	        Collections.shuffle(lista);

	        // Ejecutar aleatoriamente
	        for (Thread t : lista) {
	            t.start();
	            try {
	                Thread.sleep((int)(Math.random() * 300));
	            } catch (InterruptedException e) {}
	        }

	        // Esperar a que terminen todos
	        for (Thread t : lista) {
	            try { t.join(); } catch (InterruptedException ignored) {}
	        }

	        System.out.println("\n✅ Todos los hilos han terminado su ejecución.");
	    }

	    public static void main(String[] args) {
	        nHilos(5);
	    }
}
			

	
