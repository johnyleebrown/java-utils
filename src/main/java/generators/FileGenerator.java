package generators;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

import static reader.IOUtils.createWriter;

public class FileGenerator {
	/**
	 * @param n     number of items to generate
	 * @param bound max number
	 */
	public static void generateFileWithNumbers(int n, int bound, String fileName) throws IOException {
		Random r = new Random();
		BufferedWriter w = createWriter(fileName);
		for (int j = 0; j < n; j++) {
			int num = r.nextInt(bound);
			w.write(String.valueOf(num));
			w.newLine();
		}
		w.close();
	}
}
