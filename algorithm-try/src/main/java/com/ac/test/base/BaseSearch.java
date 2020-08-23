package com.ac.test.base;

public class BaseSearch {
    /**
     * 时间复杂度O(logN)
     * 空间复杂度O(1)
     * 二分查询
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
    public static void selectSort(int[] sourceData) {
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

    public static void bubbleSort(int[] sourceData) {
        int index;
        for (int i = 0; i < sourceData.length - 1; i++) {
            index = i;
            for (int j = i; j < sourceData.length - 1; j++) {
                if (sourceData[j] > sourceData[j + 1]) {
                    temp = sourceData[j];
                    sourceData[j] = sourceData[j + 1];
                    sourceData[j + 1] = temp;
                }
            }
        }
    }

    public static int[] initSourceData() {
        return new int[]{6, 10, 11, 9};
    }

    public static void main(String[] args) {
        int[] sourceData = initSourceData();
//        int search = binarySearch(sourceData, 9);
        selectSort(sourceData);
    }
}
