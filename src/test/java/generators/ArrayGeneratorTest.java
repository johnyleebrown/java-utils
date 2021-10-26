package generators;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ArrayGeneratorTest {
  @Test
  public void test() {
    int[] ar = ArrayGenerator.genIntArray(49, 1000, true);
    System.out.println(Arrays.toString(ar));
  }
}