/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
  @Test
  public void testZeros() {
    assertEquals(0, App.zeros(0));
    assertEquals(1, App.zeros(6));
    assertEquals(2, App.zeros(14));
    assertEquals(249, App.zeros(1000));
  }
}
