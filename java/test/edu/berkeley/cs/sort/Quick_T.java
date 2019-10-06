package edu.berkeley.cs.sort;

import edu.berkeley.cs.util.Utilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Quick_T {
  private int n = 1000;
  private Quick<Integer> quick;

  @Before
  public void setup() {
    quick = new Quick<>();
  }

  @Test
  public void testQuickSort() {
    Integer[] actual = Utilities.generateRandomArray(n);
    Integer[] expected = Arrays.copyOf(actual, actual.length);

    Arrays.sort(expected);
    quick.sort(actual);

    Assert.assertArrayEquals(expected, actual);
    Assert.assertTrue(quick.swaps() < n * Math.log(n) / Math.log(2));
  }

  @Test
  public void testInsertionSortCutoff() {
    quick.sort(Utilities.generateRandomArray(n));
    Assert.assertNotEquals(0, quick.insertion.swaps());
    Assert.assertNotEquals(0, quick.insertion.compares());
  }

  @Test
  public void testMedianPivotSelectionMiddle() {
    Integer[] array = new Integer[] {1, 2, 3};
    Assert.assertEquals(1, quick.getPivotIndex(array, 0, array.length - 1));
  }

  @Test
  public void testMedianPivotSelectionFirst() {
    Integer[] array = new Integer[] {2, 1, 3};
    Assert.assertEquals(0, quick.getPivotIndex(array, 0, array.length - 1));
  }

  @Test
  public void testMedianPivotSelectionLast() {
    Integer[] array = new Integer[] {3, 1, 2};
    Assert.assertEquals(2, quick.getPivotIndex(array, 0, array.length - 1));
  }
}
