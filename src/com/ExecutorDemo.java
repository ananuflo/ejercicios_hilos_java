package com;

import java.util.concurrent.*;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) pool.submit(new Hilo("tarea-" + i));
        pool.shutdown();
        try {
			pool.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("✅ Todas las tareas completadas.");
    }
}
