package com;

public class LanzadorHilosNew {

	private static final Object LOCK = new Object();
	
	public static void main(String[] args) {

		Thread t = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " esperando...");
                    LOCK.wait();
                } catch (InterruptedException ignored) {}
            }
        }, "tWaiting");
		
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName() + " ---> " + t.getState());
		
	}

}
