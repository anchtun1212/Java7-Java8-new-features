package com.anchtun.java7;

public class CustomDirtyResource implements AutoCloseable {

	@Override
	public void close() {
		throw new NullPointerException("You get NullPointerException!!!");
	}

	public void readFromResources() {
		throw new RuntimeException("You get RuntimeException, third part issue!!!");
	}
}
