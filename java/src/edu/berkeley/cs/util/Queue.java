package edu.berkeley.cs.util;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
  private LinkedList<T> list;

  public Queue() {
    list = new LinkedList<>();
  }

  public Queue(LinkedList<T> list) {
    this.list = list;
  }

  public T peek() {
    return list.front();
  }

  public void enqueue(T value) {
    list.insertEnd(value);
  }

  public T dequeue() {
    return list.removeFront();
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }
}
