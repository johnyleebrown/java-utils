package validation;

public class ArrayValidation {
	public static void isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i - 1])
				throw new RuntimeException("ERROR");
	}
}
