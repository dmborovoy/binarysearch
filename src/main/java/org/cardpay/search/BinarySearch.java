package org.cardpay.search;

public interface BinarySearch {
    /**
     * @param arr the search array, always sorted in ascending order
     * @param val the value to search for
     * @return the index of val in arr.  Return -1 if not found
     */
    int binSearch(int[] arr, int val);
}
