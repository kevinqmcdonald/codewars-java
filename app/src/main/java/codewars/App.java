/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

public class App {
  static int find(int[] integers) {
    // Check the optimal case
    int first = integers[0];
    int second = integers[1];
    if(!isSameParity(first, second)) {
      return isSameParity(first, integers[2]) ? second : first;
    }

    // iterate until we find the different one
    boolean isOdds = first % 2 == 1;
    for(int i = 2; i < integers.length; ++i) {
      if((isOdds && Math.abs(integers[i] % 2) == 0) || (!isOdds && Math.abs(integers[i] % 2) == 1)) {
        return integers[i];
      }
    }

    throw new IllegalArgumentException("array doesn't contain an outlier");
  }

  static boolean isSameParity(int i, int j) {
    return Math.abs(i % 2) == Math.abs(j % 2);
  }
}
