package com.anchtun.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture to process tasks asynchronously
 */
public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		runAsync();
		supplyAsync();
		thenApply();
		thenAccept();
		System.out.println("Main thread");
	}

	private static void runAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> async = CompletableFuture.runAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Running in a separate thread than the main thread");
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		});
		System.out.println("runAsync bocking 1");
		async.get();
		System.out.println("runAsync bocking 2");
	}

	private static void supplyAsync() throws InterruptedException, ExecutionException {
		CompletableFuture<String> async = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Anchtun ok!";
		});
		System.out.println("supplyAsync bocking 1");
		String result = async.get();
		System.out.println("result= " + result);
		System.out.println("supplyAsync bocking 2");
	}

	private static void thenApply() throws InterruptedException, ExecutionException {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Mohamed";
		});

		System.out.println("ThenApply middle block");

		CompletableFuture<String> finalFuture = future.thenApply(name -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return name + " Aymen";
		});

		System.out.println("thenApply bocking 1");
		String result = finalFuture.get();
		System.out.println("result= " + result);
		System.out.println("thenApply bocking 2");
	}

	private static void thenAccept() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Aymen";
		}).thenAccept(name -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("Received the value " + name);
		});
		System.out.println("thenAccept non-bocking");
		future.get();
	}
}
