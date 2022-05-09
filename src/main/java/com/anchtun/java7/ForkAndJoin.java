package com.anchtun.java7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * In fact Java 8's parallel streams underline uses the ForkJoin framework
 */
public class ForkAndJoin extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	private static final long threshold = 2;
	private volatile long number;

	public ForkAndJoin(long number) {
		this.number = number;
	}

	@Override
	protected void compute() {
		long n = number;
		if (n <= threshold) {
			number = fib(n);
		} else {
			ForkAndJoin f1 = new ForkAndJoin(n - 1);
			ForkAndJoin f2 = new ForkAndJoin(n - 2);
			ForkAndJoin.invokeAll(f1, f2);
			number = f1.number + f2.number;
		}
	}

	private static long fib(long n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public long getNumber() {
		return number;
	}

	public static void main(String[] args) {
		ForkAndJoin task = new ForkAndJoin(22);
		new ForkJoinPool().invoke(task);
		System.out.println(task.getNumber());
	}
}
