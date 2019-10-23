package edu.berkeley.cs.util;

import java.util.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Queue_T {
  private Queue<Integer> queue;

  @Before
  public void setup() {
    queue = new Queue<>();
  }

  @Test
  public void testEnqueuePeek() {
    queue.enqueue(0);
    Assert.assertEquals(new Integer(0), queue.peek());

    queue.enqueue(1);
    Assert.assertEquals(new Integer(0), queue.peek());

    queue.dequeue();
    Assert.assertEquals(new Integer(1), queue.peek());
  }

  @Test
  public void testDequeue() {
    queue.enqueue(0);
    queue.enqueue(1);
    queue.enqueue(2);

    Assert.assertEquals(3, queue.size());
    Assert.assertEquals(new Integer(0), queue.dequeue());
    Assert.assertEquals(new Integer(1), queue.dequeue());
    Assert.assertEquals(new Integer(2), queue.dequeue());
  }

  @Test
  public void testIsEmpty() {
    Assert.assertTrue(queue.isEmpty());
    queue.enqueue(0);
    Assert.assertFalse(queue.isEmpty());
    queue.dequeue();
    Assert.assertTrue(queue.isEmpty());
  }

  @Test
  public void testSize() {
    Assert.assertEquals(0, queue.size());
    queue.enqueue(0);
    Assert.assertEquals(1, queue.size());
    queue.dequeue();
    Assert.assertEquals(0, queue.size());
  }

  @Test
  public void testIterator() {
    queue.enqueue(0);
    queue.enqueue(1);
    queue.enqueue(2);

    Iterator<Integer> iterator = queue.iterator();
    for (int i = 0; i < queue.size(); i++) {
      Assert.assertTrue(iterator.hasNext());
      Assert.assertEquals(new Integer(i), iterator.next());
    }

    Assert.assertFalse(iterator.hasNext());
  }
}
