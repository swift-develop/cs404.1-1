package edu.berkeley.cs.util;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
  static class ListNode<T> {
    ListNode<T> prev;
    ListNode<T> next;
    T value;

    ListNode(T value) {
      this.value = value;
    }
  }

  protected ListNode<T> head;
  protected ListNode<T> tail;
  private int size = 0;

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      ListNode<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public ListNode<T> next() {
        ListNode<T> prev = current;
        current = current.next;
        return prev;
      }
    };
  }

  public void insertFront(T value) {}

  public void insertEnd(T value) {}

  public T removeFront() {
    return null;
  }

  public T removeEnd() {
    return null;
  }

  public boolean remove(T value) {
    return false;
  }

  public T front() {
    return null;
  }

  public T back() {
    return null;
  }

  public boolean contains(T value) {
    return false;
  }

  public int size() {
    return 0;
  }

  public boolean isEmpty() {
    return false;
  }
}
