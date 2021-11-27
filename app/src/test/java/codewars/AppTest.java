/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AppTest {
  int[] input = new int[]{-1,-2,-3,-4,-5,-6,-7,-8,-9,-1};
  int[] output = new int[]{-9,-1};
  @Test
  public void allNegatives() {
    assertArrayEquals(output, App.findLargestAndSmallest(input));
  }

  int[] input2 = new int[]{1,-2,3,-4,-5,-6,-7,-8,-9};
  int[] output2 = new int[]{-9,3};
  @Test
  public void test2() {
    assertArrayEquals(output2, App.findLargestAndSmallest(input2));
  }

  int[] input123 = new int[]{1,2,3};
  int[] output123 = new int[]{1,3};
  @Test
  public void test21() {
    assertArrayEquals(output123, App.findLargestAndSmallest(input123));
  }

  int[] input3 = new int[]{4};
  int[] output3 = new int[]{4,4};

  @Test
  public void oneItem() {
    assertArrayEquals(output3, App.findLargestAndSmallest(input3));
  }

  int[] input4 = new int[]{9,-1};
  int[] output4 = new int[]{-1,9};

  @Test
  public void twoItems() {
    assertArrayEquals(output4, App.findLargestAndSmallest(input4));
  }

  int[] input5 = new int[]{};
  int[] output5 = null;

  @Test
  public void emptyArray() {
    assertArrayEquals(output5, App.findLargestAndSmallest(input5));
  }

  int[] input6 = null;
  int[] output6 = null;

  @Test
  public void nullInput() {
    assertArrayEquals(output6, App.findLargestAndSmallest(input6));
  }
}
