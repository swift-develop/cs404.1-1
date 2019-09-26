package edu.berkeley.cs.util;

public class Stack<T> {
  private LinkedList<T> list;

  public Stack() {
    list = new LinkedList<>();
  }

  public Stack(LinkedList<T> list) {
    this.list = list;
  }

  public T peek() {
    return list.front();
  }

  public void push(T value) {
    list.insertFront(value);
  }

  public T pop() {
    return list.removeFront();
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
