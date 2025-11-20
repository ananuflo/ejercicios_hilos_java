package com;

public class Ejercicio {
	
	public static void main (String[]args) {
		
		Runnable ej1 = ()->System.out.println("Hola desde un hilo");
		Thread hilo = new Thread(ej1);
		
	}

}
