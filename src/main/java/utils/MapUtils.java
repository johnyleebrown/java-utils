package utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MapUtils {

	public static String toString(Map<Integer, Integer> map) {
		StringBuilder sb = new StringBuilder();
		for (int k : map.keySet()) {
			sb.append("{").append(k).append(", ").append(map.get(k)).append("}, ");
		}
		return sb.toString();
	}

	public static void printGraph(Map<Integer, Collection<Integer>> g) {
		for (int k : g.keySet()) {
			System.out.print(String.format("[%s]\n> ", k));
			int count = g.get(k).size();
			for (int child : g.get(k)) {
				if (--count == 0) System.out.print(child);
				else System.out.print(child + ", ");
			}
			System.out.println();
		}
	}
}