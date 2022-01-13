package reader;

import java.util.List;
import org.junit.jupiter.api.Test;

class IOUtilsTest {

	@Test
	void test1() throws Exception {
		List<InputReader> inputReaders = IOUtils.getFolderFilesReaders(getClass());
		System.out.println(inputReaders.size());
	}
}