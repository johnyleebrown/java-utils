package utils;

import java.util.Map;

public class MapUtils {

  public static String toString(Map<Integer, Integer> map) {
    StringBuilder sb = new StringBuilder();
    for (int k : map.keySet()) {
      sb.append("{").append(k).append(", ").append(map.get(k)).append("}, ");
    }
    return sb.toString();
  }
}