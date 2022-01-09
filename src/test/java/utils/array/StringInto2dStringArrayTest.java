package utils.array;

import static utils.aut.OutUtils.printString2dArr;
import static utils.aut.OutUtils.printWordResult;
import static utils.aut.OutUtils.printWordTest;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringInto2dStringArrayTest {

	@Test
	void StrToStr2dArr_shouldReturnCorrectAnswer_whenInputIsCorrect2dArray()
			throws Exception {

		printWordTest();

		String test1 = "[[\"a\"\"]\",\"b\"],[\"2\"]]";
		String test2 = "[[\"a\"\"],[\",\"b\"],[\"2\"]]";
		String test3 = "[[\"a\"\"],,[[[[\",\"b\"],[\"2\"]]";
		String test4 = "[[\"a\"\"\",\",\"b\"],[\"2\"]]";
		String test5 = "[[\"a\",\"b\"],[\"1\",\"2\",\"3\"],[\"hello\", \"1\"]]";
		String test6 = "[[\"a\"\"\",\",\"b\"],[\"2\"]]";
		String test7 = "[[],[\"\"\"]]";
		List<String[][]> actualResult = StringInto2dStringArray.INSTANCE.run(test5);

		printWordResult();

		for (String[][] strings : actualResult) {
			printString2dArr(strings);
		}
	}

}