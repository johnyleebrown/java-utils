package utils.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

	@Test
	void list2dToArr_shouldConvertCorrectly() {
		List<List<List<String>>> l = new ArrayList<>();
		List<List<String>> ll1 = new ArrayList<>();
		ll1.add(Arrays.asList("ab"));
		ll1.add(Arrays.asList("c"));
		l.add(ll1);
		List<List<String>> ll2 = new ArrayList<>();
		ll2.add(Arrays.asList("1"));
		ll2.add(Arrays.asList("23"));
		l.add(ll2);
	}
}