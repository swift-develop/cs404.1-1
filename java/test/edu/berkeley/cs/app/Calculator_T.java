package edu.berkeley.cs.app;

import org.junit.Assert;
import org.junit.Test;

public class Calculator_T {
  private float epsilon = 0.01f;

  @Test
  public void testSingleValue() {
    Assert.assertEquals(1, Calculator.evaluate("1"), epsilon);
  }

  @Test
  public void testSimpleArithmetic() {
    Assert.assertEquals(2, Calculator.evaluate("1 + 1"), epsilon);
    Assert.assertEquals(-1, Calculator.evaluate("3 - 4"), epsilon);
    Assert.assertEquals(12, Calculator.evaluate("3 * 4"), epsilon);
    Assert.assertEquals(3.75, Calculator.evaluate("15 / 4"), epsilon);
  }

  @Test
  public void testMultiplicationDivisionPrecedence() {
    Assert.assertEquals(14, Calculator.evaluate("2 + 3 * 4"), epsilon);
    Assert.assertEquals(2.66, Calculator.evaluate("2 / 3 * 4"), epsilon);
  }

  @Test
  public void testExponentPrecedence() {
    Assert.assertEquals(32, Calculator.evaluate("2 ^ 3 * 4"), epsilon);
    Assert.assertEquals(-5, Calculator.evaluate("3 - 2 ^ 3"), epsilon);
  }

  @Test(expected = RuntimeException.class)
  public void testMissingOperand() {
    Calculator.evaluate("1 + 2 - ");
  }

  @Test(expected = RuntimeException.class)
  public void testMissingOperator() {
    Calculator.evaluate("1 2");
  }

  @Test
  public void testParenthesis() {
    Assert.assertEquals(-4, Calculator.evaluate("( 2 - 3 ) * 4"), epsilon);
    Assert.assertEquals(-4, Calculator.evaluate("( ( 2 - 3 ) ) * 4"), epsilon);
    Assert.assertEquals(4, Calculator.evaluate("2 * ( 3 - 1 )"), epsilon);
  }

  @Test(expected = RuntimeException.class)
  public void testMismatchedParenthesisLeft() {
    Calculator.evaluate("( ( 3 - 2 ) * 4");
  }

  @Test(expected = RuntimeException.class)
  public void testMismatchedParenthesisRight() {
    Calculator.evaluate("( 3 - 2 ) * 4)");
  }
}
