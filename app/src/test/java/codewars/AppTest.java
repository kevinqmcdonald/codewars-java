/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
  @Test
  public void testEmptyArray() {
    assertEquals(0, App.sequence(new int[]{}), "Empty arrays should have a max of 0");
  }
  @Test
  public void testExampleArray() {
    assertEquals(6, App.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), //
      "Example array should have a max of 6");
  }
  @Test
  public void testExampleArray2() {
    assertEquals(7, App.sequence(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}), //
      "Example array should have a max of 7");
  }
  @Test
  public void testAllNegatives() {
    assertEquals(0, App.sequence(new int[]{-2, -3, -4, -1, -2}), //
      "All negative array should have max of 0");
  }
  @Test
  public void testAllPositives() {
    assertEquals(12, App.sequence(new int[]{2, 3, 4, 1, 2}), //
      "All positive array should have max of sum of all elements");
  }
}
