package com;

public class LanzadorHilosNew {

	private static final Object LOCK = new Object();
	
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
            }
        }, "t1");
		
		Thread t2 = new Thread(() -> {
	           synchronized (LOCK) {
	               System.out.println("Bloqueado: " + Thread.currentThread().getName());
	            }
	        }, "t2");
		
		t1.start();
        try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        t2.start();
        try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(t2.getName() + " -> " + t2.getState());
		
	}

}
