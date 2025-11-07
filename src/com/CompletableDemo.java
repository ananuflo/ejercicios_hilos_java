package com;

import java.util.concurrent.*;

public class CompletableDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(4);

        try {
			CompletableFuture.supplyAsync(() -> {
			    System.out.println("Cálculo 1 en " + Thread.currentThread().getName());
			    return 5;
			}, pool)
			.thenApply(x -> x * 2)
			.thenAcceptAsync(resultado ->
			    System.out.println("Resultado final: " + resultado),
			    pool)
			.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

        pool.shutdown();
    }
}
