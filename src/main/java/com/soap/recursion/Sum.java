package com.soap.recursion;

/**
 * 재귀를 이용해 배열의 합을 구하시오.
 */
public class Sum {
    public static void main(String[] args) {
        int sum = sum(5, new int[]{1, 2, 3, 4, 5});
        System.out.println(sum);
    }

    public static int sum(int n, int[] data) {
        if (n == 0) {
            return 0;
        }
        return sum(n - 1, data) + data[n - 1];
    }

}
