package utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
    public static class NanoSeconds {
        public static double toMilli(long x) {
            return TimeUnit.MILLISECONDS.convert(x, TimeUnit.NANOSECONDS);
        }
    }

    public static class Timer {
        private long startTime, endTime;

        public Timer start() {
            startTime = System.nanoTime();
            return this;
        }

        public void printEnd() {
            System.out.println(String.format("%.2f", this.end().getTotal()));
        }

        public Timer end() {
            endTime = System.nanoTime();
            return this;
        }

        public double getTotal() {
            return (endTime - startTime) / 1e6;
        }

        public void printResult() {
            System.out.println("Total execution time is: " + NanoSeconds.toMilli((endTime - startTime)) + " ms");
        }
    }

}
