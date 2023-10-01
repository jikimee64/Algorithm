package com.soap.recursion;

/**
 * 반띵해서 앞쪽에서 찾고 뒤쪽에서 찾고 거기서 큰거 비교
 */
public class MaxSearchV2 {
    public static void main(String[] args) {

    }

    int findMax(int[] data, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int middle = (begin + end) / 2;
        int max = findMax(data, begin, middle);
        int max2 = findMax(data, middle + 1, end);

        return Math.max(max, max2);
    }

}
