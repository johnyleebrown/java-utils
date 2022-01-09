package generators;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayGenerator {

	public static int[] genIntArray(int n, int randomBoundary, boolean canRepeat) {
		final Random r = new Random();
		Set<Integer> set = new HashSet<>();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			int x = r.nextInt(randomBoundary);
			if (!canRepeat) {
				while (!set.add(x)) {
					x = r.nextInt(randomBoundary);
				}
			}
			a[i] = x;
		}
		return a;
	}

	public static int[][] genIntArray2d(int n, int m, int randBoundary) {
		Random r = new Random();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = r.nextInt(randBoundary);
			}
		}
		System.out.println("[done] - generation");
		return a;
	}

	@SuppressWarnings({"unchecked"})
	public static <T> T[] genArray(int n, int randomBoundary) {
		final Random r = new Random();
		Set<T> set = new HashSet<>();
		T[] a = (T[]) new Object[n];
		for (int i = 0; i < n; i++) {
			T x = getTFromInt(r, randomBoundary);
			while (!set.add(x)) {
				x = getTFromInt(r, randomBoundary);
			}
			a[i] = x;
		}
		return a;
	}

	@SuppressWarnings({"unchecked"})
	private static <T> T getTFromInt(Random r, int randomBoundary) {
		return (T) new Integer(r.nextInt(randomBoundary));
	}
}
