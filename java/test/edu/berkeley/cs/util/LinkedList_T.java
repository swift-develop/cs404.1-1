package edu.berkeley.cs.util;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedList_T {
  private LinkedList<Integer> list;

  @Before
  public void setup() {
    list = new LinkedList<>();
  }

  @Test
  public void testIsEmpty() {
    Assert.assertTrue(list.isEmpty());
    list.insertFront(0);
    Assert.assertFalse(list.isEmpty());
  }

  @Test
  public void testEmptyList() {
    Assert.assertEquals(0, list.size());

    Assert.assertNull(list.front());
    Assert.assertNull(list.back());

    Assert.assertNull(list.removeFront());
    Assert.assertNull(list.removeEnd());
  }

  @Test
  public void testInsertFront() {
    list.insertFront(0);
    list.insertFront(1);

    Assert.assertEquals(2, list.size());

    Assert.assertEquals(new Integer(1), list.front());
    Assert.assertEquals(new Integer(0), list.back());

    list.insertFront(2);
    Assert.assertEquals(3, list.size());

    Assert.assertEquals(new Integer(2), list.front());
    Assert.assertEquals(new Integer(0), list.back());
  }

  @Test
  public void testInsertEnd() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertEquals(2, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(1), list.back());

    list.insertEnd(2);
    Assert.assertEquals(3, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(2), list.back());
  }

  @Test
  public void testRemoveFront() {
    Assert.assertNull(list.removeFront());

    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertEquals(new Integer(0), list.removeFront());
    Assert.assertEquals(1, list.size());
    Assert.assertEquals(new Integer(1), list.front());

    Assert.assertEquals(new Integer(1), list.removeFront());
    Assert.assertEquals(0, list.size());
    Assert.assertNull(list.front());
  }

  @Test
  public void testRemoveEnd() {
    Assert.assertNull(list.removeEnd());

    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertEquals(new Integer(1), list.removeEnd());
    Assert.assertEquals(1, list.size());
    Assert.assertEquals(new Integer(0), list.front());

    Assert.assertEquals(new Integer(0), list.removeEnd());
    Assert.assertEquals(0, list.size());
    Assert.assertNull(list.front());
  }

  @Test
  public void testRemoveNotFound() {
    list.insertEnd(0);

    Assert.assertFalse(list.remove(1));
    Assert.assertEquals(1, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(0), list.back());
  }

  @Test
  public void testRemoveOnlyElement() {
    list.insertEnd(0);

    Assert.assertTrue(list.remove(0));
    Assert.assertEquals(0, list.size());

    Assert.assertNull(list.front());
    Assert.assertNull(list.back());
  }

  @Test
  public void testRemoveFirstElement() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertTrue(list.remove(0));
    Assert.assertEquals(1, list.size());

    Assert.assertEquals(new Integer(1), list.front());
    Assert.assertEquals(new Integer(1), list.back());
  }

  @Test
  public void testRemoveLastElement() {
    list.insertEnd(0);
    list.insertEnd(1);

    Assert.assertTrue(list.remove(1));
    Assert.assertEquals(1, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(0), list.back());
  }

  @Test
  public void testRemoveMiddleElement() {
    list.insertEnd(0);
    list.insertEnd(1);
    list.insertEnd(2);

    Assert.assertTrue(list.remove(1));
    Assert.assertEquals(2, list.size());

    Assert.assertEquals(new Integer(0), list.front());
    Assert.assertEquals(new Integer(2), list.back());
  }

  @Test
  public void testContains() {
    int size = 10;

    Assert.assertEquals(0, list.size());
    for (int i = 0; i < size; i++) {
      list.insertEnd(i);
    }
    Assert.assertEquals(size, list.size());

    Assert.assertFalse(list.contains(size + 1));
    for (int i = 0; i < size; i++) {
      Assert.assertTrue(list.contains(i));
    }
  }

  @Test
  public void testIterator() {
    list.insertEnd(0);
    list.insertEnd(1);
    list.insertEnd(2);

    Iterator<Integer> iterator = list.iterator();
    for (int i = 0; i < list.size(); i++) {
      Assert.assertTrue(iterator.hasNext());
      Assert.assertEquals(new Integer(i), iterator.next());
    }

    Assert.assertFalse(iterator.hasNext());
  }
}
