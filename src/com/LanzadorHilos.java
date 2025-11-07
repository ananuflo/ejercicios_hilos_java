package com;

public class LanzadorHilos {

	private static final Object LOCK = new Object();
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new Hilo("finalizado"));
        t.start();
        try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println(t.getName() + " -> " + t.getState());
    }
}

