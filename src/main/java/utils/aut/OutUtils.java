package utils.aut;

import static reader.IOUtils.printFileFromResourceAsStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;

public class OutUtils {

	public static void print(PrintWriter out, Object o) {
		out.println(o);
	}

	public static void printAr(PrintWriter out, int[] a) {
		for (int value : a) {
			out.print(value);
			out.print(" ");
		}
		out.println();
	}

	public static <E> void printPriorityQueue(PriorityQueue<E> pq) {
		PriorityQueue<E> pq2 = new PriorityQueue<>();
		System.out.println();
		while (!pq.isEmpty()) {
			E x = pq.poll();
			pq2.add(x);
			System.out.print(x.toString() + " ");
		}
		pq.addAll(pq2);
		System.out.println();
	}

	// print input stream
	public static void printInputStream(InputStream is) {

		try (InputStreamReader streamReader =
				new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader reader = new BufferedReader(streamReader)) {

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printWordTest() {
		printFileFromResourceAsStream("ascii_word_test");
	}

	public static void printWordResult() {
		printFileFromResourceAsStream("ascii_word_result");
	}

	public static void printString2dArr(String[][] ar) {
		int i = 0;
		for (String[] arr: ar) {
			printWithColor(Arrays.toString(arr), Color.BLUE_BACKGROUND);
			if (i < ar.length - 1) System.out.print(", ");
			i++;
		}
		System.out.println();
	}

	public static void printWithColor(String val, Color color) {
		System.out.print(color);
		System.out.print(val);
		System.out.print(Color.RESET);
	}
}
