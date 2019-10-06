package edu.berkeley.cs.sort;

public abstract class Sort<T extends Comparable> {
  private int swaps = 0;
  private int compares = 0;
  protected final int cutoff = 5;

  public abstract void sort(T[] input);

  public int swaps() {
    return swaps;
  }

  public int compares() {
    return compares;
  }

  protected boolean less(T v, T w) {
    compares++;
    return v.compareTo(w) < 0;
  }

  protected void swap(T[] a, int i, int j) {
    swaps++;
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
