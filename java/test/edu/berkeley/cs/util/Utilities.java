package edu.berkeley.cs.util;

import java.util.Random;

public class Utilities {
  private static Random random = new Random();

  public static Integer[] generateRandomArray(int size) {
    Integer[] array = new Integer[size];

    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt((int) Math.pow(size, 2));
    }

    return array;
  }

  public static boolean isSorted(Comparable[] input, int low, int high) {
    for (int i = low + 1; i < high; i++) {
      if (input[i - 1].compareTo(input[i]) > 0) {
        return false;
      }
    }

    return true;
  }
}
