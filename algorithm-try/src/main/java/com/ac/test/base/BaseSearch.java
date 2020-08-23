package com.ac.test.base;

public class BaseSearch {
  public static int binarySearch(int[] sourceData, int searchKey) {
    int low = 0;
    int high = sourceData.length;
    while (low < high) {
      int mid = (low + high) / 2;
      if (searchKey == sourceData[mid]) {
        return mid;
      }
      if (searchKey > mid) {}
    }
  }
}
