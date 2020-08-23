package com.ac.test.base;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseSearch {
  /**
   * 时间复杂度O(logN) 空间复杂度O(1) 二分查询
   *
   * @param sourceData
   * @param searchKey
   * @return
   */
  public static int binarySearch(int[] sourceData, int searchKey) {
    int low = 0;
    int high = sourceData.length - 1;
    int mid = -1;
    int guess = Integer.MIN_VALUE;
    while (low <= high) {
      mid = (low + high) / 2;
      guess = sourceData[mid];
      if (searchKey == guess) {
        return mid;
      }
      if (searchKey > guess) {
        low = mid + 1;
        continue;
      }
      high = mid;
    }
    return -1;
  }

  /**
   * 选择排序
   *
   * @param sourceData
   */
  public static void bubbleSort(int[] sourceData) {
    int temp = 0;
    for (int i = 0; i < sourceData.length - 1; i++) {
      for (int j = i; j < sourceData.length - 1; j++) {
        if (sourceData[j] > sourceData[j + 1]) {
          temp = sourceData[j];
          sourceData[j] = sourceData[j + 1];
          sourceData[j + 1] = temp;
        }
      }
    }
  }

  /**
   * 冒泡排序
   *
   * @param sourceData
   */
  public static void selectSort(int[] sourceData) {
    int index;
    for (int i = 0; i < sourceData.length - 1; i++) {
      index = i;
      for (int j = i; j < sourceData.length; j++) {
        if (sourceData[i] > sourceData[j]) {
          index = j;
        }
      }
      if (index == i) {
        continue;
      }
      int temp = sourceData[i];
      sourceData[i] = sourceData[index];
      sourceData[index] = temp;
    }
  }

  public static int[] initSourceData() {
    return new int[] {6, 10, 11, 23};
  }

  /**
   * 递归实现求和 时间复杂度O(n) 空间复杂度O(n2)
   *
   * @param sourceData
   * @return
   */
  public static int sumRecurse(int[] sourceData) {
    if (sourceData == null || sourceData.length == 0) {
      return 0;
    }
    if (sourceData.length == 1) {
      return sourceData[0];
    }

    return sourceData[0] + sumRecurse(Arrays.copyOfRange(sourceData, 1, sourceData.length));
  }

  /**
   * 递归实现计算包含个数 时间复杂度O(n) 空间复杂度O(n2)
   *
   * @param sourceData
   * @return
   */
  public static int countRecurse(int[] sourceData) {
    if (sourceData == null || sourceData.length == 0) {
      return 0;
    }
    if (sourceData.length == 1) {
      return 1;
    }

    return 1 + countRecurse(Arrays.copyOfRange(sourceData, 1, sourceData.length));
  }

  /**
   * 递归查询最大值 递归实现计算包含个数 时间复杂度O(n) 空间复杂度O(n2)
   *
   * @param sourceData
   * @return
   */
  public static int maxRecurse(int[] sourceData) {
    if (sourceData == null || sourceData.length == 0) {
      return Integer.MIN_VALUE;
    }
    if (sourceData.length == 1) {
      return sourceData[0];
    }
    return Math.max(
        sourceData[0], maxRecurse(Arrays.copyOfRange(sourceData, 1, sourceData.length)));
  }

  /***
   * 递归二分查询
   * 时间复杂度O(logN)
   * 空间复杂度(n-(1/2)^n)
   * @param sourceData
   * @param searchKey
   * @return
   */
  public static int binaryRecurse(int[] sourceData, int searchKey) {
    if (sourceData == null || sourceData.length == 0) {
      return -1;
    }
    int mid = (0 + sourceData.length - 1) / 2;
    int low = -1;
    int high = -1;
    if (sourceData[mid] == searchKey) {
      return mid;
    }
    if (sourceData[mid] > searchKey) {
      low = 0;
      high = mid;
    } else {
      low = mid;
      high = sourceData.length;
    }

    return binaryRecurse(Arrays.copyOfRange(sourceData, low, high), searchKey);
  }

  /**
   * 快速排序
   *
   * @param sourceData
   * @return
   */
  public static List<Integer> quickSearch(List<Integer> sourceData) {
    if (CollectionUtils.size(sourceData) <= 2) {
      return sourceData;
    }
    int pivot = sourceData.get(0);
    List<Integer> less = new ArrayList<>();
    List<Integer> more = new ArrayList<>();
    for (int i = 1; i < sourceData.size(); i++) {
      if (pivot > sourceData.get(i)) {
        less.add(sourceData.get(i));
      } else {
        more.add(sourceData.get(i));
      }
    }
    List<Integer> result = Lists.newArrayList();
    result.addAll(quickSearch(less));
    result.add(pivot);
    result.addAll(quickSearch(more));
    return result;
  }

  /** @param args */
  public static void main(String[] args) {
    //    int[] sourceData = initSourceData();
    List<Integer> sourceDataList = initSourceDataList();
    //        int search = binarySearch(sourceData, 9);
    //    selectSort(sourceData);

    //    selectSort(sourceData);

    //    int sum = sumRecurse(sourceData);
    //    System.out.println(sum);
    //    int total = countRecurse(sourceData);
    //    System.out.println(total);
    //
    //    int max = maxRecurse(sourceData);
    //    System.out.println(max);
    //    binaryRecurse(sourceData, 11);
    quickSearch(sourceDataList);
  }

  private static List<Integer> initSourceDataList() {
    return Lists.newArrayList(1, 9, 5, 10, 20, 8);
  }
}
