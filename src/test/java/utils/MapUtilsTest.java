package utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapUtilsTest {

  @Test
  public void testPrintGraph() {
    Map<Integer, Collection<Integer>> g = new HashMap<>();
    g.put(0, Arrays.asList(1, 2, 3));
    g.put(1, Arrays.asList(2));
    g.put(2, Arrays.asList(4, 5));
    MapUtils.printGraph(g);
  }
}