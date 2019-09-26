package edu.berkeley.cs.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SplayList_T {
  private SplayList<Integer> list;

  @Before
  public void setup() {
    list = new SplayList<>();
  }

  @Test
  public void testBackNoMove() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertEquals(new Integer(1), list.back());
    Assert.assertEquals(new Integer(0), list.front());
  }

  @Test
  public void sizeNoMove() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertEquals(2, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(1), list.back());
  }

  @Test
  public void isEmptyNoMove() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertFalse(list.isEmpty());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(1), list.back());
  }

  @Test
  public void testContainsEmptyList() {
    Assert.assertTrue(list.isEmpty());
  }

  @Test
  public void testContainsMoveToFrontSingleNode() {
    list.insertEnd(0);

    Assert.assertTrue(list.contains(0));
    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(0), list.back());
  }

  @Test
  public void testContainsMoveToFrontFirstNode() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertTrue(list.contains(0));
    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(1), list.back());

    Assert.assertTrue(list.contains(0));
    Assert.assertTrue(list.contains(1));
  }

  @Test
  public void testContainsMoveToFrontLastNode() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertTrue(list.contains(1));
    Assert.assertEquals(new Integer(1), list.front());
    Assert.assertEquals(new Integer(0), list.back());

    Assert.assertTrue(list.contains(0));
    Assert.assertTrue(list.contains(1));
  }

  @Test
  public void testContainsMoveToFrontMiddleNode() {
    list.insertEnd(0);
    list.insertEnd(1);
    list.insertEnd(2);

    Assert.assertTrue(list.contains(1));
    Assert.assertEquals(new Integer(1), list.front());
    Assert.assertEquals(new Integer(2), list.back());

    Assert.assertTrue(list.contains(0));
    Assert.assertTrue(list.contains(1));
    Assert.assertTrue(list.contains(2));
  }
}
