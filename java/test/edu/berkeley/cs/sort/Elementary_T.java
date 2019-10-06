package edu.berkeley.cs.sort;

import edu.berkeley.cs.util.Utilities;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class Elementary_T {
  private int n = 1000;

  @Test
  public void testInsertionSort() {
    Insertion<Integer> insertion = new Insertion<>();

    Integer[] actual = Utilities.generateRandomArray(n);
    Integer[] expected = Arrays.copyOf(actual, actual.length);

    Arrays.sort(expected);
    insertion.sort(actual);

    Assert.assertArrayEquals(expected, actual);
    Assert.assertTrue(insertion.compares() < (Math.pow(n, 2) - n) / 2);
    Assert.assertTrue(insertion.swaps() < (Math.pow(n, 2) - n) / 2);
  }

  @Test
  public void testInsertionSortSubArray() {
    Insertion<Integer> insertion = new Insertion<>();
    Integer[] input = Utilities.generateRandomArray(n);

    int low = (int) Math.floor(0.1 * n);
    int high = (int) Math.floor(0.9 * n);
    insertion.sort(input, low, high);

    Assert.assertTrue(Utilities.isSorted(input, low, high));
    Assert.assertFalse(Utilities.isSorted(input, 0, input.length));
  }

  @Test
  public void testSelectionSort() {
    Selection<Integer> selection = new Selection<>();

    Integer[] actual = Utilities.generateRandomArray(n);
    Integer[] expected = Arrays.copyOf(actual, actual.length);

    Arrays.sort(expected);
    selection.sort(actual);

    Assert.assertArrayEquals(expected, actual);
    Assert.assertEquals(499500, selection.compares());
    Assert.assertEquals(1000, selection.swaps());
  }

  @Test
  public void testShellSort() {
    Shell<Integer> shell = new Shell<>();

    Integer[] actual = Utilities.generateRandomArray(n);
    Integer[] expected = Arrays.copyOf(actual, actual.length);

    Arrays.sort(expected);
    shell.sort(actual);

    Assert.assertArrayEquals(expected, actual);
    Assert.assertTrue(shell.compares() < 16000);
    Assert.assertTrue(shell.swaps() < 11000);
  }
}
