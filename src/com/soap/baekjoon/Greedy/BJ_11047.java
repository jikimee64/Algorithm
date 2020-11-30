package com.soap.baekjoon.Greedy;

import java.util.Scanner;

public class BJ_11047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0, n = in.nextInt(), k = in.nextInt();
        int[] arr = new int[n];
        for (int w = 0; w < n; w++) arr[w] = in.nextInt();

        for (int j = n - 1; j >= 0; j--) {
            count += k / arr[j];
            k = k % arr[j];
        }
        System.out.println(count);
    }
}
