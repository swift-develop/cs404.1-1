package edu.berkeley.cs.sort;

import edu.berkeley.cs.util.LinkedList;
import java.util.Arrays;

public class Merge<T extends Comparable> extends Sort<T> {
  protected Insertion<T> insertion = new Insertion<>();

  @Override
  public void sort(T[] input) {
    T[] auxiliary = Arrays.copyOf(input, input.length);
    sort(input, auxiliary, 0, input.length - 1);
  }

  private void merge(T[] input, T[] auxiliary, int low, int mid, int high) {}

  private void sort(T[] input, T[] auxiliary, int low, int high) {}

  private LinkedList<T> merge(LinkedList<T> left, LinkedList<T> right) {
    return null;
  }

  public LinkedList<T> sort(LinkedList<T> input) {
    return null;
  }
}
