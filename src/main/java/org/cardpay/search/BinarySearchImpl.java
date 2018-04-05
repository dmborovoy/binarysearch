package org.cardpay.search;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchImpl implements BinarySearch {

//    TODO: maybe add validation about empty or null input array but limitation on using IF statement is confusing me

    public int binSearch(int[] arr, int val) {
        return performBinarySearch(arr, val, 0, arr.length);
    }

    private int performBinarySearch(int[] arr, int val, int low, int high) {
        log.debug("low: {}, high: {}", low, high);
        return low > high ? -1 : validateBoundaries(arr, val, low, high);
    }

    private int validateBoundaries(int[] arr, int val, int low, int high) {
        int mid = (low + high) / 2;
        return mid >= arr.length ? -1 : isMatch(arr, val, low, high, mid);
    }

    private int isMatch(int[] arr, int val, int low, int high, int mid) {
        return arr[mid] == val ? mid : incrementBoundaries(arr, val, low, high, mid);
    }

    private int incrementBoundaries(int[] arr, int val, int low, int high, int mid) {
        int newLow = val < arr[mid] ? low : mid + 1;
        int newHigh = val < arr[mid] ? mid - 1 : high;
        return performBinarySearch(arr, val, newLow, newHigh);
    }
}
