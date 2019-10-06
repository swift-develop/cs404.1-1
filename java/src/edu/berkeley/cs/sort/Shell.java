package edu.berkeley.cs.sort;

public class Shell<T extends Comparable> extends Sort<T> {
  @Override
  public void sort(T[] input) {
    int h = 1;
    while (h < input.length / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < input.length; i++) {
        for (int j = i; j >= h && less(input[j], input[j - h]); j -= h) {
          swap(input, j, j - h);
        }
      }

      h = h / 3;
    }
  }
}
