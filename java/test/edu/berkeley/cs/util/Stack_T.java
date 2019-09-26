package edu.berkeley.cs.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Stack_T {
  private Stack<Integer> stack;

  @Before
  public void setup() {
    stack = new Stack<>();
  }

  @Test
  public void testPushPeek() {
    stack.push(0);
    Assert.assertEquals(new Integer(0), stack.peek());

    stack.push(1);
    Assert.assertEquals(new Integer(1), stack.peek());

    stack.push(2);
    Assert.assertEquals(new Integer(2), stack.peek());
  }

  @Test
  public void testPop() {
    stack.push(0);
    stack.push(1);
    stack.push(2);

    Assert.assertEquals(3, stack.size());
    Assert.assertEquals(new Integer(2), stack.pop());
    Assert.assertEquals(new Integer(1), stack.pop());
    Assert.assertEquals(new Integer(0), stack.pop());
  }

  @Test
  public void testIsEmpty() {
    Assert.assertTrue(stack.isEmpty());
    stack.push(0);
    Assert.assertFalse(stack.isEmpty());
    stack.pop();
    Assert.assertTrue(stack.isEmpty());
  }

  @Test
  public void testSize() {
    Assert.assertEquals(0, stack.size());
    stack.push(0);
    Assert.assertEquals(1, stack.size());
    stack.pop();
    Assert.assertEquals(0, stack.size());
  }
}
