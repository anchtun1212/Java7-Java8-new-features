package com.anchtun.java8.functionalinterface;

@FunctionalInterface
public interface Example3 extends Example1 {

	// valid because same signature of the method inherit from his parent Example1
	@Override
	public void saySalam(String person);

}
