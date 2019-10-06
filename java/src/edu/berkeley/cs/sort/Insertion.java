package edu.berkeley.cs.sort;

public class Insertion<T extends Comparable> extends Sort<T> {
  @Override
  public void sort(T[] input) {
    sort(input, 0, input.length - 1);
  }

  public void sort(T[] input, int low, int high) {}
}
