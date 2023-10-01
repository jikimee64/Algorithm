package com.soap.recursion;

/**
 * 반씩 조사해서 찾는 방법x
 */
public class SeqSearchV2 {

    public static void main(String[] args) {

    }

    int search(int[] data, int begin, int end, int target) {
        if (begin < end) {
            return -1;
        } else {
            int middle = (begin + end) / 2;
            if (data[middle] == target) {
                return middle;
            }
            int front = search(data, begin, middle - 1, target);
            if (-1 != front) {
                return front;
            } else {
                return search(data, middle + 1, end, target);
            }
        }
    }

}
