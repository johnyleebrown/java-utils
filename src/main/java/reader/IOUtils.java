package reader;

import static utils.aut.OutUtils.printInputStream;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOUtils {
	public static BufferedReader createReader(String path, String name) throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(path + name)));
	}

	public static BufferedReader createReader(String name) throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(name)));
	}

	public static BufferedWriter createWriter(String path, String name) throws FileNotFoundException {
		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + name)));
	}

	public static BufferedWriter createWriter(String name) throws FileNotFoundException {
		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name)));
	}

	public static void removeFile(String path, String name) {
		if (!new File(path + name).delete()) {
			throw new RuntimeException("COULDN'T REMOVE FILE.");
		}
	}

	public static void removeFile(String name) {
		if (!new File(name).delete()) {
			throw new RuntimeException("COULDN'T REMOVE FILE.");
		}
	}

	/**
	 * Gets input readers for files from resources folder for a class.
	 * Tested only for test classes.
	 */
	public static List<InputReader> getFolderFilesReaders(Class c) {
		List<String> fileNames = getFileNames(c);
		return fileNames.stream().map(name -> getFileReader(c, name)).collect(Collectors.toList());
	}

	public static InputReader getFolderFileReader(Class c) {
		List<String> fileNames = getFileNames(c);
		return fileNames.stream().map(name -> getFileReader(c, name)).collect(Collectors.toList()).get(0);
	}

	private static InputReader getFileReader(Class c, String fileName) {
		ClassLoader classLoader = c.getClassLoader();
		String pathToFolder = c.getName().replace('.', '/');
		String pathToFile = pathToFolder + "/" + fileName;
		InputStream inputStream = classLoader.getResourceAsStream(pathToFile);
		return new InputReader(inputStream);
	}

	private static List<String> getFileNames(Class c) {
		ClassLoader classLoader = c.getClassLoader();
		String pathToFolder = c.getName().replace('.', '/');
		String pathToFolderFull = "./" + pathToFolder;
		URL folder = classLoader.getResource(pathToFolderFull);
		assert folder != null;
		File f = null;
		try {
			f = new File(folder.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		File[] files = f.listFiles();
		if (files.length == 0) {
			throw new RuntimeException("No files were found..");
		}
		return Arrays.stream(files).map(File::getName).collect(Collectors.toList());
	}

	public static InputStream getFileFromResourceAsStream(String fileName) {

		// The class loader that loaded the class
		ClassLoader classLoader = IOUtils.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		// the stream holding the file content
		if (inputStream == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {
			return inputStream;
		}
	}

	public static void printFileFromResourceAsStream(String fileName) {
		printInputStream(getFileFromResourceAsStream(fileName));
	}
}
