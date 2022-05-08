package com.anchtun.java7;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class CloseMethodURLClassLoader {

	public static void main(String[] args) throws IOException {
		URL[] url = { new URL("https://github.com/anchtun1212") };
		// the close method will be called automatically by the JVM
		try (URLClassLoader loader = new URLClassLoader(url)) {
			// business logic
		}
	}
}
