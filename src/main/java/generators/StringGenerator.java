package generators;

import java.util.Random;

public class StringGenerator {
	public static String createRandomReadableString(int size) {
		return createRandomReadableStringBuilder(size).toString();
	}

	public static StringBuilder createRandomReadableStringBuilder(int size) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			// adding 33 cuz first 33 are not visible
			sb.append((char) (r.nextInt(255 - 33) + 33));
		}
		return sb;
	}
}
