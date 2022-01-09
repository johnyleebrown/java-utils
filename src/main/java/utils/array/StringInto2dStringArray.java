package utils.array;

import static utils.array.ArrayUtils.list2dToArr;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Leetcode string 2d array to an actual array
 * "[["",""],[""],[]]"
 *
 * Backtracking
 */
public class StringInto2dStringArray {

	static StringInto2dStringArray INSTANCE = new StringInto2dStringArray();

	public List<String[][]> run(String source) throws Exception {

		System.out.println(source);

		// start and end check
		if (source.charAt(0) != '[' || source.charAt(source.length() - 1) != ']') {
			throw new Exception();
		}

		List<String[][]> ans = new ArrayList<>();

		int n = source.length(), l = 1, r = n - 1 - 1;
		// for each [] see if it has 1 or more ".."
		// if not - look for next ] and check again

		generateArrayVariants(l, r, source, new ArrayList<>(), ans);

		return ans;
	}

	// ["",""],[""],[]
	// []
	private void generateArrayVariants(int l, int r, String s,
			List<List<List<String>>> cur,
			List<String[][]> ans) {
		if (l >= r) {
			List<String[][]> curAns = list2dToArr(cur);
			//				System.out.println("? listOfStringsResult: " + curAns.size());
			ans.addAll(curAns);
		} else {

			//				System.out.println("? isOpen(s, l): " + isOpen(s, l));

			if (!isOpen(s, l)) return;

			//				System.out.println("===> " + s.substring(l, r+1));

			// runner
			int i = l + 1;

			// try different end brackets
			while (i <= r) {
				boolean validInsides = false;
				List<List<String>> listOfStringsResult = new ArrayList<>();

				// keep looking for next closing until we have a valid insides
				while (!validInsides) {

					// look for next closing
					while (i <= r && !isClosing(s, i)) {
						i++;
					}

					// haven't found
					if (i > r) return;

					// check if we chose the right closing bracket
					// and collect the insides
					validInsides = validateInsides(l + 1, i - 1, s);

					//						System.out.println("? validInsides: "+validInsides);

					if (validInsides) {
						// we have start " and end "
						generateStringArrayVariantsDfs(l + 1, i - 1, s, listOfStringsResult,
								new ArrayList<>());
					}

					// move away from closing bracket, since it was used
					i++;
				}

				// if it's not end
				if (i < r) {
					//						System.out.println("? isComma(s, i): " + isComma(s, i) + ", " + s.charAt(i));
					//						System.out.println("? i,r: " + i+","+r);
					if (!isComma(s, i)) continue;
					else i++;
				}

				// go to next bracket

				//					System.out.println("? cur.add(list: " + listOfStringsResult);

				cur.add(listOfStringsResult);
				generateArrayVariants(i, r, s, cur, ans);
				cur.remove(cur.size() - 1);
			}
		}
	}

	// "ab",""
	// ""
	// "a","b" => a b / a","b
	// "a"","
	// "a",b"
	private void generateStringArrayVariantsDfs(int l, int r, String s,
			List<List<String>> ans, List<String> cur) {
		if (l >= r) {
			//				System.out.println("? StringArrayVariants: " + cur);
			ans.add(new ArrayList<>(cur));
		} else {
			if (!isBracket(s, l)) return;
			int i = l + 1;

			// try different endings
			while (i <= r) {
				// find end
				while (!isStringArrayEnd(i, r, s)) {
					i++;
				}

				// didn't find good end
				if (i > r) return;

				String curString = s.substring(l + 1, i);

				if (i != r) i += 2;

				cur.add(curString);
				generateStringArrayVariantsDfs(i, r, s, ans, cur);
				cur.remove(cur.size() - 1);

				i++;
			}
		}
	}

	// " at the end or ",
	private boolean isStringArrayEnd(int i, int r, String s) {
		return i == r || (i < r && isBracket(s, i) && isComma(s, i + 1));
	}

	// ["",""],[""],[]
	private boolean validateInsides(int l, int r, String s) {
		//			System.out.println(s.substring(l,r+1));
		// []
		if (l == r + 1 && isOpen(s, r) && isClosing(s, l)) {
			return true;
		}
		// ok [""] / ["",""]
		// nok ["]
		if (l < r && isBracket(s, r) && isBracket(s, l)) {
			return true;
		}
		return false;
	}

	private boolean isComma(String s, int ind) {
		return s.charAt(ind) == ',';
	}

	private boolean isBracket(String s, int ind) {
		return s.charAt(ind) == '"';
	}

	private boolean isOpen(String s, int ind) {
		return s.charAt(ind) == '[';
	}

	private boolean isClosing(String s, int ind) {
		return s.charAt(ind) == ']';
	}
}
