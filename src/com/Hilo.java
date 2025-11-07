package com;

public class Hilo implements Runnable{

	private final String nombre;
	
	
	@Override
	public void run() {

		System.out.println("Iniciando hilo " + nombre + " en " + Thread.currentThread().getName());
		System.out.println("Finalizado hilo: " + nombre);
		
	}
	
	public Hilo(String nombre) {
		this.nombre = nombre;
	}
	
	

}
