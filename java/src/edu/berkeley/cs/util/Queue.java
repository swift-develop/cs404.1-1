package edu.berkeley.cs.util;

class Queue<T> {
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
}
