package utils.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayUtils {

	private static final String WRONG_INPUT = "Wrong input";

	/**
	 * Get new index after jump in circular array.
	 */
	public static int getNewIndexCircularArray(int curInd, int jump, int arLen) {
		if (jump < 0) {
			// n=7 i=2 j=-13
			// 1 way
			int x = (curInd + jump) % arLen;
			if (x < 0) x += arLen;
			return x;
      /*
         2 way
         return (((curInd + jump) % arLen) + arLen) % arLen;
         */
		} else {
			// n=7 i=2 j=13
			return (curInd + jump) % arLen;
		}
	}

	/**
	 * Convert Leetcode string to 2d int array
	 * "[[1,2,3],[1]]"
	 */
	public static int[][] convertStringToInt2dArray(String source) {
		String[] ar = source.substring(1, source.length() - 1).split("]");
		int[][] ans = new int[ar.length][];
		int i = 0;
		for (String s : ar) {
			String[] nums = s.split("[^0-9]");
			List<Integer> loc = new LinkedList<>();
			for (String n : nums) {
				if (!n.trim().isEmpty()) {
					loc.add(Integer.parseInt(n));
				}
			}
			int[] a = new int[loc.size()];
			int k = 0;
			for (int j : loc) {
				a[k++] = j;
			}
			ans[i++] = a;
		}
		return ans;
	}

	public static List<String[][]> list2dToArr2(List<List<List<String>>> cur) {
		List<String[][]> ans = new ArrayList<>();
		for (List<List<String>> l : cur) {
			String[][] ar = new String[l.size()][];
			int i = 0;
			for (List<String> ll : l) {
				ar[i++] = ll.toArray(new String[ll.size()]);
			}
			ans.add(ar);
		}
		return ans;
	}

	public static String[][] list2dToArr3(List<List<String>> l) {
		String[][] ar = new String[l.size()][];
		int i = 0;
		for (List<String> ll : l) {
			ar[i++] = ll.toArray(new String[ll.size()]);
		}
		return ar;
	}

	public static List<String[][]> list2dToArr(List<List<List<String>>> l) {
		List<List<List<String>>> ans = new ArrayList<>();
		gen(l, new ArrayList<>(), ans, 0);
		return list2dToArr2(ans);
	}

	private static void gen(List<List<List<String>>> l, List<List<String>> cur, List<List<List<String>>> ans, int i) {
		if (i >= l.size()) {
			ans.add(new ArrayList<>(cur));
		} else {
			for (int j = 0; j < l.get(i).size(); j++) {
				cur.add(l.get(i).get(j));
				gen(l, cur, ans, i + 1);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void exch(int[] a, int j, int i) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
