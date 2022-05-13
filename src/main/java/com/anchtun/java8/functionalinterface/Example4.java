package com.anchtun.java8.functionalinterface;

@FunctionalInterface
public interface Example4 extends Example1 {

	// compile error because the signature of this method is different than the signature of the method exists in his parent Example1
	// so this interface contains two Abstract methods so its not @FunctionalInterface
	//public void saySalamAlaykom(String person);
}
