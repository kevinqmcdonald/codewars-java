/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import java.util.*;

public class App {
  public static int sumIntervals(int[][] intervals) {
    if (intervals == null) return 0;

    List<IntervalStruct> disjointIntervals = new ArrayList<>();
    for (int[] ints : intervals) {
      IntervalStruct interval = new IntervalStruct(ints[0], ints[1]);

      // First interval doesn't require combining
      if (disjointIntervals.isEmpty()) {
        disjointIntervals.add(interval);
        continue;
      }

      // Add next interval and combine overlaps repeatedly
      disjointIntervals.add(interval);
      if(containsOverlappingIntervals(disjointIntervals)) {
        do {
          combineIntervals(disjointIntervals);
        } while (containsOverlappingIntervals(disjointIntervals));
      }
    }

    // Sum the disjoint interval lengths
    return disjointIntervals
      .stream()
      .reduce(
        0,
        (lengthSubtotal, interval) -> lengthSubtotal + interval.length(),
        Integer::sum
      );
  }

  private static boolean containsOverlappingIntervals(List<IntervalStruct> intervals) {
    // Sort by IntervalStruct.to
    intervals.sort(Comparator.comparingInt(i -> i.to));

    // Starting with the first interval, check if each consecutive
    // interval overlaps with the next
    int to = intervals.get(0).to;
    for (int i = 1; i < intervals.size(); ++i) {
      int from = intervals.get(i).from;

      if(to > from) return true;
      else to = intervals.get(i).to;
    }

    return false;
  }

  private static void combineIntervals(List<IntervalStruct> intervals) {
    // Combine the first encountered overlapping intervals
    IntervalStruct int1 = intervals.get(0);
    for (int i = 1; i < intervals.size(); ++i) {
      IntervalStruct int2 = intervals.get(i);
      if(int1.to > int2.from) {
        int from = Math.min(int1.from, int2.from);
        int to = Math.max(int1.to, int2.to);
        intervals.set(i, new IntervalStruct(from, to));
        intervals.remove(int1);
        return;
      } else {
        int1 = intervals.get(i);
      }
    }
  }

  private static class IntervalStruct {
    private final int from;
    private final int to;

    public IntervalStruct(int from, int to) {
      this.from = from;
      this.to = to;
    }

    public int length() {
      return to - from;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      IntervalStruct interval = (IntervalStruct) o;
      return from == interval.from && to == interval.to;
    }

    @Override
    public int hashCode() {
      return Objects.hash(from, to);
    }
  }
}
