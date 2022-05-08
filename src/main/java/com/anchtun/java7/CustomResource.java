package com.anchtun.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Resource was closed");
	}

	public void readFromResources(String file) throws IOException {
		System.out.println("Read from resource");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
