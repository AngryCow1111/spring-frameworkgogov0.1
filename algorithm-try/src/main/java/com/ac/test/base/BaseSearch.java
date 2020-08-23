package com.ac.test.base;

public class BaseSearch {
  public static int binarySearch(int[] sourceData, int searchKey) {
    int low = 0;
    int high = sourceData.length - 1;
    int mid = -1;
    int guess = Integer.MIN_VALUE;
    while (low < high) {
      mid = (low + high) / 2;
      guess = sourceData[mid];
      if (searchKey == guess) {
        return mid;
      }
      if (searchKey > guess) {
        low = mid + 1;
        continue;
      }
      high = mid + 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int search = binarySearch(new int[] {1, 3, 5, 9}, 1);
    System.out.println(search);
  }
}
