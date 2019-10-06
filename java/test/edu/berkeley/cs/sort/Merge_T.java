package edu.berkeley.cs.sort;

import edu.berkeley.cs.util.LinkedList;
import edu.berkeley.cs.util.Utilities;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Merge_T {
  private int n = 1000;
  private Merge<Integer> merge;

  @Before
  public void setup() {
    merge = new Merge<>();
  }

  @Test
  public void testMergeSort() {
    Integer[] actual = Utilities.generateRandomArray(n);
    Integer[] expected = Arrays.copyOf(actual, actual.length);

    Arrays.sort(expected);
    merge.sort(actual);

    Assert.assertArrayEquals(expected, actual);
    Assert.assertTrue(merge.compares() < n * Math.log(n) / Math.log(2));
  }

  @Test
  public void testInsertionSortCutoff() {
    merge.sort(Utilities.generateRandomArray(n));
    Assert.assertNotEquals(0, merge.insertion.swaps());
    Assert.assertNotEquals(0, merge.insertion.compares());
  }

  @Test
  public void testLinearTimeSortedInput() {
    Integer[] input = new Integer[n];
    for (int i = 0; i < n; i++) {
      input[i] = i;
    }

    merge.sort(input);

    boolean linearTime = (merge.compares() == n - 1); // no insertion sort cutoff
    linearTime |= (merge.compares() == 255); // insertion sort cutoff
    Assert.assertTrue(linearTime);
  }

  @Test
  public void testLinkedListMergeSort() {
    LinkedList<Integer> list = new LinkedList<>();

    Integer[] array = Utilities.generateRandomArray(n);
    for (int element : array) {
      list.insertEnd(element);
    }

    list = merge.sort(list);

    int prev = Integer.MIN_VALUE;
    while (!list.isEmpty()) {
      int front = list.removeFront();
      Assert.assertTrue(prev + " was not <= " + front, prev <= front);
      prev = front;
    }
  }
}
