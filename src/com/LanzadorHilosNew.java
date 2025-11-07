package com;

public class LanzadorHilosNew {

	public static void main(String[] args) {

		Thread h = new Thread(new Hilo("runnable"));
		h.start();
		
		try {
			
			Thread.sleep(50);
			System.out.println(h.getName() + " ---> " + h.getState());

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
