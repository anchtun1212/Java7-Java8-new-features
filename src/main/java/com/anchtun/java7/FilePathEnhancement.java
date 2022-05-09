package com.anchtun.java7;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * 
 * Bellow are new interfaces and classes created:
 * java.nio.file.Path
 * java.nio.file.Paths
 * java.nio.file.Files
 * Those new interfaces and classes from package java.nio.file.* can be used to overcome the limitation of
 * java.io.File class
 * nio mean= new I/O
 * for example if you will transfer file with 9 gb so use io package (blocking)
 * for chat application we will have a million of sockets (little text to transfer like: hi, hello...) so use nio (non-blocking)
 * io works more with the streams (with stream you can read the data at this point of time)
 * nio works more with buffers (with buffer you can move back and forward; the data will be buffered in the cache)
 * 
 */
public class FilePathEnhancement {

	public static void main(String[] args) throws IOException {
		final String homeDir = System.getProperty("user.home");
		workingWithPath(homeDir);
		workingWithFiles(homeDir);
	}

	private static void workingWithPath(final String homeDir) {
		Path path = Paths.get(homeDir, "file.txt");
		Path fileName = path.getFileName();
		System.out.println("File name is= " + fileName);
		System.out.println("File system is= " + path.getFileSystem());
		System.out.println("Sub path is= " + path.subpath(0, 2));
		System.out.println("Parent is= " + path.getParent());
		System.out.println("Root is= " + path.getRoot());
		System.out.println("File system separator is= " + path.getFileSystem().getSeparator());
		for (int i = 0; i < path.getNameCount(); i++) {
			Path subPath = path.getName(i);
			System.out.println("Path location at index " + (i + 1) + " is " + subPath);
		}

		// wrong path
		Path wrongPath = Paths.get(homeDir, ".", "file.txt");
		System.out.println("Wrong path is= " + wrongPath);
		Path correctPath = wrongPath.normalize();
		System.out.println("Correct path is= " + correctPath);
		// URI
		URI uri = correctPath.toUri();
		System.out.println("URI path is= " + uri);
		System.out.println("Absolute path is= " + correctPath.toAbsolutePath());

		// partial path
		Path partialPath = Paths.get(homeDir);
		Path combinePath = partialPath.resolve("file.txt");
		System.out.println("Combine path= " + combinePath);
	}

	private static void workingWithFiles(final String homeDir) throws IOException {
		Path path = Paths.get(homeDir, "file.txt");
		byte[] bytes = Files.readAllBytes(path);
		String content = new String(bytes, StandardCharsets.UTF_8);
		System.out.println("\nThe file content is=\n" + content);

		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		for (String line : lines) {
			System.out.println("The content of the line is= " + line);
		}

		// add new line to the file
		String newLine = "New line added by nio library of Java 7";
		Files.write(path, newLine.getBytes(), StandardOpenOption.APPEND);

		// create new folder and new file
		Path newPath = Paths.get(homeDir, "java7");
		Files.createDirectory(newPath);
		Path newFile = Paths.get(homeDir, "java7", "file.txt");
		Files.createFile(newFile);

		// copy file
		Path copyNewFile = Paths.get(homeDir, "java7", "copyFile.txt");
		InputStream is = Files.newInputStream(newFile);
		Files.copy(is, copyNewFile);

		// copy path
		Files.copy(path, copyNewFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

		// delete file
		Files.delete(copyNewFile);
		boolean deleted = Files.deleteIfExists(copyNewFile);
		System.out.println("deleted=" + deleted);
	}
}
