package com.soap.baekjoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2217 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[5];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }



        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sum[5-n] += arr[5-n];
            }
        }

        Arrays.sort(arr);
        System.out.println(sum[n-1]);

    }
}
