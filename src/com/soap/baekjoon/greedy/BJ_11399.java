package com.soap.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_11399 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        int result = 0;
        StringTokenizer st1 = new StringTokenizer(in.nextLine(), " ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i <= arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp += arr[j];
            }
            result += temp;
        }

        System.out.println(result);

    }
}
