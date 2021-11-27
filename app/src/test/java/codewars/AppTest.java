/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  public void test1() {
    String pangram1 = "The quick brown fox jumps over the lazy dog.";
    App app = new App();
    assertTrue(app.check(pangram1));
  }
  @Test
  public void test2() {
    String pangram2 = "You shall not pass!";
    App app = new App();
    assertFalse(app.check(pangram2));
  }
  @Test
  public void testAllPunctuation() {
    String pangram2 = "!!!!";
    App app = new App();
    assertFalse(app.check(pangram2));
  }
  @Test
  public void testEmptyString() {
    String pangram2 = "";
    App app = new App();
    assertFalse(app.check(pangram2));
  }
  @Test
  public void testWithNumbers() {
    String pangram2 = "The quick brown fox123 jumps over the lazy dog.";
    App app = new App();
    assertTrue(app.check(pangram2));
  }
  @Test
  public void testAllNumbers() {
    String pangram2 = "12345";
    App app = new App();
    assertFalse(app.check(pangram2));
  }
}
