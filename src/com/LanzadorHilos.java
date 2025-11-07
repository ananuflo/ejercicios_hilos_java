package com;

public class LanzadorHilos {

	private static final Object LOCK = new Object();
	
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			
            try {
                // El hilo se bloquea en TIMED_WAITING durante 2 s.
                Thread.sleep(2000);
            } catch (InterruptedException ignored) { }
        }, "tiempo");

        t.start();                     // h comienza a ejecutarse
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}              // le damos tiempo para entrar en sleep
        //Thread.sleep(10);  // Muy poco tiempo, muy probable que todavía esté en sleep
        System.out.println(t.getName() + " -> " + t.getState()); // TIMED_WAITING o RUNNABLE según el timing
    }


}

